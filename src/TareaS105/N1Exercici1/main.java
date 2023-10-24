package TareaS105.N1Exercici1;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Path dir = Paths.get("//Users/jordicid/documents/treb");
		Path dir = Paths.get(args[0]);
		
		FileExplorer f = new FileExplorer();
		f.cargarContenidoPath(dir);
		f.mostrarContenidoCargado();
	}

}
