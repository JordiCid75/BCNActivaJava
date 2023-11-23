package PruebaNivel;

public class Item {
	String nombre;
	String tipo;
	double precio;
	double porcentajeDescaste;
	
	public Item(String nom, String tip, double pre) {
		nombre = nom;
		tipo = tip;
		precio = pre;
		porcentajeDescaste = 0;
	}

	@Override
	public String toString() {
		return "Item [nombre=" + nombre + ", tipo=" + tipo + ", precio=" + precio + ", porcentajeDescaste="
				+ porcentajeDescaste + "]";
	}
	
}
