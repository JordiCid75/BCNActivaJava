package Sprint3.TareaS302;

public class Main {

	public static void main(String[] args) {

		AgenteBolsa agente = new AgenteBolsa();
		new AgenciaNY(agente);
		new AgenciaBoston(agente);

		// el agente recibe un cambio de bolsa
		System.out.println("Agente Recibe un cambio de bolsa 1.");
		agente.cambioBolsa();

		// el agente recibe un cambio de bolsa
		System.out.println("Agente Recibe un cambio de bolsa 2.");
		agente.cambioBolsa();
		// el agente recibe un cambio de bolsa
		System.out.println("Agente Recibe un cambio de bolsa 3.");
		agente.cambioBolsa();

	}

}
