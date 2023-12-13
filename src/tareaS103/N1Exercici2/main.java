package tareaS103.N1Exercici2;

import java.util.ArrayList;
import java.util.ListIterator;

public class main {

	public static void main(String[] args) {
		ArrayList<Integer> lista1 = new ArrayList<Integer>();
		ArrayList<Integer> lista2 = new ArrayList<Integer>();
		
		for (int i = 1; i<=10; i++)
		{
			lista1.add(i);
		}
		System.out.println("lista1:");
		lista1.forEach(System.out::println);

		// nos posicionamos en el ultimo elemento
		ListIterator<Integer> itr = lista1.listIterator(lista1.size());
		
		// ahora iteramos al revés
		while (itr.hasPrevious())
		{
			lista2.add(itr.previous());
		}
		
		System.out.println("lista2:");
		
		lista2.forEach(System.out::println);
		System.out.println("lista1:");
		lista1.forEach(System.out::println);
	}

}
