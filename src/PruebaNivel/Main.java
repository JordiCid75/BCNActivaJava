package PruebaNivel;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static ArrayList<Npc> listaNpc = new ArrayList<Npc>();

	public static void main(String[] args) {
		int opc;
		do {
			pintarMenu();
			opc = sc.nextInt();
			switch (opc) {
			case 0: {
				System.out.println("Saliendo de la aplicacion.");
				break;
			}
			case 1: {
				sc.nextLine();
				try {
					System.out.println("Introduce el tipo de Vendedor [C]ampesino, [L]adron, [M]ercader:");
					String tipo = sc.nextLine();
					listaNpc.add(Npc.crear(tipo));
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			}
			case 2: {
				try {
					System.out.println("Selecciona Vendedor:");
					
					listaNpc.forEach((v) -> {
						if (!v.getClass().equals(Comprador.class)) {
							System.out.println(listaNpc.indexOf(v)+ " - " + v.nombre);
						}
					});
					int op = sc.nextInt();
					if (op >= 1 && op <= listaNpc.size()) {
						listaNpc.get(op).addSellItem(new Item("Item" + op, "Tipo" + op, 10 * op));
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			}
			case 3: {
				
				break;
			}
			case 4: {
				try {
				System.out.println("Selecciona Vendedor:");
				
				listaNpc.forEach((v) -> {
					if (!v.getClass().equals(Comprador.class)) {
						System.out.println(listaNpc.indexOf(v)+ " - " + v.nombre);
					}
				});
				int op = sc.nextInt();
				if (op >= 1 && op <= listaNpc.size()) {
					listaNpc.get(op).listaItemVenta.forEach((it)->it.toString());
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
				break;
			}
			case 5: {
				break;

			}
			case 6: {
				break;
			}
			case 7: {
				break;
			}
			case 8: {
				break;
			}
			case 9: {
				break;
			}
			case 10: {
				break;
			}
			default:
				System.out.println("Opcion de menu no valida.");
			}
		} while (opc != 0);

	}

	private static void pintarMenu() {
		System.out.println("Menu Principal:");
		System.out.println(
				"0 - Salir\n" + "1 - Crear un vendedor\n" + "2 - Añadir un item al inventario de un vendedor.\n"
						+ "3 - Mostrar el ítem más barato de todos los vendedores de una ciudad\n"
						+ "4 - Consultar los ítems de un vendedor.\n" + "5 - Crear un comprador\n"
						+ "6 - Realizar la compra de un ítem.\n" + "7 - Consultar los ítems de un Comprador.\n"
						+ "8 - Consultar todos los vendedores que hay en una ciudad.\n"
						+ "9 - Consultar todos los compradores que hay en una ciudad.\n"
						+ "10 - Mostrar todos los ítems de un determinado tipo ordenados por precio (asc).");
		System.out.println("Elige una opcion:");
	}
}
