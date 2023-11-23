package PruebaNivel;

import java.util.ArrayList;
import java.util.Comparator;

public abstract class Npc {

	ArrayList<Item> listaItemVenta = new ArrayList<Item>();
	ArrayList<Comprador> invCompradores = new ArrayList<Comprador>();
	int itemsMaximos;
	double impuesto;
	String nombre;
	int deterioro;
	String ciudad;
	//l.sort(Comparator.comparing(String::length).reversed());
	public void addSellItem(Item i) throws InventarioLleno {
		if (listaItemVenta.size() >= itemsMaximos) {
			throw new InventarioLleno("Inventario lleno!- El vendedor no puede comprar el ítem");
		}
		listaItemVenta.add(i);
	}

	public static Npc crear(String tipo) throws TipoNpcNoValido {
		switch (tipo) {
		case "C": {
			return new Campesino();
		}
		case "L": {
			return new Ladron();
		}
		case "M": {
			return new Mercader();
		}
		default:
			throw new TipoNpcNoValido("Tipo no valido: " + tipo);
		}
	}
}
