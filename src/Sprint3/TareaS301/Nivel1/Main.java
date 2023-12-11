package Sprint3.TareaS301.Nivel1;

import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Undo u = Undo.GetInstance();
		for (int i = 0; i < 10; i++) {
			System.out.println("Introduce el comando a ejecutar numero " + i + ": ");
			u.ejecutarComando(sc.nextLine());
		}
		System.out.println("Mostrando historial 1a iteración:");
		u.historialComandos();
		Undo u2 = Undo.GetInstance();

		for (int i = 10; i < 20; i++) {
			System.out.println("Introduce el comando a ejecutar numero " + i + ": ");
			u2.ejecutarComando(sc.nextLine());
		}
		// aqui debería tener el historial anterior
		System.out.println("Mostrando historial 2a iteración:");
		u2.historialComandos();
	}

}
