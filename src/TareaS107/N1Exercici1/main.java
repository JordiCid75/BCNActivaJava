package TareaS107.N1Exercici1;

public class main {

	public static void main(String[] args) {
		TreballadorOnline to = new TreballadorOnline("Jordi", "Cid", 20);
		TreballadorPresencial tp = new TreballadorPresencial("Javier", "Garcia", 25, 30);
		System.out.println(to.toString() + " " + to.calcularSou(160));
		System.out.println(tp.toString() + " " + tp.calcularSou(160));
		// creamos una variable del tipo Treballador para comprobar que el método al que
		// se llama es el de la subclase
		Treballador t = tp;
		System.out.println(t.toString() + " " + t.calcularSou(160));
		t = to;
		System.out.println(t.toString() + " " + t.calcularSou(160));
		// en cambio si creamos un Treballador normal se llama al método de la clase
		// padre
		Treballador t1 = new Treballador("Jose", "Sanchez", 15);
		System.out.println(t1.toString() + " " + t1.calcularSou(160));

	}

}
