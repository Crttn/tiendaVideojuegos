package tiendaVideojuegos;

import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;
import java.util.Random;

public class Videojuegos {

	private static ArrayList<String[]> juegos = new ArrayList<>();

	public static void crearArchivoJuegos() {
		File archivo;
		archivo = new File("juegos.txt");
		try {
			if (archivo.createNewFile()) {
				String[] etiquetas = {estilosConsola.ANSI_PURPLE +  "Serial", "Juego", "Ptf", "Estado", "Precio" + estilosConsola.ANSI_WHITE};
				juegos.add(etiquetas);
				guardarJuegosEnArchivo();
				System.out.println(estilosConsola.ANSI_GREEN + "Archivo creado con éxito" + estilosConsola.ANSI_WHITE);
			} else {
				System.out.println(estilosConsola.ANSI_RED + "Error al crear el archivo" + estilosConsola.ANSI_WHITE);
			}
		} catch (IOException e) {
			e.printStackTrace(System.out);
		}
	}

	public static void cargarJuegosEnArchivo() {
		juegos.clear();
		try {
			BufferedReader br = new BufferedReader(new FileReader("juegos.txt"));
			String linea;
			while ((linea = br.readLine()) != null) {
				String[] juegoData = linea.split(", ");
				juegos.add(juegoData);
			}
			br.close();
		} catch (IOException e) {
			System.out.println(estilosConsola.ANSI_RED + "Error al cargar los juegos." + estilosConsola.ANSI_WHITE);
		}
	}

	public static void agregarJuego(Scanner sc) {
		sc.nextLine();
		String nombre = estilosConsola.solicitarTexto(sc, "\nIntroduce el nombre del juego: ");
		String consola = estilosConsola.solicitarConsola(sc, "Introduce la consola: ");
		String estado = estilosConsola.solicitarEstado(sc, "Introduce el estado del juego: ");
		String precio = estilosConsola.solicitarTexto(sc, "Introduce el precio del juego: ");
		String serial = asignarSerial();
		String[] nuevoJuego = { serial, nombre, consola, estado.toLowerCase(), precio};
		juegos.add(nuevoJuego);
		guardarJuegosEnArchivo();
		System.out.println(estilosConsola.ANSI_GREEN + "\nJuego añadido correctamente.\n" + estilosConsola.ANSI_WHITE);
	}

	public static void guardarJuegosEnArchivo() {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("juegos.txt"));
			for (String[] juego : juegos) {
				bw.write(String.join(", ", juego));
				bw.newLine();
			}
			bw.close();
		} catch (IOException e) {
			System.out.println(estilosConsola.ANSI_RED + "Error al guardar los juegos." + estilosConsola.ANSI_WHITE);
		}
	}

	public static void guardarJuegos() {
		guardarJuegosEnArchivo();
		System.out.println(estilosConsola.ANSI_GREEN + "\nJuegos guardados correctamente en el archivo."
				+ estilosConsola.ANSI_WHITE);
	}

	private static String asignarSerial() {
		Random rd = new Random();
		StringBuilder serial = new StringBuilder();
		String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

		for (int i = 0; i < 10; i++) {
			int patron = rd.nextInt(caracteres.length());
			serial.append(caracteres.charAt(patron));
		}

		for (String[] serial1 : juegos) {
			if (serial1[0].equals(serial.toString())) {
				return asignarSerial();
			}
		}
		return serial.toString();
	}

	public static void buscarJuego(Scanner sc) {
		sc.nextLine();
		String nombre = estilosConsola.solicitarTexto(sc, "\nIntroduce el nombre del juego:");
		boolean encontrado = false;
		for (String[] juego : juegos) {
			if (juego[1].equals(nombre)) {
				System.out.println("\n" + estilosConsola.ANSI_GREEN + "Juego encontrado:" + estilosConsola.ANSI_WHITE);
				System.out.println(String.join(", ", juego));
				encontrado = true;
				break;
			}
		}
		if (!encontrado)
			System.out.println(estilosConsola.ANSI_RED + "\nJuego no encontrado." + estilosConsola.ANSI_WHITE);
	}

	public static void cambiarEstadoJuego(Scanner sc) {
		sc.nextLine();
		String serial = estilosConsola.solicitarTexto(sc, "\nIntroduce el Serial del juego a modificar: ");
		boolean encontrado = false;
		for (String[] juego : juegos) {
			if (juego[0].equals(serial)) {
				String nuevoEstado = estilosConsola.solicitarTexto(sc, "\nIngrese el nuevo estado del juego: ");
				juego[3] = nuevoEstado.toLowerCase();
				guardarJuegosEnArchivo();
				System.out.println(estilosConsola.ANSI_GREEN + "\nEl estado del juego se ha modificado correctamente."
						+ estilosConsola.ANSI_WHITE);
				encontrado = true;
				break;
			}
		}
		if (!encontrado)
			System.out.println("Juego no encontrado.");
	}

	public static void listaJuegos() {
		System.out.println("\nListado de juegos registrados: \n");

		// Calcular la longitud máxima de cada campo
		int[] maxLengths = new int[5];
		for (String[] juego : juegos) {
			for (int i = 0; i < juego.length; i++) {
				maxLengths[i] = Math.max(maxLengths[i], juego[i].length());
			}
		}
		// Imprimir la lista de juegos con formato de columnas
		for (String[] juego : juegos) {
			for (int i = 0; i < juego.length; i++) {
				System.out.print(juego[i]);
				// Añadir espacios para alinear los datos
				for (int j = 0; j < maxLengths[i] - juego[i].length() + 4; j++) {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

	public static String obtenerJuego(Scanner sc) {
		String serial = estilosConsola.solicitarTexto(sc, "\nIntroduce el serial del juego:");
		boolean encontrado = false;
		for (String[] juego : juegos) {
			if (juego[0].equals(serial)) {
				System.out.println("\n" + estilosConsola.ANSI_GREEN + "Juego encontrado:" + estilosConsola.ANSI_WHITE);
				encontrado = true;
				return serial;
			}
		}
		if (!encontrado)
			System.out.println(estilosConsola.ANSI_RED + "\nJuego no encontrado." + estilosConsola.ANSI_WHITE);
		return null;
	}
	
	public static String obtenerPrecio(String serial) {
		String precio = "";
		for(int i = 1; i < juegos.size(); i++) {
			String[] juego = juegos.get(i);
			if (juego[0].equals(serial)) {
				precio = juego[4];
			}
		}
		return precio;
	}
	
	public static String obtenerPrecioTotal() {
		int precio = 0;
		for(int i = 1; i < juegos.size(); i++) {
			String[] juego = juegos.get(i);
			int precioDelJuego = Integer.parseInt(juego[4]);
		    precio += precioDelJuego;
		}
		return String.valueOf(precio);
	}
}
