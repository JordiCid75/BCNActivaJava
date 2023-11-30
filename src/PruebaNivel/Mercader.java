package PruebaNivel;

public class Mercader extends Npc{
	static final int ITEMS_MAXIMOS = 7;
	static final double IMPUESTO = 0.4;
	
	public Mercader() {
		nombre = "Mercader";
		ciudad = new Ciudad("CiudadMercader");
	}
	@Override
	public void addSellItem(Item i) throws InventarioLleno {
		i.setPrecio( i.getPrecio() * (IMPUESTO + 1));
		i.setPorcentajeDescaste(0);
		if (listaItemVenta.size() >= ITEMS_MAXIMOS) {
			throw new InventarioLleno("Inventario lleno!- El vendedor no puede comprar el ítem");
		}
		listaItemVenta.add(i);
	}

}
