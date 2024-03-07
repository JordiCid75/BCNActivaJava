package cat.itacademy.barcelonactiva.cidherrera.jorge.s05.t02.n01.model.dto;

import cat.itacademy.barcelonactiva.cidherrera.jorge.s05.t02.n01.model.domain.Game;
import cat.itacademy.barcelonactiva.cidherrera.jorge.s05.t02.n01.model.domain.Player;

public class GameDTO {

	private final int WIN_VALUE = 7;
	private Game game;
	private double percentageWin;
	private int result;
	private boolean gameWin;
	private Player player;

	public GameDTO() {
	}

	private double calculatePercentageWin() {
		double percentage;
		int difference = Math.abs(WIN_VALUE - result);
		if (difference == 0) {
			percentage = 100;
		} else {
			percentage = (100 / 6) * (7 - difference);
		}

		return percentage;
	}

	public GameDTO(Game game) {
		this.game = game;
		this.result = game.getValueD1() + game.getValueD2();
		this.gameWin = (this.result == this.WIN_VALUE);
		this.percentageWin = calculatePercentageWin();

	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public double getPercentageWin() {
		return percentageWin;
	}

	public int getResult() {
		return result;
	}

	public boolean isGameWin() {
		return gameWin;
	}

	public void setGameWin(boolean gameWin) {
		this.gameWin = gameWin;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

}
