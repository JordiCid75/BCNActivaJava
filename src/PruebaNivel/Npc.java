package PruebaNivel;

import java.util.ArrayList;

public abstract class Npc {

	protected ArrayList<Item> listaItemVenta = new ArrayList<Item>();
	protected String nombre;
	protected Ciudad ciudad;
	
	
	public ArrayList<Item> getListaItemVenta() {
		return listaItemVenta;
	}

	public void setListaItemVenta(ArrayList<Item> listaItemVenta) {
		this.listaItemVenta = listaItemVenta;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	
	@Override
	public String toString() {
		return "Npc [nombre=" + nombre + ", ciudad=" + ciudad.getNombre() + "]";
	}

	public abstract void addSellItem(Item i) throws InventarioLleno;

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

	public void removeItemInventario(Item itemSeleccionado) {
		// TODO Auto-generated method stub
		listaItemVenta.remove(itemSeleccionado);
	}
}
