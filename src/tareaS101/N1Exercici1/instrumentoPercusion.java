package tareaS101.N1Exercici1;

public class instrumentoPercusion extends instrumento {
	public instrumentoPercusion()
	{
		System.out.println("clase percusion");
		this.nombre = "bateria";
		this.precio = 150;
	}
	
	public String tocar()
	{
		return "Està sonant un instrument de percusió.";
		
	}

}
