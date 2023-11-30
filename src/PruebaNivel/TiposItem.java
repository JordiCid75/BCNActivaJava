package PruebaNivel;

import java.util.ArrayList;

public class TiposItem {
	private static TiposItem instancia;
	private static ArrayList<String> listaTipos = new ArrayList<String>();

	private TiposItem() {

	}

	public static TiposItem getTiposItem() {
		if (instancia == null) {
			return new TiposItem();
		}
		return instancia;
	}

	public void addTipo(String t) {
		if (!listaTipos.contains(t)) {
			listaTipos.add(t);
		}
	}

	public ArrayList<String> getListaTipos() {
		return listaTipos;
	}

}
