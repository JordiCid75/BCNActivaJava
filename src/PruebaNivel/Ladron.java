package PruebaNivel;

public class Ladron extends Npc{
	static final int ITEMS_MAXIMOS = 3;
	public Ladron() {
		this.nombre = "Ladron";
		ciudad = new Ciudad("ciudad Ladron");
		
	}
	@Override
	public void addSellItem(Item i) throws InventarioLleno {
		i.setPorcentajeDescaste(25);
		if (listaItemVenta.size() >= ITEMS_MAXIMOS) {
			throw new InventarioLleno("Inventario lleno!- El vendedor no puede comprar el ítem");
		}
		listaItemVenta.add(i);
	}
	


}
