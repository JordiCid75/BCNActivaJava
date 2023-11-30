package PruebaNivel;

import java.util.ArrayList;

public class Comprador {
	private ArrayList<Item> listaItemComprados = new ArrayList<Item>();
	private String nombre;
	private Ciudad ciudad;
	
	public Comprador() {
		nombre = "Comprador " + this.hashCode();
		ciudad = new Ciudad("Ciudad comprador");
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

	public void addInvItem(Item i) {
		listaItemComprados.add(i);
	}

	public ArrayList<Item> getListaItemComprados() {
		return listaItemComprados;
	}

	public void setListaItemComprados(ArrayList<Item> listaItemComprados) {
		this.listaItemComprados = listaItemComprados;
	}

	@Override
	public String toString() {
		return "Comprador [nombre=" + nombre + ", ciudad=" + ciudad.getNombre() + "]";
	}

}
