package TareaS105.N1Exercici3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.Set;

import static java.nio.file.StandardOpenOption.*;
import java.nio.file.*;
import java.io.*;

public class Resultado {
	String filename;
	Path file;

	public Resultado(String nombreFicheroConPath) {
		// TODO Auto-generated constructor stub
		filename = nombreFicheroConPath;
		file = Paths.get(nombreFicheroConPath);

	}

	public void escribirEnFichero(String linea) {
		Charset charset = Charset.forName("US-ASCII");
		OpenOption[] opt = {APPEND, CREATE};

		try (BufferedWriter writer = Files.newBufferedWriter(file, charset, opt)) {
			writer.write(linea +"\n");
		} catch (IOException x) {
			System.err.format("IOException: %s%n", x);
		}
	}
}
