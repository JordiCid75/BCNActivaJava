package Sprint3.TareaS301.Nivel2;

import java.util.ArrayList;

public class AgendaDirecciones implements IAgendaDirecciones {

	ArrayList<String> listaDirecciones = new ArrayList<String>();
	public AgendaDirecciones() {

	}

	@Override
	public void addDireccion(String direccion) {
		// TODO Auto-generated method stub
		listaDirecciones.add(direccion);
	}

	@Override
	public void mostrarDirecciones() {
		// TODO Auto-generated method stub
		listaDirecciones.forEach(System.out::println);
	}

}
