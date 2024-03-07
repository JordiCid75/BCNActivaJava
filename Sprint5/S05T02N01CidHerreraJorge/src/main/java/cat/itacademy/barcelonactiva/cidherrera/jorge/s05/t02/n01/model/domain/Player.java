package cat.itacademy.barcelonactiva.cidherrera.jorge.s05.t02.n01.model.domain;

import java.sql.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.*;

@Entity
@Table(name = "Players")
public class Player {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int pk_playerID;
	@Column(name = "name")
	private String playerName;
	@CreationTimestamp
	private Date playerRegistrationDate;

	public Player(int id, String name, Date date) {
		pk_playerID = id;
		playerName = name;
		playerRegistrationDate = date;
	}

	public Player() {
	}

	public int getPk_playerID() {
		return pk_playerID;
	}

	public void setPk_playerID(int pk_playerID) {
		this.pk_playerID = pk_playerID;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public Date getPlayerRegistrationDate() {
		return playerRegistrationDate;
	}

	public void setPlayerRegistrationDate(Date playerRegistrationDate) {
		this.playerRegistrationDate = playerRegistrationDate;
	}

}
