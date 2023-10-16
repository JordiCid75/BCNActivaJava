package tareaS101.N1Exercici1;

public abstract class instrumento {
	String nombre;
	float precio;
	
	public instrumento() {
		System.out.println("clase abstracta");
	}
	
	public abstract String tocar();
	
		//return "Està sonant un instrument";
	

}
