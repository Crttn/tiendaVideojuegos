package tiendaVideojuegos;

import java.util.Scanner;

public class estilosConsola {

	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";

	public void menuPrincipal() {
		System.out.println("\n1. Opciones de juegos");
		System.out.println("2. Opciones de usuarios");
		System.out.println("3. Opciones de compra");
		System.out.println("4. " + ANSI_RED + "Salir del programa" + ANSI_WHITE);
	}

	public void menuJuegos() {
		System.out.println("\n1." + ANSI_CYAN + "Agregar juegos" + ANSI_WHITE);
		System.out.println("2." + ANSI_CYAN + "Cambiar el estado de juegos" + ANSI_WHITE);
		System.out.println("3." + ANSI_CYAN + "Buscar juegos" + ANSI_WHITE);
		System.out.println("4." + ANSI_CYAN + "Ver lista de juegos" + ANSI_WHITE);
		System.out.println("5. " + ANSI_RED + "Volver" + ANSI_WHITE);
	}

	public void menuUsuarios() {
		System.out.println("\n1. " + ANSI_CYAN + "Agregar usuarios" + ANSI_WHITE);
		System.out.println("2. " + ANSI_CYAN + "Buscar usuarios" + ANSI_WHITE);
		System.out.println("3. " + ANSI_CYAN + "Lista de usuarios" + ANSI_WHITE);
		System.out.println("4. " + ANSI_CYAN + "Modificar usuarios" + ANSI_WHITE);
		System.out.println("5. " + ANSI_CYAN + "Eliminar usuarios" + ANSI_WHITE);
		System.out.println("6." + ANSI_RED + " Volver" + ANSI_WHITE);
	}

	public void menuCompras() {
		System.out.println("\n1." + ANSI_CYAN + "Generar compra" + ANSI_WHITE);
		System.out.println("2." + ANSI_CYAN + "Lista de compras" + ANSI_WHITE);
		System.out.println("3." + ANSI_RED + "Volver" + ANSI_WHITE);
	}
	
	public static void menuModUsuario() {
		System.out.println("\n1." + ANSI_CYAN + "Modificar teléfono" + ANSI_WHITE);
		System.out.println("2." + ANSI_CYAN + "Modificar correo" + ANSI_WHITE);
		System.out.println("3." + ANSI_RED + "Volver" + ANSI_WHITE);
	}
	
	public static int solicitarOpcion(Scanner sc) {
		System.out.print("\nIntroduce una opción: ");
		return sc.nextInt();
	}

	public static String solicitarTexto(Scanner sc, String texto) {
		System.out.print(texto);
		return sc.nextLine();
	}
	
	public static String solicitarNombre(Scanner sc, String texto) {
		String patronNombre = "^[a-zA-ZÁáÉéÍíÓóÚúÑñÜü\\s]+$";
		String nombre;
		do {
			System.out.print(texto);
			nombre = sc.nextLine();
			if (!nombre.matches(patronNombre)) {
				System.out.println(ANSI_RED + "El formato es incorrecto. No se admiten números ni espacion en blanco." + ANSI_WHITE);
			}
		} while (!nombre.matches(patronNombre));
		return nombre;
	}
	
	public static String solicitarDni(Scanner sc, String texto) {
		String patronDni = "^[0-9]{8}[A-HJ-NP-TV-Za-hj-np-tv-z0-9]$";
		String dni;
		do {
			System.out.print(texto);
			dni = sc.nextLine().toUpperCase();
			if (!dni.matches(patronDni)) {
				System.out.println(ANSI_RED + "El formato del DNI es incorrecto. Debe tener 8 dígitos seguidos de una letra." + ANSI_WHITE);
			}
		} while (!dni.matches(patronDni));
		return dni;
	}
	
	public static String solicitarTelefono(Scanner sc, String texto) {
		String patronTelefono = "^[0-9]{9}";
		String telefono;
		do {
			System.out.print(texto);
			telefono = sc.nextLine();
			if (!telefono.matches(patronTelefono)){
				System.out.println(ANSI_RED + "El formato del Telefono es incorrecto. Debe tener 9 dígitos sin espacios" + ANSI_WHITE);
			}
		} while (!telefono.matches(patronTelefono));
		return telefono;
	}
	
	public static String solicitarCorreo(Scanner sc, String texto) {
		String patronCorreo = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
		String correo;
		do {
			System.out.print(texto);
			correo = sc.nextLine();
			if (!correo.matches(patronCorreo)) {
				System.out.println(ANSI_RED + "El formato del Correo es incorrecto. Ejemplo: corrreo@correo.com" + ANSI_WHITE);
			}
		} while(!correo.matches(patronCorreo));
		return correo;
	}
	
	public static String solicitarConsola(Scanner sc, String texto) {
		String[] consolas = {"PS5", "XBOX", "PC", "SWITCH"};
		String consola;
		boolean esValido;
		do {
			System.out.println("\nConsolas disponibles |PS5|XBOX|PC|SWITCH|");
			System.out.print(texto);
			consola = sc.nextLine().toUpperCase();
			esValido = false;
			for (String consola1 : consolas) {
				if (consola.equals(consola1)) {
					esValido = true;
					break;
				}
			}
 			if (!esValido) {
				System.out.println(ANSI_RED + "\nError al introducir el nombre de la consola." + ANSI_WHITE);
			}
		} while(!esValido);
		return consola;
	}
	
	public static String solicitarEstado(Scanner sc, String texto) {
		String[] estados = {"en venta", "obsoleto"};
		String estado;
		boolean esValido;
		do {
			System.out.println("\nEstados de videojuegos |En venta|Obsoleto|");
			System.out.print(texto);
			estado = sc.nextLine().toLowerCase();
			esValido = false;
			for (String estado1 : estados) {
				if (estado.equals(estado1)) {
					esValido = true;
					break;
				}
			}
 			if (!esValido) {
				System.out.println(ANSI_RED + "\nError al introducir el estado del videojuego." + ANSI_WHITE);
			}
		} while(!esValido);
		return estado;
	}

	public void cartelera() {
		System.out.println("\n" + ANSI_GREEN
				+ " ____  __  ____  __ _  ____   __     ____  ____    _  _  __  ____  ____  __     __  _  _  ____  ___   __   ____ \r\n"
				+ "(_  _)(  )(  __)(  ( \\(    \\ / _\\   (    \\(  __)  / )( \\(  )(    \\(  __)/  \\  _(  )/ )( \\(  __)/ __) /  \\ / ___)\r\n"
				+ "  )(   )(  ) _) /    / ) D (/    \\   ) D ( ) _)   \\ \\/ / )(  ) D ( ) _)(  O )/ \\) \\) \\/ ( ) _)( (_ \\(  O )\\___ \\\r\n"
				+ " (__) (__)(____)\\_)__)(____/\\_/\\_/  (____/(____)   \\__/ (__)(____/(____)\\__/ \\____/\\____/(____)\\___/ \\__/ (____/\r\n"
				+ "" + ANSI_WHITE);
	}

	public void menuPrincipalCartel() {
		System.out.println("  __  ____   ___  __  __   __ _  ____  ____ \r\n"
				+ " /  \\(  _ \\ / __)(  )/  \\ (  ( \\(  __)/ ___)\r\n"
				+ "(  O )) __/( (__  )((  O )/    / ) _) \\___ \\\r\n"
				+ " \\__/(__)   \\___)(__)\\__/ \\_)__)(____)(____/");
	}

	public void menuJuegosCartelera() {
		System.out.println("   __  _  _  ____  ___   __   ____ \r\n" + " _(  )/ )( \\(  __)/ __) /  \\ / ___)\r\n"
				+ "/ \\) \\) \\/ ( ) _)( (_ \\(  O )\\___ \\\r\n" + "\\____/\\____/(____)\\___/ \\__/ (____/");
	}

	public void menuUsuariosCartelera() {
		System.out.println(" _  _  ____  _  _   __   ____  __  __   ____ \r\n"
				+ "/ )( \\/ ___)/ )( \\ / _\\ (  _ \\(  )/  \\ / ___)\r\n"
				+ ") \\/ (\\___ \\) \\/ (/    \\ )   / )((  O )\\___ \\\r\n"
				+ "\\____/(____/\\____/\\_/\\_/(__\\_)(__)\\__/ (____/");
	}

	public void menuComprasCartelera() {
		System.out.println(
				"  ___  __   _  _  ____  ____   __   ____ \r\n" + " / __)/  \\ ( \\/ )(  _ \\(  _ \\ / _\\ / ___)\r\n"
						+ "( (__(  O )/ \\/ \\ ) __/ )   //    \\\\___ \\\r\n"
						+ " \\___)\\__/ \\_)(_/(__)  (__\\_)\\_/\\_/(____/");
	}

	public void separador() {
		System.out.println(" ");
		for (int i = 0; i < 120; i++) {
			System.out.print("═");
		}
		System.out.println(" ");
	}
}
