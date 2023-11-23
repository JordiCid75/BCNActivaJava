package PruebaNivel;

public class Mercader extends Npc{
	public Mercader() {
		itemsMaximos = 7;
		impuesto = 0.4;
		nombre = "Mercader";
	}
	@Override
	public void addSellItem(Item i) throws InventarioLleno {
		i.precio = i.precio * (impuesto + 1);
		i.porcentajeDescaste = 0;
		super.addSellItem(i);
	}

}
