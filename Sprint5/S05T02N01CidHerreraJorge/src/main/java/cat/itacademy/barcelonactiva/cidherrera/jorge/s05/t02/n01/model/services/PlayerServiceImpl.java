package cat.itacademy.barcelonactiva.cidherrera.jorge.s05.t02.n01.model.services;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.itacademy.barcelonactiva.cidherrera.jorge.s05.t02.n01.exceptions.PlayerNameAlreadyExist;
import cat.itacademy.barcelonactiva.cidherrera.jorge.s05.t02.n01.model.domain.Player;
import cat.itacademy.barcelonactiva.cidherrera.jorge.s05.t02.n01.model.dto.GameDTO;
import cat.itacademy.barcelonactiva.cidherrera.jorge.s05.t02.n01.model.dto.PlayerDTO;
import cat.itacademy.barcelonactiva.cidherrera.jorge.s05.t02.n01.model.repository.GameRepository;
import cat.itacademy.barcelonactiva.cidherrera.jorge.s05.t02.n01.model.repository.PlayerRepository;

@Service
public class PlayerServiceImpl implements IPlayerService {

	private final String PLAYER_ANONYMUS = "ANÒNIM";

	@Autowired
	PlayerRepository playerRepository;
	@Autowired
	IGameService gameService;

	private double getPercentageGames(Player player) {
		int numelements = gameService.getGamesByPlayerId(player.getPk_playerID()).size();
		double sumPerc = gameService.getGamesByPlayerId(player.getPk_playerID()).stream()
				.mapToDouble(GameDTO::getPercentageWin).sum();
		if (numelements == 0)
			numelements = 1;
		return sumPerc / numelements;

	}

	private void isWinner(PlayerDTO player, OptionalDouble maxValue) {
		if (maxValue.isPresent()) {
			if (player.getPercentageAvg().equals(maxValue.getAsDouble()))
				player.setWinner(true);
		}
	}

	private void isLoser(PlayerDTO player, OptionalDouble minValue) {
		if (minValue.isPresent()) {
			if (player.getPercentageAvg().equals(minValue.getAsDouble()))
				player.setLoser(true);
		}
	}

	@Override
	public List<PlayerDTO> getAllPlayers() {
		try {
			List<PlayerDTO> players = new ArrayList<PlayerDTO>();
			playerRepository.findAll().forEach((p) -> players.add(new PlayerDTO(p)));
			players.forEach((p) -> p.setPercentageAvg(getPercentageGames(p.getPlayer())));
			players.forEach((p) -> isWinner(p, players.stream().mapToDouble(PlayerDTO::getPercentageAvg).max()));
			players.forEach((p) -> isLoser(p, players.stream().mapToDouble(PlayerDTO::getPercentageAvg).min()));
			return players;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public PlayerDTO getPlayerById(int id) {
		Optional<Player> playerData = playerRepository.findById(id);

		if (playerData.isPresent()) {
			return new PlayerDTO(playerData.get());
		} else {
			return null;
		}
	}

	@Override
	public void deletePlayerById(int id) {
		playerRepository.deleteById(id);
	}

	@Override
	public PlayerDTO createPlayer(PlayerDTO player) throws PlayerNameAlreadyExist {
		if (player.getPlayer().getPlayerName().isBlank()) {
			player.getPlayer().setPlayerName(PLAYER_ANONYMUS);
		} else {
			Optional<Player> playerData = playerRepository
					.findByPlayerNameIgnoreCase(player.getPlayer().getPlayerName());
			if (playerData.isPresent() && !playerData.get().getPlayerName().equals(PLAYER_ANONYMUS)) {
				throw new PlayerNameAlreadyExist(
						"Already exist Player with given name:" + player.getPlayer().getPlayerName());
			}
		}
		Player _player = playerRepository.save(new Player(player.getPlayer().getPk_playerID(),
				player.getPlayer().getPlayerName(), player.getPlayer().getPlayerRegistrationDate()));
		return new PlayerDTO(_player);
	}

	@Override
	public PlayerDTO updatePlayer(PlayerDTO player) throws PlayerNameAlreadyExist {
		Optional<Player> playerData = playerRepository.findById(player.getPlayer().getPk_playerID());

		if (playerData.isPresent()) {
			Player _player = playerData.get();
			if (player.getPlayer().getPlayerName().isBlank()) {
				player.getPlayer().setPlayerName(PLAYER_ANONYMUS);
			} else {
				Optional<Player> playerDataExist = playerRepository
						.findByPlayerNameIgnoreCase(player.getPlayer().getPlayerName());
				if (playerDataExist.isPresent()) {
					throw new PlayerNameAlreadyExist(
							"Already exist Player with given name:" + player.getPlayer().getPlayerName());
				}
			}
			_player.setPlayerName(player.getPlayer().getPlayerName());
			return new PlayerDTO(playerRepository.save(_player));
		} else {
			return null;
		}
	}

	@Override
	public PlayerDTO getPlayerByName(String name) {
		Optional<Player> playerData = playerRepository.findByPlayerNameIgnoreCase(name);
		if (playerData.isPresent()) {
			Player _player = playerData.get();
			return new PlayerDTO(_player);
		} else {
			return null;
		}
	}

	@Override
	public List<PlayerDTO> getRankingPlayers() {
		try {
			List<PlayerDTO> players = getAllPlayers();
			return players.stream().sorted(Comparator.comparingDouble(PlayerDTO::getPercentageAvg).reversed()).toList();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

}
