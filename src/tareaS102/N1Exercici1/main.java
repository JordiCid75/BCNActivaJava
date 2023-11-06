package tareaS102.N1Exercici1;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Venda v = new Venda();
		try {
			// Esto debería generar la excepción
			 v.calcularTotal();
			// con la linea anterior comentada la excepción no debería darse
			System.out.println(v.preuTotal);
			for (int i = 1; i <= 10; i++) {
				Producte p = new Producte();
				p.nom = "Producte" + i;
				p.preu = i;
				v.addProducte(p);
			}
			v.calcularTotal();
			System.out.println("Preu Total Venda " + v.preuTotal);
		} catch (VendaBuidaException e) {
			System.out.println(e.getMessage());
		}
	}

}
