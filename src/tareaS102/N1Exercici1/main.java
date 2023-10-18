package tareaS102.N1Exercici1;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Venda v = new Venda();
		try {
			v.calcularTotal();
		} catch (VendaBuidaException e) {
			System.out.println(e.getMessage());
		}
	}

}
