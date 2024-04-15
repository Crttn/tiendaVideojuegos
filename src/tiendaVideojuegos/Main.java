package tiendaVideojuegos;

import java.util.Scanner;


public class Main {
	
	public static void main(String[] args) {
		Archivos archivos = new Archivos();
		estilosConsola estilos = new estilosConsola();

		Scanner sc = new Scanner(System.in);
        int opcion;
        int eleccion;
        
        estilos.separador();
		estilos.cartelera();
		
		do {
			Videojuegos.cargarJuegosEnArchivo();
			estilos.separador();
			estilos.menuPrincipalCartel();
			estilos.menuPrincipal();
			opcion = estilos.solicitarOpcion(sc);
            switch(opcion) {
            	case 1:
            		// juegos.crearArchivoJuegos(); -- > Crear archivo "juegos.txt"
            		estilos.separador();
            		estilos.menuJuegosCartelera();
            		estilos.menuJuegos();
            		eleccion = estilos.solicitarOpcion(sc);
            		
            		
            		switch(eleccion) {
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
            			System.out.println("Volviendo al menu principal");
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, ingrese un número válido.");
            		}
            		
            		break;
            	case 2:
            		estilos.separador();
            		estilos.menuUsuariosCartelera();
            		estilos.menuUsuarios();
            		eleccion = estilos.solicitarOpcion(sc);
            		
            		switch(eleccion) {
            		case 1:
            			break;
            		case 2:
            			break;
            		case 3:
            			break;
            		case 4:
            			System.out.println("Volviendo al menu principal");
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, ingrese un número válido.");
            		}
            		break;
            		
            	case 3:
            		estilos.separador();
            		estilos.menuComprasCartelera();
            		estilos.menuCompras();
            		eleccion = estilos.solicitarOpcion(sc);
            		
            		switch(eleccion) {
            		case 1:
            			break;
            		case 2:
            			System.out.println("Volviendo al menu principal");
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, ingrese un número válido.");
            		}
            		break;
            		
            	case 4:
            		Videojuegos.guardarJuegos();
            		System.out.println("\nSaliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, ingrese un número válido.");
            }
            
		} while (opcion != 4);
		
		
	}
}
