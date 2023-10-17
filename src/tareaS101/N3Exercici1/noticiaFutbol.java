package tareaS101.N3Exercici1;

public class noticiaFutbol extends noticia {
	private String competicio;
	private String club;
	private String jugador;

	private final float PREUBASE = 300;
	private final float INCREMENTO_COMPETICIO = 100;
	private final float INCREMENTO_CLUB = 100;
	private final float INCREMENTO_JUGADOR = 50;

	private final int PUNTSBASE = 5;
	private final int INCREMENTO_PUNTS_COMPETICIO_CAMPIONS = 3;
	private final int INCREMENTO_PUNTS_COMPETICIO = 2;
	private final int INCREMENTO_PUNTS_CLUB = 1;
	private final int INCREMENTO_PUNTS_JUGADOR = 1;

	public noticiaFutbol(String titular, String competicio, String club, String jugador) {

		this.titular = titular;
		this.text = "";
		this.preu = PREUBASE;
		this.puntuacio = PUNTSBASE;
		this.competicio = competicio;
		this.club = club;
		this.jugador = jugador;
		this.calcularPreuNoticia();
		this.calcularPuntuacioNoticia();
	}

	private void calculaIncrements() {
		this.incrementPreu = 0;
		this.incrementPunts = 0;

		if (this.competicio.toLowerCase().equals("lliga de campions")) {
			this.incrementPreu += INCREMENTO_COMPETICIO;
			this.incrementPunts += INCREMENTO_PUNTS_COMPETICIO_CAMPIONS;
		}
		if (this.competicio.toLowerCase().equals("lliga")) {
			this.incrementPunts += INCREMENTO_PUNTS_COMPETICIO;
		}
		if (this.club.toLowerCase().equals("barça") || this.club.toLowerCase().equals("madrid")) {
			this.incrementPreu += INCREMENTO_CLUB;
			this.incrementPunts += INCREMENTO_PUNTS_CLUB;
		}
		if (this.jugador.toLowerCase().equals("ferran torres") || 
				this.jugador.toLowerCase().equals("benzema")) {
			this.incrementPreu += INCREMENTO_JUGADOR;
			this.incrementPunts += INCREMENTO_PUNTS_JUGADOR;
		}
	}

	public void calcularPreuNoticia() {
		this.calculaIncrements();
		this.preu = PREUBASE + this.incrementPreu;
	}

	public void calcularPuntuacioNoticia() {
		this.calculaIncrements();
		this.puntuacio = PUNTSBASE + this.incrementPunts;
	}

	// setters
	public void setCompeticio(String competicio) {
		this.competicio = competicio;
		this.calcularPreuNoticia();
		this.calcularPuntuacioNoticia();
	}

	public void setClub(String club) {
		this.club = club;
		this.calcularPreuNoticia();
		this.calcularPuntuacioNoticia();
	}

	public void setJugador(String jugador) {
		this.jugador = jugador;
		this.calcularPreuNoticia();
		this.calcularPuntuacioNoticia();
	}

}
