package tiendaVideojuegos;

import java.io.*;
import java.util.Date;
import java.util.ArrayList;
import java.util.Scanner;
import java.text.SimpleDateFormat;

public class Compras {

	private static ArrayList<String[]> compras = new ArrayList<>();

	public static void crearArchivoCompras() {
		File archivo;
		archivo = new File("compras.txt");
		try {
			if (archivo.createNewFile()) {
				System.out.println("Archivo creado con éxito");
			} else {
				System.out.println("Error al crear el archivo");
			}
		} catch (IOException e) {
			e.printStackTrace(System.out);
		}
	}

	public static void cargarComprasEnArchivo() {
		compras.clear();
		try {
			BufferedReader br = new BufferedReader(new FileReader("compras.txt"));
			String linea;
			while ((linea = br.readLine()) != null) {
				String[] compraData = linea.split(", ");
				compras.add(compraData);
			}
			br.close();
		} catch (IOException e) {
			System.out.println("Error al cargar las compras.");
		}
	}

	public static void guardarCompraEnArchivo() {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("compras.txt"));
			for (String[] compra : compras) {
				bw.write(String.join(", ", compra));
				bw.newLine();
			}
			bw.close();
		} catch (IOException e) {
			System.out.println("Error al guardar las compras.");
		}
	}

	public static String generarIdCompra() {
		int id = compras.size() + 1;
		return Integer.toString(id);
	}

	public static void realizarCompra(Scanner sc) {
		String usuario = Usuarios.obtenerUsuario(sc);
		if (usuario == null) {
			System.out.println("\nNo se puede realizar la compra porque el usuario no fue encontrado.");
			return;
		}

		String juego = Videojuegos.obtenerJuego(sc);
		if (juego == null) {
			System.out.println("\nNo se puede realizar la compra porque el juego no fue encontrado.");
			return;
		}
		
		String precio = Videojuegos.obtenerPrecio(juego);

		Date myDate = new Date();
		String fecha = new SimpleDateFormat("dd-MM-yyyy").format(myDate);

		String id = generarIdCompra();
		String[] compra = { id + ", " + usuario + ", " + juego + ", " + precio + ", " + fecha };
		compras.add(compra);
		guardarCompraEnArchivo();
	}

	public static void listaCompras() {
		System.out.println("\nListado de compras registradas: \n");
		System.out.println(estilosConsola.ANSI_PURPLE + "Id   Dni    	  Serial	Prc   Fecha" + estilosConsola.ANSI_WHITE);

		// Calcular la longitud máxima de cada campo
		int[] maxLengths = new int[5];
		for (String[] compra : compras) {
			for (int i = 0; i < compra.length; i++) {
				maxLengths[i] = Math.max(maxLengths[i], compra[i].length());
			}
		}
		for (String[] compra : compras) {
			for (int i = 0; i < compra.length; i++) {
				System.out.print(compra[i]);
				// Añadir espacios para alinear los datos
				for (int j = 0; j < maxLengths[i] - compra[i].length() + 4; j++) {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
	
	public static String obtenerPrecioCompras() {
		int precio = 0;
		for(int i = 1; i < compras.size(); i++) {
			String[] juego = compras.get(i);
			int precioDelJuego = Integer.parseInt(juego[3]);
		    precio += precioDelJuego;
		}
		return String.valueOf(precio);
	}
}
