package tareaS103.N1Exercici1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class main {

	private static void mesesArray()
	{
		ArrayList<Month> meses = new ArrayList<Month>();
		final String[] CMESES = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Septiembre", "Octubre", "Noviembre", "Diciembre"};

		System.out.println("Ejercicio con ArrayList:");
		
		for (String string : CMESES) {
			Month mes = new Month();
			mes.name = string;
			meses.add(mes);
		}
		System.out.println("Contenido del array meses inicialmente:");
		for (Month month : meses) {
			System.out.println(month.name);
		}
		
		System.out.println("Añadiendo el mes de Agosto en la posición correcta.");
		
		Month m = new Month();
		m.name = "Agosto";
		meses.add(7, m);

		System.out.println("Contenido del array meses despues de añadir el elemento Agosto:");
		for (Month month : meses) {
			System.out.println(month.name);
		}

	}

	private static void mesesHashSet()
	{
		HashSet<Month> meses = new HashSet<Month>();
		final String[] CMESES = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
		System.out.println("Ejercicio con HashSet:");
		for (String string : CMESES) {
			Month mes = new Month();
			mes.name = string;
			meses.add(mes);
		}
		System.out.println("Contenido del array meses inicialmente:");
		for (Month month : meses) {
			System.out.println(month.name);
		}
		
		System.out.println("Añadiendo el mes de Agosto en la posición correcta.");
		
		Month m = new Month();
		m.name = "Agosto";
		meses.add(m);
		meses.add(m); // porqué no da error?? si el elemento ya está introducido? Algún tipo de warning?
		//meses.add(7, m);
		
		
		// como es una instancia nueva de la clase Month se considera un elemento nuevo diferente al anterior
//		Month m2 = new Month();
//		m2.name = "Agosto";
//		meses.add(m2);

		System.out.println("Contenido del array meses despues de añadir el elemento Agosto con iterador:");
		Iterator<Month> it = meses.iterator();
		while (it.hasNext()) {
			System.out.println(it.next().name);
		}

	}

	public static void main(String[] args) {
		mesesArray();
		mesesHashSet();
	}

}
