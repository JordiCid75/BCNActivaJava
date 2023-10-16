package tareaS101.N1Exercici1;

public class instrumentoViento extends instrumento {

	public instrumentoViento()
	{
		System.out.println("clase viento");
		this.nombre = "Trompeta";
		this.precio = 120;
	}
	
	public String tocar()
	{
		return "Està sonant un instrument de vent.";
		
	}

}
