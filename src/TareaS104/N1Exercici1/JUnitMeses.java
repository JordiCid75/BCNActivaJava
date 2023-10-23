package TareaS104.N1Exercici1;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class JUnitMeses {

	@Test
	void month_list_not_null() {
		Months m = new Months();
		assertNotNull("Meses no pueden ser nulos",m.meses);
	}
	
	@Test
	void month_list_have_12_items() {
		Months m = new Months();
		assertEquals(m.meses.size(), 12);
	}
	
	@Test
	void month_list_have_agosto_in_pos_8() {
		Months m = new Months();
		assertEquals(m.meses.get(7), "Agosto");
	}

}
