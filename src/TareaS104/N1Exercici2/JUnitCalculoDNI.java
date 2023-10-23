package TareaS104.N1Exercici2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class JUnitCalculoDNI {

	@ParameterizedTest
	@ValueSource(ints = { 43530031, 43530030, 43530032, 43530033, 43530034, 43530035, 43530036, 43530037, 43530038, 43530039, 43530040})
	void calculo_letra_DNI(int dni) {
		assertNotNull(CalculoDni.obtenerLetraDNI(dni));
		
	}

}
