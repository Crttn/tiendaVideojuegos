package tiendaVideojuegos;

import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;
import java.util.Random;

public class Videojuegos {
	
	private static ArrayList<String[]> juegos = new ArrayList<>();
	File archivo;
	
	protected void crearArchivoJuegos() {
		archivo = new File("juegos.txt");
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
	
	protected static void cargarJuegosEnArchivo() {
		juegos.clear();
		try {
			BufferedReader br = new BufferedReader(new FileReader("juegos.txt"));
			String linea;
			while((linea = br.readLine()) != null) {
				String[] juegoData = linea.split(", ");
                juegos.add(juegoData);
			}
			br.close();
		} catch (IOException e) {
			System.out.println("Error al cargar los juegos.");
		}
	}
	
	protected static void agregarJuego(Scanner sc) {
    	sc.nextLine();
        String nombre = estilosConsola.solicitarTexto(sc, "\nIntroduce el nombre del juego: ");
        String consola = estilosConsola.solicitarTexto(sc, "Introduce la consola: ");
        String estado = estilosConsola.solicitarTexto(sc, "Introduce el estado del juego: ");
        String serial = assignSerial();
        String[] nuevoJuego = {serial, nombre, consola, estado};
        juegos.add(nuevoJuego);
        guardarJuegosEnArchivo();
        System.out.println("\nJuego añadido correctamente.\n");
    }
	 
	protected static void guardarJuegosEnArchivo() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("juegos.txt"));
            for (String[] juego : juegos) {
                bw.write(String.join(", ", juego));
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            System.out.println("Error al guardar los juegos.");
        }
    }
	
	protected static void guardarJuegos() {
	    guardarJuegosEnArchivo();
	    System.out.println("\nJuegos guardados correctamente en el archivo.");
	}

    private static String assignSerial() {
        Random rd = new Random();
        StringBuilder serial = new StringBuilder();
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

        for (int i = 0; i < 10; i++) {
            int patron = rd.nextInt(caracteres.length());
            serial.append(caracteres.charAt(patron));
        }
        return serial.toString();
    }
    
    protected static void buscarJuego(Scanner sc) {
        sc.nextLine();
        String nombre = estilosConsola.solicitarTexto(sc, "\nIntroduce el nombre del juego:" );
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
    
    protected static void cambiarEstadoJuego(Scanner sc) {
        sc.nextLine();
        String serial = estilosConsola.solicitarTexto(sc, "\\nIntroduce el Serial del juego a modificar: " );
        boolean encontrado = false;
        for (String[] juego : juegos) {
            if (juego[0].equals(serial)) {
                String nuevoEstado = estilosConsola.solicitarTexto(sc, "Ingrese el nuevo estado del juego: " );
                juego[3] = nuevoEstado; 
                guardarJuegosEnArchivo();
                System.out.println("\nEl estado del juego se ha modificado correctamente.");
                encontrado = true;
                break;
            }
        }
        if (!encontrado)
            System.out.println("Juego no encontrado.");
    }
    
    protected static void listaJuegos() {
    	System.out.println("\nListado de juegos registrados: \n");
    	System.out.println(estilosConsola.ANSI_PURPLE + "Serial        Juego         Ptf     Estado " + estilosConsola.ANSI_WHITE);

        // Calcular la longitud máxima de cada campo
        int[] maxLengths = new int[4];
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
    
    protected static String obtenerJuego(Scanner sc) {
        String serial = estilosConsola.solicitarTexto(sc, "\nIntroduce el serial del juego:" );
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
}
