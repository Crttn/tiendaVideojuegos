package tiendaVideojuegos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Tienda {
	
	private static ArrayList<String[]> archivos = new ArrayList<>();
	
	public static void crearArchivoTienda() {
		File archivo;
		archivo = new File("tienda.txt");
		try {
			if (archivo.createNewFile()) {
				System.out.println("Tienda.txt creado con éxito");
			} else {
				System.out.println("Error al crear tienda.txt");
			}
		} catch (IOException e) {
			e.printStackTrace(System.out);
		}
	}

	public static void cargarDatosTienda() {
		archivos.clear();
		try {
			BufferedReader br = new BufferedReader(new FileReader("tienda.txt"));
			String linea;
			while ((linea = br.readLine()) != null) {
				String[] compraData = linea.split(", ");
				archivos.add(compraData);
			}
			br.close();
		} catch (IOException e) {
			System.out.println("Error al cargar los archivos de tienda.");
		}
	}

	public static void guardarCompraEnArchivo() {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("tienda.txt"));
			for (String[] archivo : archivos) {
				bw.write(String.join(", ", archivo));
				bw.newLine();
			}
			bw.close();
		} catch (IOException e) {
			System.out.println("Error al guardar las compras.");
		}
	}
	
	
	public static void obtenerBalanceTienda() {
		int balanceInicial = 1000;
		int juegosActuales = Integer.parseInt(Videojuegos.obtenerPrecioTotal());
		int ganaciasCompras = Integer.parseInt(Compras.obtenerPrecioCompras());
		int balanceActual = balanceInicial - juegosActuales + ganaciasCompras;
		
		if (balanceActual > 0) {
			System.out.println("El balance actual de la tienda es de: " + estilosConsola.ANSI_GREEN + balanceActual + estilosConsola.ANSI_WHITE + "€");
		} else {
			System.out.println("El balance actual de la tienda es de: " + estilosConsola.ANSI_RED + balanceActual + estilosConsola.ANSI_WHITE + "€");
		}
		
	}
}
