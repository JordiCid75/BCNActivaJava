package TareaS105.N1Exercici2;

import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class FileExplorer {
	public static HashMap<String, Fichero> ficheros = new HashMap<String, Fichero>();

	public void cargarContenidoPath(Path dir) {
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
			for (Path file : stream) {
				Fichero f = new Fichero();
				BasicFileAttributes attr = Files.readAttributes(file, BasicFileAttributes.class);
				f.fechaModificacion = attr.lastModifiedTime();
				f.nombre = file.getFileName().toString();
				f.path = dir;
				if (attr.isDirectory()) {
					f.tipo = "D";
					this.cargarContenidoPath(dir.resolve(file.getFileName()));
				} else {
					f.tipo = "F";
				}
				ficheros.put(f.path + "/" + f.nombre, f);
			}
		} catch (IOException | DirectoryIteratorException x) {
			// IOException can never be thrown by the iteration.
			// In this snippet, it can only be thrown by newDirectoryStream.
			System.err.println(x);
		}

	}

	public void mostrarContenidoCargado() {
		List ficherosList = new ArrayList(ficheros.keySet());
		Collections.sort(ficherosList);
		Iterator it = ficherosList.iterator();
		while (it.hasNext()) {
			System.out.println(ficheros.get(it.next()).toString());
		}
		// for (Fichero f : ficherosList) {
		// System.out.println(f.toString());
		// }
	}
}
