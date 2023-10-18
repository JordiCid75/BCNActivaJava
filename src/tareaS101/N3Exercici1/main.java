package tareaS101.N3Exercici1;

import java.util.Scanner;

public class main {

	static Scanner myScanner = new Scanner(System.in);
	static redaccio redaccion = new redaccio();
	
	private static void PintarMenu()
	{
		System.out.flush();
		System.out.println("Menú Aplicación");
		System.out.println(" ");
		System.out.println("1- Introduir Redactor.");
		System.out.println("2- Eliminar Redactor.");
		System.out.println("3- Introduir notícia a un redactor.");
		System.out.println("4- Eliminar notícia (ha de demanar redactor i titular de la notícia).");
		System.out.println("5- Mostrar totes les notícies per redactor.");
		System.out.println("6- Calcular puntuació de la notícia.");
		System.out.println("7- Calcular preu-notícia.");
		System.out.println(" ");
		System.out.println("Elige una opción:");
	}

	public static void main(String[] args) {
		// menu
		int opcionMenu;
		boolean salirApp = false;
		while (!salirApp)
		{
			PintarMenu();
			opcionMenu = myScanner.nextInt();
			switch (opcionMenu)
			{
				case 1:
				{
					String nom;
					String dni;
					
					System.out.flush();
					System.out.println("opción 1");
					System.out.println("Nom Redactor:");
					nom = myScanner.nextLine();
					System.out.println("DNI Redactor:");
					dni = myScanner.nextLine();
					
					redactor r = new redactor(nom, dni);
					redaccion.afegirRedactor(r);
					System.out.println("Redactor Afegit.");
					
					continue;
				}
				case 2:
				{
					String dni;
					redactor r;

					System.out.flush();
					System.out.println("opción 2");
					System.out.println("DNI Redactor:");
					dni = myScanner.nextLine();
					r = redaccion.buscarRedactor(dni);
					if (r != null)
					{
						redaccion.eliminarRedactor(r);
						System.out.println("Redactor Eliminat.");
					}
					continue;
				}
				case 3:
				{
					String dni;
					redactor r;
					
					
					System.out.flush();
					System.out.println("opción 3");
					System.out.println("DNI Redactor:");
					dni = myScanner.nextLine();
					r = redaccion.buscarRedactor(dni);
					if (r != null)
					{
						
						System.out.println("Redactor Eliminat.");
					}
					
					continue;
				}
				case 4:
				{
					System.out.flush();
					System.out.println("opción 4");
					continue;
				}
				case 5:
				{
					System.out.flush();
					System.out.println("opción 5");
					continue;
				}
				case 6:
				{
					System.out.flush();
					System.out.println("opción 6");
					continue;
				}
				case 7:
				{
					System.out.flush();
					salirApp = true;
					continue;
				}
			}
		}
		
	}

	

}
