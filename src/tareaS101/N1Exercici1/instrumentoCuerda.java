package tareaS101.N1Exercici1;

public class instrumentoCuerda extends instrumento {

	public instrumentoCuerda()
	{
		System.out.println("clase cuerda");
		this.nombre = "guitarra";
		this.precio = 120;
	}
	
	public String tocar()
	{
		//return super.tocar() + " de corda.";
		return "Està sonant un instrument de corda.";
		
	}

}
