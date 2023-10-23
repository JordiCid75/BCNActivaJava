package tareaS103.N1Exerici3;
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors

public class Resultat {
	String nomUsuari;
	int puntuació;
	
	public Resultat() {
	}
	
	public void escriuResultat() {
		try {
		      FileWriter myWriter = new FileWriter("classificacio.txt");
		      myWriter.write(nomUsuari + " " + puntuació);
		      myWriter.close();


		} catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		}
	}

}
