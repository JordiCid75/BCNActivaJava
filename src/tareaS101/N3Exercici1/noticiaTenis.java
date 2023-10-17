package tareaS101.N3Exercici1;

public class noticiaTenis extends noticia{
	private String competicio;
	private String tenistes;	
	private final float PREUBASE = 150;
	private final float INCREMENTO_TENISTA = 100;

	private final int PUNTSBASE = 4;
	private final int INCREMENTO_PUNTS_TENISTA = 3;

	public noticiaTenis(String titular, String competicio, String tenistes) {

		this.titular = titular;
		this.text = "";
		this.preu = PREUBASE;
		this.puntuacio= PUNTSBASE;
		this.competicio = competicio;
		this.tenistes = tenistes;
		this.calcularPreuNoticia();
		this.calcularPuntuacioNoticia();
	}

	private void calculaIncrements() {
		this.incrementPreu = 0;
		this.incrementPunts = 0;

		if (this.tenistes.toLowerCase().equals("federer") || 
				this.tenistes.toLowerCase().equals("nadal") ||
				this.tenistes.toLowerCase().equals("djokovic")
				) {
			this.incrementPreu += INCREMENTO_TENISTA;
			this.incrementPunts += INCREMENTO_PUNTS_TENISTA;
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

	public void setTenistes(String tenistes) {
		this.tenistes = tenistes;
		this.calcularPreuNoticia();
		this.calcularPuntuacioNoticia();
	}

	
}
