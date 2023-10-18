package tareaS102.N1Exercici1;

import java.util.ArrayList;

public class Venda {

	final String msg = "Per fer una venda primer has d'afegir productes";
	ArrayList<Producte> productList = new ArrayList<Producte>();
	float preuTotal;

	public Venda() {
		// TODO Auto-generated constructor stub
		//for (int i = 1; i < 10; i++) {
		//	Producte p = new Producte();
		//	p.nom = "P" + i;
		//	p.preu = i;
		//	productList.add(p);
		//}
	}

	public void calcularTotal() throws VendaBuidaException
	{
		
		try {
			// esto genera la excepcion
			System.out.println(productList.get(1).nom);
			
			for (Producte producte : productList) {
				System.out.println(producte.nom + " | " + producte.preu);
				preuTotal += producte.preu;
			}

		} catch (IndexOutOfBoundsException e) {
			// TODO: handle exception
			throw new VendaBuidaException(msg);
		}
	}
}
