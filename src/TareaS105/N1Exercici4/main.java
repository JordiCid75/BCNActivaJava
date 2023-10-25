package TareaS105.N1Exercici4;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class main {
	public static void main(String[] args) {
		try {
			if (args.length < 1) {
				System.out.println(
						"Se requiere recibir por linea de comandos el path completo de la carpeta a examinar.");
			} else {
				// El fichero con su path tiene que venir por parámetro

				String fichero = args[0];
				// debe ser un fichero del tipo TXT realizar las comprobaciones
				if (fichero.endsWith(".txt")) {
					BufferedReader b = null;
					try {
						Path f = Paths.get(fichero);
						// se abre el fichero en modo lectura
						b = Files.newBufferedReader(f);
						String s;

						// se recorre el contenido y se muestra el contenido por pantalla
						s = b.readLine();
						while (s != null) {
							System.out.println(s);
							s = b.readLine();
						}
					} finally {
						if (b != null) {
							b.close();
						}
					}
				} else {
					System.out.println("el fichero no es del tipo esperado, debe ser un *.txt");
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
