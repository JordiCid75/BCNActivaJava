package tareaS101.N3Exercici1;

public class noticiaF1 extends noticia{
	private String escuderia;
	private final float PREUBASE = 100;
	private final float INCREMENTO_ESCUDERIA = 50;

	private final int PUNTSBASE = 4;
	private final int INCREMENTO_PUNTS_ESCUDERIA = 2;

	public noticiaF1(String titular, String escuderia) {

		this.titular = titular;
		this.text = "";
		this.preu = PREUBASE;
		this.puntuacio = PUNTSBASE;
		this.escuderia = escuderia;
		this.calcularPreuNoticia();
		this.calcularPuntuacioNoticia();
	}

	private void calculaIncrements() {
		this.incrementPreu = 0;
		this.incrementPunts = 0;

		if (this.escuderia.toLowerCase().equals("ferrari") || 
				this.escuderia.toLowerCase().equals("mercedes")) {
			this.incrementPreu += INCREMENTO_ESCUDERIA;
			this.incrementPunts += INCREMENTO_PUNTS_ESCUDERIA;
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
	public void setEscuderia(String escuderia) {
		this.escuderia = escuderia;
		this.calcularPreuNoticia();
		this.calcularPuntuacioNoticia();
	}

}
