package Sprint3.TareaS301.Nivel2;

public class AgendaTelFabrica implements FabricaAbstractaAgenda{
	
	@Override
	public IAgendaDirecciones getAgendaDirecciones() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public IAgendaTelefonos getAgendaTelefonos() {
		// TODO Auto-generated method stub
		return new AgendaTelefonos();
	}
	

}
