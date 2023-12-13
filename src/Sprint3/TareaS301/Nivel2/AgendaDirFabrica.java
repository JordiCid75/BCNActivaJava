package Sprint3.TareaS301.Nivel2;

public class AgendaDirFabrica implements FabricaAbstractaAgenda{
	
	@Override
	public IAgendaDirecciones getAgendaDirecciones() {
		// TODO Auto-generated method stub
		return new AgendaDirecciones();
	}
	@Override
	public IAgendaTelefonos getAgendaTelefonos() {
		// TODO Auto-generated method stub
		return null;
	}

}
