package cat.itacademy.barcelonactiva.cidherrera.jorge.s05.t02.n01.model.dto;


import cat.itacademy.barcelonactiva.cidherrera.jorge.s05.t02.n01.model.domain.Player;

public class PlayerDTO {


	public Player player;
	private Double percentageAvg;
	private boolean isWinner;
	private boolean isLoser;

	public PlayerDTO(Player player) {
		this.player = player;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Double getPercentageAvg() {
		return percentageAvg;
	}

	public void setPercentageAvg(Double percentageAvg) {
		this.percentageAvg = percentageAvg;
	}

	public boolean isWinner() {
		return isWinner;
	}

	public void setWinner(boolean isWinner) {
		this.isWinner = isWinner;
	}

	public boolean isLoser() {
		return isLoser;
	}

	public void setLoser(boolean isLoser) {
		this.isLoser = isLoser;
	}

}
