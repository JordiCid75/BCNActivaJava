package Sprint3.TareaS302;

import java.util.ArrayList;
import java.util.List;

public class AgenteBolsa {

	private List<Agencia> agencias = new ArrayList<Agencia>();

	public void agregar(Agencia agencia) {
		agencias.add(agencia);
	}

	public void notificarTodasAgencias() {
		agencias.forEach((a) -> a.actualizar());
	}

	public void cambioBolsa() {
		notificarTodasAgencias();
	}
}
