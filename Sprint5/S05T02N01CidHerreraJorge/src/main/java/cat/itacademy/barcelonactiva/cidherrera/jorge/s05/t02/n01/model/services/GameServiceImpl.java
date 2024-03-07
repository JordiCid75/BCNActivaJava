package cat.itacademy.barcelonactiva.cidherrera.jorge.s05.t02.n01.model.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.itacademy.barcelonactiva.cidherrera.jorge.s05.t02.n01.model.domain.Game;
import cat.itacademy.barcelonactiva.cidherrera.jorge.s05.t02.n01.model.dto.GameDTO;
import cat.itacademy.barcelonactiva.cidherrera.jorge.s05.t02.n01.model.repository.GameRepository;

@Service
public class GameServiceImpl implements IGameService {

	@Autowired
	GameRepository gameRepository;

	@Override
	public List<GameDTO> getAllGames() {
		try {
			List<GameDTO> games = new ArrayList<GameDTO>();
			gameRepository.findAll().forEach((g) -> games.add(new GameDTO(g)));
			return games;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public List<GameDTO> getGamesByPlayerId(int playerId) {
		try {
			List<GameDTO> games = new ArrayList<GameDTO>();
			gameRepository.findAllByPlayerId(playerId).forEach((g) -> {
				if (g.isVisible())
					games.add(new GameDTO(g));
			});
			return games;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public GameDTO getGameById(String id) {
		Optional<Game> gameData = gameRepository.findById(id);

		if (gameData.isPresent()) {
			if (gameData.get().isVisible()) {
				return new GameDTO(gameData.get());
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	@Override
	public void deletGameById(String id) {
		Optional<Game> gameData = gameRepository.findById(id);

		if (gameData.isPresent()) {
			Game game = gameData.get();
			game.setVisible(false);
			gameRepository.save(game);
		}

	}

	@Override
	public GameDTO createGame(GameDTO game) {
		try {

			Game _game = gameRepository.save(game.getGame());
			System.out.println(_game.getId());
			return new GameDTO(_game);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public GameDTO updateGame(GameDTO game) {
		Optional<Game> gameData = gameRepository.findById(game.getGame().getId());

		if (gameData.isPresent()) {
			Game _game = gameData.get();
			_game.setVisible(game.getGame().isVisible());
			_game.setPlayerId(game.getGame().getPlayerId());
			_game.setValueD1(game.getGame().getValueD1());
			_game.setValueD2(game.getGame().getValueD2());
			return new GameDTO(gameRepository.save(_game));
		} else {
			return null;
		}
	}
//	@Override
//	public double getAveragePercentageByPlayerId(int playerId) {
//		List<GameDTO> listGames = getGamesByPlayerId(playerId);
//		Double sumPerc = listGames.fo
//		return 0;
//	}


}
