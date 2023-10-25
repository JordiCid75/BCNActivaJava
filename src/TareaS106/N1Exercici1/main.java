package TareaS106.N1Exercici1;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NoGenericMethods<String, Integer, Number> ng1 = new NoGenericMethods<String, Integer, Number>("Hola", 20, 23.5);
		System.out.println(ng1.getObj1());
		System.out.println(ng1.getObj2());
		System.out.println(ng1.getObj3());
		NoGenericMethods<Integer, String, Exception> ng2 = new NoGenericMethods<Integer, String, Exception>(10, "dos", new Exception());
		System.out.println(ng2.getObj1());
		System.out.println(ng2.getObj2());
		System.out.println(ng2.getObj3());
		NoGenericMethods<Number, String, Number> ng3 = new NoGenericMethods<Number, String, Number>(12, "tres", 56.8);
		System.out.println(ng3.getObj1());
		System.out.println(ng3.getObj2());
		System.out.println(ng3.getObj3());
		
		
	}

}
