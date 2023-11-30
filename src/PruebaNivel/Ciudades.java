package PruebaNivel;

import java.util.ArrayList;

public class Ciudades {
	private static Ciudades instancia;
	private static ArrayList<String> listaNombreCiudades = new ArrayList<String>();

	private Ciudades() {

	}

	public static Ciudades getCiudades() {
		if (instancia == null) {
			return new Ciudades();
		}
		return instancia;
	}

	public void addCiudad(String c) {
		if (!listaNombreCiudades.contains(c)) {
			listaNombreCiudades.add(c);
		}
	}

	public ArrayList<String> getListaNombreCiudades() {
		return listaNombreCiudades;
	}

}
