package PruebaNivel;

public class Campesino extends Npc {
	public Campesino() {
		itemsMaximos = 5;
		nombre = "Campesino";
		impuesto = 0.2;

	}

	@Override
	public void addSellItem(Item i) throws InventarioLleno {
		i.precio = i.precio * (impuesto + 1);
		i.porcentajeDescaste = 15;
		super.addSellItem(i);
	}

}
