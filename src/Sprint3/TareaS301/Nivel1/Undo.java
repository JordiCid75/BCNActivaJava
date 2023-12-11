package Sprint3.TareaS301.Nivel1;

import java.util.ArrayList;

public class Undo {
	// Declaramos la variable para que conteng la unica instancia de esta clase
	private static Undo instancia;
	private static ArrayList<String> listaComandos = new ArrayList<String>();
	
	// Declaramos el constructor privado para poder controlar la creación de las instancias
	private Undo() {
		
	}
	
	// Creamos o devolvemos la instancia del objeto ya creada anteriormente
	public static Undo GetInstance() {
		if (instancia == null)
		{
			instancia = new Undo();
		}
		return instancia;
	}
	
	public void ejecutarComando(String c) {
		listaComandos.add(c);
		System.out.println(c);
	}
	
	public void historialComandos() {
		listaComandos.forEach(System.out::println);
	}

}
