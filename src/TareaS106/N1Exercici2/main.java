package TareaS106.N1Exercici2;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		GenericMethods g = new GenericMethods();
		
		Persona p = new Persona();
		
		p.nom = "Jordi";
		p.cognom = " Cid";
		p.edat = 47;
		
		g.escriureTipus(p, "prova", 56);

		GenericMethods g2 = new GenericMethods();
		
		
		
		g2.escriureTipus(p.nom, p.edat, p);

	}

}
