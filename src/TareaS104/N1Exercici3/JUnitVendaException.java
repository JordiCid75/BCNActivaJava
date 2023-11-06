package TareaS104.N1Exercici3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class JUnitVendaException {

	@Test
	void controlFueraDeIndice() {
		Venda v = new Venda();
		assertThrows(IndexOutOfBoundsException.class,() -> v.calcularTotal());
	}

}
