package tareaS101.N1Exercici2;

public class main {

	public static void main(String[] args) {
		// el metodo estático se puede usar sin crear la instancia de la clase
		cotxe.frenar();
		// para usar los métodos no estáticos debe crearse una instancia de la clase
		cotxe coche = new cotxe();
		coche.accelerar();
		// los atributos no estáticos deben ser usados desde la instancia.
		System.out.println(coche.potencia);
		// los atributos estáticos deben ser usados desde la clase 
		System.out.println(cotxe.marca);
		System.out.println(cotxe.model);
		
	}

}
