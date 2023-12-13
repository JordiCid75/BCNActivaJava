package Sprint3.TareaS301.Nivel2;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		ArrayList<Agenda> listaAgenda = new ArrayList<Agenda>();

		Agenda ag = new Agenda();

		ag.addDireccion("Nueva Direccion");
		ag.addDireccion("Nueva Direccion1");
		ag.addDireccion("Nueva Direccion2");
		ag.addDireccion("Nueva Direccion3");

		ag.addTelefono("123456789");
		listaAgenda.add(ag);
		
		Agenda ag2 = new Agenda();
		ag2.addDireccion("Direccion2");
		listaAgenda.add(ag2);
		
		listaAgenda.forEach(Agenda::mostrarElemento);
	}

}
