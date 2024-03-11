package cat.itacademy.barcelonactiva.cidherrera.jorge.s05.t02.n01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cat.itacademy.barcelonactiva.cidherrera.jorge.s05.t02.n01.exceptions.PlayerNameAlreadyExist;
import cat.itacademy.barcelonactiva.cidherrera.jorge.s05.t02.n01.model.domain.Player;
import cat.itacademy.barcelonactiva.cidherrera.jorge.s05.t02.n01.model.dto.PlayerDTO;
import cat.itacademy.barcelonactiva.cidherrera.jorge.s05.t02.n01.model.services.IPlayerService;

@Controller
@RequestMapping("/v1/player")
public class PlayerController {
	@Autowired
	IPlayerService playerService;

	@GetMapping({ "/create", "/add", "/" })
	public String createPlayer(Model model) {
		PlayerDTO player = new PlayerDTO(new Player());
		model.addAttribute("playerDTO", player);

		return "/views/games/frmCrearPlayer";
	}
	@GetMapping("/{id}")
	public String updatePlayer(@PathVariable("id") int idPlayer,Model model) {
		PlayerDTO player = playerService.getPlayerById(idPlayer);
		model.addAttribute("playerDTO", player);

		return "/views/games/frmUpdatePlayer";
	}

	@PostMapping("/save")
	public String guardar(@ModelAttribute PlayerDTO player, Model model) {
		try {
			playerService.createPlayer(player);
			model.addAttribute("statusMessage",
					"Usuario " + player.getPlayer().getPk_playerID() + " creado correctamente");
			;
		} catch (PlayerNameAlreadyExist ePlayerExist) {
			model.addAttribute("statusMessage", ePlayerExist.getMessage());

			return "/views/games/frmCrearPlayer";
		}
		return showPlayers(model);
	}

	@PostMapping("/update")
	public String update(@ModelAttribute PlayerDTO player, Model model) {
		try {
			playerService.updatePlayer(player);
			
			model.addAttribute("statusMessage",
					"Usuario " + player.getPlayer().getPk_playerID() + " actualizado correctamente");
			;

		} catch (PlayerNameAlreadyExist ePlayerExist) {
			model.addAttribute("statusMessage", ePlayerExist.getMessage());

			return "/views/games/frmUpdatePlayer";
		}
		return showPlayers(model);
	}

	@GetMapping("/players")
	public String showPlayers(Model model) {
		List<PlayerDTO> listPlayers = playerService.getAllPlayers();
		model.addAttribute("titulo", "Lista de Jugadores:");
		model.addAttribute("players", listPlayers);

		return "/views/games/ListPlayers";
	}
	@GetMapping("/ranking")
	public String showRankingPlayers(Model model) {
		List<PlayerDTO> listPlayers = playerService.getRankingPlayers();
		model.addAttribute("titulo", "Lista de Jugadores [Ranking]:");
		model.addAttribute("players", listPlayers);

		return "/views/games/ListPlayers";
	}

}
