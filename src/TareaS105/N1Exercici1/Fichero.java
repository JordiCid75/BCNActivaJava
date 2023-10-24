package TareaS105.N1Exercici1;

import java.nio.file.Path;
import java.nio.file.attribute.FileTime;

public class Fichero {
	String nombre;
	FileTime fechaModificacion;
	Path path;
	String tipo;

	@Override
	public String toString() {
		return path + "/" + nombre + " " + tipo + " " + fechaModificacion;
	}

}
