package cat.itacademy.barcelonactiva.cidherrera.jorge.s05.t02.n01.model.services;

import java.util.List;

import cat.itacademy.barcelonactiva.cidherrera.jorge.s05.t02.n01.model.dto.GameDTO;

public interface IGameService {
	public List<GameDTO> getAllGames();
	public GameDTO getGameById(String id);
	public void deletGameById(String id);
	public GameDTO createGame(GameDTO game);
	public GameDTO updateGame(GameDTO game);
	public List<GameDTO> getGamesByPlayerId(int playerId);
}
