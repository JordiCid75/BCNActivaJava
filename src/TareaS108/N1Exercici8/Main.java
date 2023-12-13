package TareaS108.N1Exercici8;

public class Main {

	public static void main(String[] args) {
		Reverse r = new Reverse() {
			
			@Override
			public String reverse(String s) {
				// TODO Auto-generated method stub
				StringBuilder stringBuilder = new StringBuilder(s);
				return stringBuilder.reverse().toString();
			}
		};
		
		
		System.out.println(r.reverse("prueba de reverse"));
	}

}
