package cat.itacademy.barcelonactiva.cidherrera.jorge.s05.t02.n01.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cat.itacademy.barcelonactiva.cidherrera.jorge.s05.t02.n01.model.domain.Game;
import cat.itacademy.barcelonactiva.cidherrera.jorge.s05.t02.n01.model.dto.GameDTO;
import cat.itacademy.barcelonactiva.cidherrera.jorge.s05.t02.n01.model.dto.PlayerDTO;
import cat.itacademy.barcelonactiva.cidherrera.jorge.s05.t02.n01.model.services.IGameService;
import cat.itacademy.barcelonactiva.cidherrera.jorge.s05.t02.n01.model.services.IPlayerService;

@Controller
@RequestMapping("/players")
public class GameController {

	private final IGameService gameService;
	private final IPlayerService playerService;

	@Autowired
	public GameController(IGameService gService, IPlayerService plService) {
		this.gameService = gService;
		this.playerService = plService;
	}

	@GetMapping({ "/{id}/games", "/{id}/games/" })
	public String showPlayerGames(@PathVariable("id") int idPlayer, Model model) {
		List<GameDTO> listGamesByPlayer = gameService.getGamesByPlayerId(idPlayer);
		model.addAttribute("titulo", "Lista de tiradas para Jugador: " + idPlayer);
		model.addAttribute("games", listGamesByPlayer);
		model.addAttribute("playerId", idPlayer);

		return "/views/games/ListPlayerGames";
	}

	@GetMapping({ "/{id}/game", "/{id}/game/" })
	public String newPlayerGame(@PathVariable("id") int idPlayer, Model model) {
		PlayerDTO player = playerService.getPlayerById(idPlayer);
		Game game = new Game(player.getPlayer());
		GameDTO gameDTO = new GameDTO(game);
		gameDTO.setPlayer(player.getPlayer());
		gameService.createGame(gameDTO);

		List<GameDTO> listGamesByPlayer = gameService.getGamesByPlayerId(idPlayer);
		model.addAttribute("titulo", "Lista de tiradas para Jugador: " + idPlayer);
		model.addAttribute("games", listGamesByPlayer);
		model.addAttribute("playerId", idPlayer);

		return "/views/games/ListPlayerGames";
	}

	@GetMapping({ "/{id}/delete", "/{id}/delete/" })
	public String deletePlayerGame(@PathVariable("id") int idPlayer, Model model) {
		List<GameDTO> listGamesByPlayer = gameService.getGamesByPlayerId(idPlayer);
		listGamesByPlayer.forEach((g) -> gameService.deletGameById(g.getGame().getId()));

		listGamesByPlayer = gameService.getGamesByPlayerId(idPlayer);
		model.addAttribute("titulo", "Lista de tiradas para Jugador: " + idPlayer);
		model.addAttribute("games", listGamesByPlayer);
		model.addAttribute("playerId", idPlayer);

		return "/views/games/ListPlayerGames";
	}
}
