package cat.itacademy.barcelonactiva.cidherrera.jorge.s05.t02.n01.model.domain;

import java.util.Random;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.*;

// cambiamos las anotaciones para pasar de mySQL a MongoBD
// MYSQL
//@Entity
//@Table(name = "Games")
// MongoDB
@Document(collection = "Games")
public class Game {
	@Id
	private String id;

	// @GeneratedValue(strategy = GenerationType.AUTO)
	//private int pk_gameID;
	@Column(name = "visible")
	private boolean visible = true;
	@Column(name = "valueD1")
	private int valueD1;
	@Column(name = "valueD2")
	private int valueD2;
	@Column(name = "playerId")
	private int playerId;

	public Game() {
		newGame();
	}

	public Game(Player pl) {

		playerId = pl.getPk_playerID();
		newGame();
	}

	// para MySQL
	public Game(String id, Player pl, int vd1, int vd2, boolean vis) {

		this.id = id;
		playerId = pl.getPk_playerID();
		valueD1 = vd1;
		valueD2 = vd2;
		visible = vis;
		newGame();
	}

	public void newGame() {
		Random random = new Random();

		valueD1 = random.nextInt(6) + 1;
		valueD2 = random.nextInt(6) + 1;

	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public int getValueD1() {
		return valueD1;
	}

	public void setValueD1(int valueD1) {
		this.valueD1 = valueD1;
	}

	public int getValueD2() {
		return valueD2;
	}

	public void setValueD2(int valueD2) {
		this.valueD2 = valueD2;
	}

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
