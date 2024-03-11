package cat.itacademy.barcelonactiva.cidherrera.jorge.s05.t02.n01.controller;

import cat.itacademy.barcelonactiva.cidherrera.jorge.s05.t02.n01.model.domain.Player;
import cat.itacademy.barcelonactiva.cidherrera.jorge.s05.t02.n01.model.dto.PlayerDTO;
import cat.itacademy.barcelonactiva.cidherrera.jorge.s05.t02.n01.model.services.IPlayerService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
@RequiredArgsConstructor
public class PlayerControllerREST {
	@Autowired
	IPlayerService playerService;

	@SneakyThrows
	@PostMapping({"","/"})
	public ResponseEntity<PlayerDTO> createPlayer(@RequestBody Player player) {
			PlayerDTO pl = new PlayerDTO(player);
			PlayerDTO newPlayer = playerService.createPlayer(pl);
			return new ResponseEntity<>(newPlayer, HttpStatus.CREATED);
	}

	@SneakyThrows
	@PutMapping({"","/"})
	public ResponseEntity<PlayerDTO> update(@RequestBody Player player) {
		PlayerDTO pl = new PlayerDTO(player);

		return ResponseEntity.ok().body(playerService.updatePlayer(pl));
	}
	@GetMapping("/")
	public ResponseEntity<List<PlayerDTO>> showPlayers() {
		return ResponseEntity.ok().body(playerService.getAllPlayers());
	}
	@GetMapping("/ranking")
	public ResponseEntity<List<PlayerDTO>> showRankingPlayers() {
		return ResponseEntity.ok().body(playerService.getRankingPlayers());
	}
	@GetMapping("/ranking/winner")
	public ResponseEntity<PlayerDTO> showRankingPlayersWinner() {
		return ResponseEntity.ok().body(playerService.getRankingPlayers().get(0));
	}
	@GetMapping("/ranking/loser")
	public ResponseEntity<PlayerDTO> showRankingPlayersLoser() {
		List<PlayerDTO> listPlayers = playerService.getRankingPlayers();
		return ResponseEntity.ok().body(listPlayers.get(listPlayers.size()-1));
	}

}
