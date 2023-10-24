package tareaS102.N1Exercici1;

import java.util.ArrayList;

public class Venda {

	final String msg = "Per fer una venda primer has d'afegir productes";
	ArrayList<Producte> productList = new ArrayList<Producte>();
	float preuTotal;


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
