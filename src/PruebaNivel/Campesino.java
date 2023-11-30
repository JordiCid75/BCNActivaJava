package PruebaNivel;

public class Campesino extends Npc {
	static final int ITEMS_MAXIMOS = 5;
	static final double IMPUESTO = 0.2;
	public Campesino() {
		nombre = "Campesino";
		ciudad = new Ciudad("Ciudad Campesino");
	}

	@Override
	public void addSellItem(Item i) throws InventarioLleno {
		i.setPrecio( i.getPrecio() * (IMPUESTO + 1));
		i.setPorcentajeDescaste(15);
		if (listaItemVenta.size() >= ITEMS_MAXIMOS) {
			throw new InventarioLleno("Inventario lleno!- El vendedor no puede comprar el ítem");
		}
		listaItemVenta.add(i);
	}

}
