package cat.itacademy.barcelonactiva.cidherrera.jorge.s05.t02.n01.controller;

import cat.itacademy.barcelonactiva.cidherrera.jorge.s05.t02.n01.model.domain.Game;
import cat.itacademy.barcelonactiva.cidherrera.jorge.s05.t02.n01.model.dto.GameDTO;
import cat.itacademy.barcelonactiva.cidherrera.jorge.s05.t02.n01.model.dto.PlayerDTO;
import cat.itacademy.barcelonactiva.cidherrera.jorge.s05.t02.n01.model.services.IGameService;
import cat.itacademy.barcelonactiva.cidherrera.jorge.s05.t02.n01.model.services.IPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
public class GameControllerREST {

	private final IGameService gameService;
	private final IPlayerService playerService;

	@Autowired
	public GameControllerREST(IGameService gService, IPlayerService plService) {
		this.gameService = gService;
		this.playerService = plService;
	}

	@GetMapping({ "/{id}/games", "/{id}/games/" })
	public ResponseEntity<List<GameDTO>> showPlayerGames(@PathVariable("id") int idPlayer) {
		return ResponseEntity.ok().body(gameService.getGamesByPlayerId(idPlayer));
	}

	@PutMapping({ "/{id}/game", "/{id}/game/" })
	public ResponseEntity<GameDTO> newPlayerGame(@PathVariable("id") int idPlayer) {
		PlayerDTO player = playerService.getPlayerById(idPlayer);
		Game game = new Game(player.getPlayer());
		GameDTO gameDTO = new GameDTO(game);
		gameDTO.setPlayer(player.getPlayer());
		gameService.createGame(gameDTO);

		return new ResponseEntity<>(gameDTO, HttpStatus.CREATED);
	}

	@DeleteMapping({ "/{id}/games", "/{id}/games/" })
	public ResponseEntity<String> deletePlayerGame(@PathVariable("id") int idPlayer) {
		List<GameDTO> listGamesByPlayer = gameService.getGamesByPlayerId(idPlayer);
		listGamesByPlayer.forEach((g) -> gameService.deletGameById(g.getGame().getId()));
		return ResponseEntity.ok().body("Games for id player "+ idPlayer+" properly hided." );
	}
}
