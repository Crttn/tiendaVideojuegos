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

	protected void menuPrincipal() {
		System.out.println("\n1. Opciones de juegos");
		System.out.println("2. Opciones de usuarios");
		System.out.println("3. Opciones de compra");
		System.out.println("4. " + ANSI_RED + "Salir del programa" + ANSI_WHITE);
	}
	
	protected void menuJuegos() {
        System.out.println("\n1." + ANSI_CYAN + "Agregar juegos" + ANSI_WHITE);
        System.out.println("2." + ANSI_CYAN + "Cambiar el estado de juegos" + ANSI_WHITE);
        System.out.println("3." + ANSI_CYAN + "Buscar juegos" + ANSI_WHITE);
        System.out.println("4." + ANSI_CYAN + "Ver lista de juegos" + ANSI_WHITE);
        System.out.println("5. " + ANSI_RED + "Volver" + ANSI_WHITE);
    }
	
	protected void menuUsuarios() {
		System.out.println("\n1. " + ANSI_CYAN + "Agregar usuarios" + ANSI_WHITE);
        System.out.println("2. " + ANSI_CYAN + "Eliminar usuarios" + ANSI_WHITE);
        System.out.println("3. " + ANSI_CYAN + "Modificar usuarios" + ANSI_WHITE);
        System.out.println("4." + ANSI_RED + " Volver" + ANSI_WHITE);
	}
	
	protected void menuCompras() {
		System.out.println("\n1. Generar compra");
		System.out.println("2. Volver");
	}
	
	protected int solicitarOpcion(Scanner sc) {
		System.out.print("\nIntroduce una opción: ");
		return sc.nextInt();
	}
	
	protected static String solicitarTexto(Scanner sc, String texto) {
		System.out.print(texto);
		return sc.nextLine();
	}
	
	protected void cartelera() {
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
		System.out.println("   __  _  _  ____  ___   __   ____ \r\n"
				+ " _(  )/ )( \\(  __)/ __) /  \\ / ___)\r\n"
				+ "/ \\) \\) \\/ ( ) _)( (_ \\(  O )\\___ \\\r\n"
				+ "\\____/\\____/(____)\\___/ \\__/ (____/");
	}
	
	public void menuUsuariosCartelera() {
		System.out.println(" _  _  ____  _  _   __   ____  __  __   ____ \r\n"
				+ "/ )( \\/ ___)/ )( \\ / _\\ (  _ \\(  )/  \\ / ___)\r\n"
				+ ") \\/ (\\___ \\) \\/ (/    \\ )   / )((  O )\\___ \\\r\n"
				+ "\\____/(____/\\____/\\_/\\_/(__\\_)(__)\\__/ (____/");
	}
	
	public void menuComprasCartelera() {
		System.out.println("  ___  __   _  _  ____  ____   __   ____ \r\n"
				+ " / __)/  \\ ( \\/ )(  _ \\(  _ \\ / _\\ / ___)\r\n"
				+ "( (__(  O )/ \\/ \\ ) __/ )   //    \\\\___ \\\r\n"
				+ " \\___)\\__/ \\_)(_/(__)  (__\\_)\\_/\\_/(____/");
	}
	
	protected void separador() {
		System.out.println(" ");
		for (int i = 0; i < 120; i++) {
			System.out.print("═");
		}
		System.out.println(" ");
	}
}
