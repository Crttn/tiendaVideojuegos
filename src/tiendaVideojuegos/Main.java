package tiendaVideojuegos;

import java.io.*;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		File juegos = new File("juegos.txt");
		File usuarios = new File("usuarios.txt");
		File compras = new File("compras.txt");
		
		if (!juegos.exists()) {
			Videojuegos.crearArchivoJuegos();
		}
		
		if (!usuarios.exists()) {
			Usuarios.crearArchivoUsuarios();
		}
		
		if (!compras.exists()) {
			Compras.crearArchivoCompras();
		}
		
		estilosConsola estilos = new estilosConsola();

		Scanner sc = new Scanner(System.in);
		int opcion;
		int eleccion;

		estilos.separador();
		estilos.cartelera();

		do {
			Videojuegos.cargarJuegosEnArchivo();
			Usuarios.cargarUsuariosEnArchivo();
			Compras.cargarComprasEnArchivo();
			estilos.separador();
			estilos.menuPrincipalCartel();
			estilos.menuPrincipal();
			opcion = estilosConsola.solicitarOpcion(sc);
			switch (opcion) {
			case 1:
				// juegos.crearArchivoJuegos(); -- > Crear archivo "juegos.txt"
				estilos.separador();
				estilos.menuJuegosCartelera();
				estilos.menuJuegos();
				eleccion = estilosConsola.solicitarOpcion(sc);

				switch (eleccion) {
				case 1:
					Videojuegos.agregarJuego(sc);
					break;
				case 2:
					Videojuegos.cambiarEstadoJuego(sc);
					break;
				case 3:
					Videojuegos.buscarJuego(sc);
					break;
				case 4:
					Videojuegos.listaJuegos();
					break;
				case 5:
					System.out.println("\nVolviendo al menu principal");
					break;
				default:
					System.out.println("\nOpción no válida. Por favor, ingrese un número válido.");
				}

				break;
			case 2:
				estilos.separador();
				estilos.menuUsuariosCartelera();
				estilos.menuUsuarios();
				eleccion = estilosConsola.solicitarOpcion(sc);

				switch (eleccion) {
				case 1:
					Usuarios.agregarUsuario(sc);
					break;
				case 2:
					Usuarios.buscarUsuario(sc);
					break;
				case 3:
					Usuarios.listaUsuarios();
					break;
				case 4:
					Usuarios.modificarUsuario(sc);
					break;
				case 5:
					Usuarios.eliminarUsuario(sc);
					break;
				case 6:
					System.out.println("\nVolviendo al menu principal");
					break;
				default:
					System.out.println("\nOpción no válida. Por favor, ingrese un número válido.");
				}
				break;

			case 3:
				estilos.separador();
				estilos.menuComprasCartelera();
				estilos.menuCompras();
				eleccion = estilosConsola.solicitarOpcion(sc);

				switch (eleccion) {
				case 1:
					Compras.realizarCompra(sc);
					break;
				case 2:
					Compras.listaCompras();
					break;
				case 3:
					System.out.println("\nVolviendo al menu principal");
					break;
				default:
					System.out.println("\nOpción no válida. Por favor, ingrese un número válido.");
				}
				break;
			case 4:
				estilos.separador();
				estilos.menuTiendaCartelera();
				estilos.menuBalanceTienda();
				eleccion = estilosConsola.solicitarOpcion(sc);

				switch (eleccion) {
				case 1:
					Tienda.obtenerBalanceTienda();
					break;
				case 2:
					System.out.println("\nVolviendo al menu principal");
					break;
				default:
					System.out.println("\nOpción no válida. Por favor, ingrese un número válido.");
				}
				break;
			case 5:
				Videojuegos.guardarJuegos();
				System.out.println("\nSaliendo del programa.");
				break;
			default:
				System.out.println("\nOpción no válida. Por favor, ingrese un número válido.");
			}

		} while (opcion != 5);

	}
}
