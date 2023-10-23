package TareaS104.N1Exercici2;

public class CalculoDni {
	public static char obtenerLetraDNI(int dni) {
		String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
		return letras.charAt(dni % 23);
	}

}
