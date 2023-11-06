package TareaS104.N1Exercici2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class JUnitCalculoDNI {

	@ParameterizedTest
	@CsvSource({ "43530031,R", "43530030,T", "43530032,W", "43530033,A", "43530034,G", "43530035,M",
			"43530036,Y", "43530037,F", "43530038,P", "43530039,D", "43530040,X" })

	void calculo_letra_DNI(int dni, char letra) {

		char letraDni = CalculoDni.obtenerLetraDNI(dni);
		assertEquals(letraDni, letra);

	}

}
