package tareaS103.N1Exerici3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;

public class Countries {
	HashMap<String, String> countrieList = new HashMap<String, String>();
	
	public Countries() {
		// Aqui leemos el fichero y lo cargamos en la HashMap
		try {
			File myObj = new File("countries.txt");
			Scanner myReader = new Scanner(myObj);

			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				String[] result = data.split(" ", 2);
				if (result.length >= 2) {
					countrieList.put(result[0], result[1]);
				}
				System.out.println(data);
			}
			myReader.close();

		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

	}

}
