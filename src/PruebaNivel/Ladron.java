package PruebaNivel;

public class Ladron extends Npc{
	public Ladron() {
		itemsMaximos = 3;
		nombre = "Ladron";
		
	}
	@Override
	public void addSellItem(Item i) throws InventarioLleno {
		i.porcentajeDescaste = 25;
		super.addSellItem(i);
	}

}
