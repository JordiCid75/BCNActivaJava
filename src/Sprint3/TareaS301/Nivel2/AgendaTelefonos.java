package Sprint3.TareaS301.Nivel2;

import java.util.ArrayList;

public class AgendaTelefonos implements IAgendaTelefonos{
	
	ArrayList<String> listaTelefonos = new ArrayList<String>();
	
	public AgendaTelefonos() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void addTelefono(String telefono) {
		// TODO Auto-generated method stub
		listaTelefonos.add(telefono);
	}
	
	@Override
	public void mostrarTelefonos() {
		// TODO Auto-generated method stub
		listaTelefonos.forEach(System.out::println);
	}

}
