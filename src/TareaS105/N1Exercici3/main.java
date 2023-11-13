package TareaS105.N1Exercici3;

import java.nio.file.*;

import java.util.Iterator;

public class main {

	public static void main(String[] args) {
		try {
			if (args.length < 1) {
				System.out.println(
						"Se requiere recibir por linea de comandos el path completo de la carpeta a examinar.");
			} else {
				Path dir = Paths.get(args[0]);
				String nombreFichero = "Resultado.txt";
				FileExplorer f = new FileExplorer();
				System.out.println("Escaneando la carpeta " + dir.getFileName() + " y sus subcarpetas...");
				f.cargarContenidoPath(dir);
				System.out.println("Guardando contenido en " + nombreFichero);
				Iterator it = f.getContenidoCargado();
				Resultado r = new Resultado(nombreFichero);
				while (it.hasNext()) {
					String s = (String) it.next();
					r.escribirEnFichero(f.ficheros.get(s).toString());
				}
				System.out.println("Fichero " + nombreFichero + " Generado con el contenido de la carpeta "
						+ dir.getFileName() + " y sus subcarpetas.");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
