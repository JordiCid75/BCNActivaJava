package PruebaNivel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static ArrayList<Npc> listaNpc = new ArrayList<Npc>();
	static ArrayList<Comprador> listaCompradores = new ArrayList<Comprador>();
	private static SelectorGeneric sel = new SelectorGeneric();
	private static ArrayList<Ciudad> listaCiudades = new ArrayList<Ciudad>();
	private static ArrayList<String> listaTipos = new ArrayList<String>();

	public static void main(String[] args) {
		int opc;
		do {
			pintarMenu();
			opc = sc.nextInt();
			switch (opc) {
			case 0: {
				SalirApp();
				break;
			}
			case 1: {
				crearVendedor();
				break;
			}
			case 2: {
				addItemVendedor();
				break;
			}
			case 3: {
				mostrarItemMasBaratoDeUnaCiudad();
				break;
			}
			case 4: {
				consultarItemsVendedor();
				break;
			}
			case 5: {
				crearComprador();
				break;

			}
			case 6: {
				comprarItem();
				break;
			}
			case 7: {
				consultarItemsComprador();
				break;
			}
			case 8: {
				consultarVendedoresCiudad();
				break;
			}
			case 9: {
				consultarCompradoresCiudad();
				break;
			}
			case 10: {
				mostrarItemsTipoOrdenPreciAsc();
				break;
			}
			default:
				System.out.println("Opcion de menu no valida.");
			}
		} while (opc != 0);

	}

	private static void consultarCompradoresCiudad() {
		// TODO Auto-generated method stub
		Ciudades cds = Ciudades.getCiudades();
		System.out.println("Selecciona la ciudad:");
		String ciudadBuscada = sel.selecionarElemento(cds.getListaNombreCiudades());
		listaCompradores.forEach((c) -> {
			if (c.getCiudad().getNombre().equals(ciudadBuscada)) {
				System.out.println(c.getNombre());
			}
		});

	}

	private static void mostrarItemsTipoOrdenPreciAsc() {
		// TODO Auto-generated method stub
		TiposItem tip = TiposItem.getTiposItem();
		System.out.println("Selecciona un tipo de item: ");
		String tipoItemSeleccionado = sel.selecionarElemento(tip.getListaTipos());

		ArrayList<Item> listaItems = new ArrayList<Item>();
		listaNpc.forEach((v) -> v.getListaItemVenta().forEach((it) -> {
			if (it.getTipo().equals(tipoItemSeleccionado)) {
				listaItems.add(it);
			}
		}));
		listaItems.sort(Comparator.comparing(Item::getPrecio));
		listaItems.forEach(System.out::println);
	}

	private static void consultarVendedoresCiudad() {
		Ciudades cds = Ciudades.getCiudades();
		System.out.println("Selecciona la ciudad:");
		String ciudadBuscada = sel.selecionarElemento(cds.getListaNombreCiudades());
		listaNpc.forEach((v) -> {
			if (v.ciudad.getNombre().equals(ciudadBuscada)) {
				System.out.println(v.getNombre());
			}
		});

	}

	private static void consultarItemsComprador() {
		try {
			System.out.println("Selecciona Comprador:");
			Comprador compradorSeleccionado = sel.selecionarElemento(listaCompradores);
			compradorSeleccionado.getListaItemComprados().forEach((it) -> System.out.println(it.toString()));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	private static void comprarItem() {
		try {
			System.out.println("Selecciona Comprador:");
			Comprador compradorSeleccionado = sel.selecionarElemento(listaCompradores);
			try {
				System.out.println("Selecciona Vendedor:");
				Npc vendedorSeleccionado = sel.selecionarElemento(listaNpc);

				System.out.println("Selecciona el item del Vendedor:");
				Item itemSeleccionado = sel.selecionarElemento(vendedorSeleccionado.getListaItemVenta());
				compradorSeleccionado.addInvItem(itemSeleccionado);
				vendedorSeleccionado.removeItemInventario(itemSeleccionado);

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	private static void crearComprador() {
		sc.nextLine();
		try {
			System.out.println("Creando comprador...");
			listaCompradores.add(new Comprador());
			System.out.println("Comprador Creado.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	private static void consultarItemsVendedor() {
		try {
			System.out.println("Selecciona Vendedor:");
			Npc vendedorSeleccionado = sel.selecionarElemento(listaNpc);
			vendedorSeleccionado.getListaItemVenta().forEach((it) -> System.out.println(it.toString()));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	private static void mostrarItemMasBaratoDeUnaCiudad() {
		/*
		 * de todos los vendedores ver la ciudad,
		 * crear una lista sin duplicados y su item mas barato
		 */
		ArrayList<Item> listaItems = new ArrayList<Item>();
		Ciudades cds = Ciudades.getCiudades();
		System.out.println("Selecciona la ciudad:");
		String ciudadBuscada = sel.selecionarElemento(cds.getListaNombreCiudades());
		listaNpc.forEach((v) -> {
			if (v.getCiudad().getNombre().equals(ciudadBuscada)) {
				v.getListaItemVenta().forEach((i)->listaItems.add(i));
			}});
		
		listaItems.sort(Comparator.comparing(Item::getPrecio));
		System.out.println(listaItems.get(0).toString());

	}

	private static void addItemVendedor() {

		Random r = new Random();
		try {
			int item_id = r.nextInt(5);
			System.out.println("Selecciona Vendedor:");
			Npc vendedorSeleccionado = sel.selecionarElemento(listaNpc);
			Item it = new Item("Item" + item_id, "Tipo" + item_id, 10 * item_id);
			vendedorSeleccionado.addSellItem(it);
			if (!listaTipos.contains(it.getTipo())) {
				listaTipos.add(it.getTipo());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void crearVendedor() {
		// TODO Auto-generated method stub
		sc.nextLine();
		try {
			System.out.println("Introduce el tipo de Vendedor [C]ampesino, [L]adron, [M]ercader:");
			String tipo = sc.nextLine();
			listaNpc.add(Npc.crear(tipo));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	private static void SalirApp() {
		System.out.println("Saliendo de la aplicacion.");
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
