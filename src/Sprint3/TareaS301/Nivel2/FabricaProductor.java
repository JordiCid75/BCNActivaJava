package Sprint3.TareaS301.Nivel2;

public class FabricaProductor {

	public static FabricaAbstractaAgenda getAgenda(String tipo) {
		switch (tipo) {
		case "D": {
			return new AgendaDirFabrica();

		}
		case "T": {
			return new AgendaTelFabrica();

		}
		}

		return null;
	}
}
