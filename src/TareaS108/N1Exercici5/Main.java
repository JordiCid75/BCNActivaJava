package TareaS108.N1Exercici5;

public class Main {

	public static void main(String[] args) {
		PiValue p = new PiValue() {
			
			public Double getPiValue() {
				return 3.1415;
			}
		};
		System.out.println(p.getPiValue());
	}

}
