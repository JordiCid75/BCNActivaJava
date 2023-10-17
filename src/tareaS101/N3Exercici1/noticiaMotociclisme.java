package tareaS101.N3Exercici1;

public class noticiaMotociclisme extends noticia {
	private String equip;
	private final float PREUBASE = 100;
	private final float INCREMENTO_EQUIP = 50;

	private final int PUNTSBASE = 3;
	private final int INCREMENTO_PUNTS_EQUIP = 3;

	public noticiaMotociclisme(String titular, String equip) {

		this.titular = titular;
		this.text = "";
		this.preu = PREUBASE;
		this.puntuacio = PUNTSBASE;
		this.equip = equip;
		this.calcularPreuNoticia();
		this.calcularPuntuacioNoticia();
	}

	private void calculaIncrements() {
		this.incrementPreu = 0;
		this.incrementPunts = 0;

		if (this.equip.toLowerCase().equals("honda") || 
				this.equip.toLowerCase().equals("yamaha")) {
			this.incrementPreu += INCREMENTO_EQUIP;
			this.incrementPunts += INCREMENTO_PUNTS_EQUIP;
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
	public void setEquip(String equip) {
		this.equip = equip;
		this.calcularPreuNoticia();
		this.calcularPuntuacioNoticia();
	}


}
