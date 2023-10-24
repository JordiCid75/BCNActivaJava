package TareaS105.N1Exercici3;

import java.nio.file.*;

import java.util.Collections;
import java.util.Iterator;

public class main {

	public static void main(String[] args) {
		Path dir = Paths.get(args[0]);
		String nombreFichero = "Resultado.txt";
		FileExplorer f = new FileExplorer();
		f.cargarContenidoPath(dir);
		Iterator it = f.getContenidoCargado();
		Resultado r = new Resultado(nombreFichero);
		while (it.hasNext()) {
			String s = (String) it.next();
			System.out.println(s);

			// faltaría buscar el elemento en la lista de ficheros
			System.out.println(f.ficheros.get(s));
			r.escribirEnFichero(f.ficheros.get(s).toString());
			//r.escribirEnFichero();
		}

		
	}

}
