package TareaS106.N1Exercici1;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NoGenericMethods ng1 = new NoGenericMethods("Hola", "adios", "prueba");
		System.out.println(ng1.getObj1());
		System.out.println(ng1.getObj2());
		System.out.println(ng1.getObj3());
		NoGenericMethods ng2 = new NoGenericMethods("adios", "Hola", "prueba");
		System.out.println(ng2.getObj1());
		System.out.println(ng2.getObj2());
		System.out.println(ng2.getObj3());
		NoGenericMethods ng3 = new NoGenericMethods("prueba", "adios", "HOLA");
		System.out.println(ng3.getObj1());
		System.out.println(ng3.getObj2());
		System.out.println(ng3.getObj3());
		
		
	}

}
