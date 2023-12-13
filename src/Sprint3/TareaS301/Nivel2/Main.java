package Sprint3.TareaS301.Nivel2;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		FabricaAbstractaAgenda fAgenda = FabricaProductor.getAgenda("D");
		try {
			IAgendaDirecciones agDir = fAgenda.getAgendaDirecciones();
			agDir.addDireccion("nueva direccion");
			agDir.mostrarDirecciones();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		// esto dará error porque la fábrica ha devuelto la instancia para crear Agenda
		// de direcciones
		try {
			IAgendaTelefonos agTel = fAgenda.getAgendaTelefonos();
			agTel.addTelefono("123456789");
			agTel.mostrarTelefonos();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		fAgenda = FabricaProductor.getAgenda("T");
		// esto NO dará error porque la fábrica ha devuelto la instancia para crear
		// Agenda de Telefonos
		try {
			IAgendaTelefonos agTel = fAgenda.getAgendaTelefonos();
			agTel.addTelefono("123456789");
			agTel.mostrarTelefonos();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
