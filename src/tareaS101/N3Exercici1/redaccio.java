package tareaS101.N3Exercici1;

import java.util.ArrayList;

public class redaccio {

	public ArrayList<redactor> redactors = new ArrayList<redactor>();

	public redaccio() {
		
	}
	
	public void afegirRedactor(redactor redactor) {
		this.redactors.add(redactor);
	}

	public void eliminarRedactor(redactor redactor) {
		this.redactors.remove(redactor);
	}

	public redactor buscarRedactor(String dni) {
		for (redactor r : redactors) {
			if (r.DNI.toLowerCase().equals(dni)) {
				return r;
			}
		}
		return null;
	}

	
}
