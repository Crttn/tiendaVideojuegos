package tiendaVideojuegos;

import java.io.File;
import java.io.IOException;

public class Tienda {
	
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
	
	
	public static void obtenerBalanceTienda() {
		int balanceInicial = 1000;
		int juegosActuales = Integer.parseInt(Videojuegos.obtenerPrecioTotal());
		int ganaciasCompras = Integer.parseInt(Compras.obtenerPrecioCompras());
		int balanceActual = balanceInicial - juegosActuales + ganaciasCompras;
		
		if (balanceActual > 0) {
			System.out.println("El balance actual de la tienda es de: " + estilosConsola.ANSI_GREEN + balanceActual + estilosConsola.ANSI_WHITE + "€");
		} else {
			System.out.println("El balance actual de la tienda es de: " + estilosConsola.ANSI_RED + balanceActual + estilosConsola.ANSI_WHITE + " €");
		}
		
	}
}
