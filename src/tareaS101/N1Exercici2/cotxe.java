package tareaS101.N1Exercici2;

public class cotxe {

	public static final String marca = "Seat";
	public static String model;
	public final float potencia = 150;
	public cotxe() {
		model = "124";
	}
	public static void frenar()
	{
		System.out.println("El Vehicle està frenant.");
	}
	public void accelerar()
	{
		System.out.println("El Vehicle està accelerant.");
	}
}
