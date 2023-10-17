package tareaS101.N3Exercici1;

public class noticiaBasquet extends noticia {
	private String competicio;
	private String club;

	private final float PREUBASE = 250;
	private final float INCREMENTO_COMPETICIO = 75;
	private final float INCREMENTO_CLUB = 75;

	private final int PUNTSBASE = 4;
	private final int INCREMENTO_PUNTS_COMPETICIO_EUROLLIGA = 3;
	private final int INCREMENTO_PUNTS_COMPETICIO = 2;
	private final int INCREMENTO_PUNTS_CLUB = 1;

	public noticiaBasquet(String titular, String competicio, String club) {

		this.titular = titular;
		this.text = "";
		this.preu = PREUBASE;
		this.puntuacio = PUNTSBASE;
		this.competicio = competicio;
		this.club = club;
		this.calcularPreuNoticia();
	}

	private void calculaIncrements() {
		this.incrementPreu = 0;
		this.incrementPunts = 0;

		if (this.competicio.toLowerCase().equals("eurolliga")) {
			this.incrementPreu += INCREMENTO_COMPETICIO;
			this.incrementPunts += INCREMENTO_PUNTS_COMPETICIO_EUROLLIGA;
		}
		if (this.competicio.toLowerCase().equals("acb")) {
			this.incrementPreu += INCREMENTO_COMPETICIO;
			this.incrementPunts += INCREMENTO_PUNTS_COMPETICIO;
		}
		if (this.club.toLowerCase().equals("barça") || this.club.toLowerCase().equals("madrid")) {
			this.incrementPreu += INCREMENTO_CLUB;
			this.incrementPunts += INCREMENTO_PUNTS_CLUB;
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

}
