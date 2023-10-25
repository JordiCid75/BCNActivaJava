package TareaS105.N1Exercici5;

import java.io.*;

public class main {

	public static void main(String[] args) {

		Demo objeto_a_serializar = new Demo(1, "JordiCid");
		String filename = "Demo.ser";

		// Serializacion
		try {
			// creamos los objetos necesarios para crear el fichero
			FileOutputStream file = new FileOutputStream(filename);
			ObjectOutputStream out = new ObjectOutputStream(file);

			// usamos el método de serialización para guardar el objeto en el fichero
			out.writeObject(objeto_a_serializar);

			out.close();
			file.close();

			System.out.println("Objecto ha sido serializado");

		}

		catch (IOException ex) {
			System.out.println("Ha habido una IOException en la generación del .ser");
		}

		Demo objeto_deserializado = null;

		// Deserializacion
		try {
			// Leemos el objeto desde el fichero
			FileInputStream file = new FileInputStream(filename);
			ObjectInputStream in = new ObjectInputStream(file);

			// usamos esta método lara leer el objeto desde el fichero haciendo el cast al tipo de objeto esperado
			objeto_deserializado = (Demo) in.readObject();

			in.close();
			file.close();

			System.out.println("El objeto ha sido deserializado");
			System.out.println("a = " + objeto_deserializado.a);
			System.out.println("b = " + objeto_deserializado.b);
		}

		catch (IOException ex) {
			System.out.println("Ha habido una IOException en la Lectura del .ser");
		}

		catch (ClassNotFoundException ex) {
			// esto es posible porque puede que el objeto serializado no sea del tipo esperado
			System.out.println("ClassNotFoundException");
		}

	}

}
