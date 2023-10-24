package TareaS105.N1Exercici2;

import java.nio.file.*;

public class main {

	public static void main(String[] args) {
		Path dir = Paths.get(args[0]);
		FileExplorer f = new FileExplorer();
		f.cargarContenidoPath(dir);
		f.mostrarContenidoCargado();
	}

}
