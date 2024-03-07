package cat.itacademy.barcelonactiva.cidherrera.jorge.s05.t02.n01.model.services;

import java.util.List;

import cat.itacademy.barcelonactiva.cidherrera.jorge.s05.t02.n01.model.dto.PlayerDTO;
import cat.itacademy.barcelonactiva.cidherrera.jorge.s05.t02.n01.exceptions.PlayerNameAlreadyExist;

public interface IPlayerService {
	public List<PlayerDTO> getAllPlayers();

	public PlayerDTO getPlayerById(int id);

	public PlayerDTO getPlayerByName(String name) throws PlayerNameAlreadyExist;

	public void deletePlayerById(int id);

	public PlayerDTO createPlayer(PlayerDTO player) throws PlayerNameAlreadyExist;

	public PlayerDTO updatePlayer(PlayerDTO player) throws PlayerNameAlreadyExist;

	public List<PlayerDTO> getRankingPlayers();

}
