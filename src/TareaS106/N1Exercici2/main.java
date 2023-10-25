package TareaS106.N1Exercici2;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		GenericMethods<Persona, String, Number> g = new GenericMethods<Persona, String, Number>();
		
		Persona p = new Persona();
		
		p.nom = "Jordi";
		p.cognom = " Cid";
		p.edat = 47;
		
		g.escriureTipus(p, "prova", 56);

		GenericMethods<String, Integer, Persona> g2 = new GenericMethods<String, Integer, Persona>();
		
		
		
		g2.escriureTipus(p.nom, p.edat, p);

	}

}
