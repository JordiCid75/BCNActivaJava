package tareaS103.N1Exerici3;

import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner; // Import the Scanner class to read text files

public class main {

	static Scanner myScanner = new Scanner(System.in);

	public static void main(String[] args) {

		try {
			Countries countries = new Countries();

			Resultat resultat = new Resultat();

			System.out.println("Introduce nombre de usuario:");
			resultat.nomUsuari = myScanner.nextLine();
			Map randomMap = new RandomMap(countries.countrieList);

			// just call values() and iterate through them, they will be random
			Iterator iter = randomMap.keySet().iterator();


			for (int i = 1; i <= 10; i++) {
				if (iter.hasNext()) {
					String value = (String) iter.next();
					System.out.println("Capital de " + value);
					String capital = myScanner.nextLine();
					System.out.println(countries.countrieList.get(value));
					if (capital.equals(countries.countrieList.get(value))) {
						resultat.puntuació++;
					}
				}
			}
			System.out.println("puntuación obtenida: " + resultat.puntuació);
			resultat.escriuResultat();

		} catch (Exception e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

	}

}
