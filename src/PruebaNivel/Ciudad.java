package PruebaNivel;

public class Ciudad {
	private String nombre;
	 
	public Ciudad(String nombreCiudad) {
		// TODO Auto-generated constructor stub
		nombre = nombreCiudad;
		Ciudades c = Ciudades.getCiudades();
		c.addCiudad(nombreCiudad);
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
