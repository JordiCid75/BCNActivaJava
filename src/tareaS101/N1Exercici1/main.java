package tareaS101.N1Exercici1;


import java.util.ArrayList;


public class main {
	private static ArrayList<instrumento> instrumentos = new ArrayList<instrumento>();
	
	public static void main(String[] args) {

		instrumentoViento instViento = new instrumentoViento();
		instrumentoCuerda instCuerda = new instrumentoCuerda();
		instrumentoPercusion instPercusion = new instrumentoPercusion();

		instrumentos.add(instViento);
		instrumentos.add(instCuerda);
		instrumentos.add(instPercusion);
	
		for (instrumento instrumento : instrumentos) {
			System.out.println(instrumento.tocar());
			System.out.println(instrumento.nombre);
			System.out.println(instrumento.precio);
			
		}
		
		
	}

}
