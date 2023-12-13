package Sprint3.TareaS301.Nivel2;

public class Agenda {
	private IAgendaDirecciones direccion;
	private IAgendaTelefonos telefono;

	public Agenda() {
		// TODO Auto-generated constructor stub
	}

	public void addDireccion(String dir) {
		if (this.direccion == null) {
			FabricaAbstractaAgenda fAgenda = FabricaProductor.getAgenda("D");
			this.direccion = fAgenda.getAgendaDirecciones();
		}
		try {
			this.direccion.addDireccion(dir);
			this.direccion.mostrarDirecciones();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void addTelefono(String tel) {
		if (this.telefono == null) {
			FabricaAbstractaAgenda fAgenda = FabricaProductor.getAgenda("T");
			this.telefono = fAgenda.getAgendaTelefonos();
		}
		try {
			this.telefono.addTelefono(tel);
			this.telefono.mostrarTelefonos();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void mostrarElemento() {
		System.out.println("Agenda: \ndirecciones=");
		if (this.direccion != null) {
			this.direccion.mostrarDirecciones();
		}
		System.out.println("telefonos=");
		if (this.telefono != null) {
			this.telefono.mostrarTelefonos();
		}
	}

}
