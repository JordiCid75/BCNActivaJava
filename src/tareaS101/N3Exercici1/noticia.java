package tareaS101.N3Exercici1;

public abstract class noticia {

	public String titular;
	public String text;
	public int puntuacio;
	public float preu;
	float incrementPreu;
	int incrementPunts;
	
	public abstract void calcularPreuNoticia();
	// Getters
	public float getPreu()
	{
		return this.preu;
	}
	public int getPuntuacio()
	{
		return this.puntuacio;
	}

}
