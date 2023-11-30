package PruebaNivel;

public class Item {
	private String nombre;
	private String tipo;
	private double precio;
	private double porcentajeDescaste;
	
	public Item(String nom, String tip, double pre) {
		nombre = nom;
		tipo = tip;
		precio = pre;
		porcentajeDescaste = 0;
		TiposItem t = TiposItem.getTiposItem();
		t.addTipo(tip);
	}

	@Override
	public String toString() {
		return "Item [nombre=" + nombre + ", tipo=" + tipo + ", precio=" + precio + ", porcentajeDescaste="
				+ porcentajeDescaste + "]";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public double getPorcentajeDescaste() {
		return porcentajeDescaste;
	}

	public void setPorcentajeDescaste(double porcentajeDescaste) {
		this.porcentajeDescaste = porcentajeDescaste;
	}
	
}
