package tareaS102.N1Exercici1;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Venda v = new Venda();
		try {
			// Esto debería generar la excepción ya que no hemos introducido ningún producto
			// en la venta
			try {
				v.calcularTotal();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			try {
				// con la linea anterior comentada la excepción no debería darse
				System.out.println(v.preuTotal);
				for (int i = 1; i <= 10; i++) {
					Producte p = new Producte();
					p.nom = "Producte" + i;
					p.preu = i;
					v.addProducte(p);
				}
				v.calcularTotal();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			System.out.println("Preu Total Venda " + v.preuTotal);
			// esto provoca el IndexOutOfBoundException y se muestra un mensaje distinto al no pasar por el método CalcularTotal()
			Venda v2  = new Venda();
			System.out.println(v2.productList.get(1).nom);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
