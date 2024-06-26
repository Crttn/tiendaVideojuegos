package tiendaVideojuegos;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Usuarios {

	private static ArrayList<String[]> usuarios = new ArrayList<>();

	public static void crearArchivoUsuarios() {
		File archivo;
		archivo = new File("usuarios.txt");
		try {
			if (archivo.createNewFile()) {
				System.out.println("Usuarios.txt creado con éxito");
			} else {
				System.out.println("Error al crear Usuarios.txt");
			}
		} catch (IOException e) {
			e.printStackTrace(System.out);
		}
	}

	public static void cargarUsuariosEnArchivo() {
		usuarios.clear();
		try {
			BufferedReader br = new BufferedReader(new FileReader("usuarios.txt"));
			String linea;
			while ((linea = br.readLine()) != null) {
				String[] usuarioData = linea.split(", ");
				usuarios.add(usuarioData);
			}
			br.close();
		} catch (IOException e) {
			System.out.println("Error al cargar los usuarios.");
		}
	}

	public static void guardarUsuariosEnArchivo() {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("usuarios.txt"));
			for (String[] usuario : usuarios) {
				bw.write(String.join(", ", usuario));
				bw.newLine();
			}
			bw.close();
		} catch (IOException e) {
			System.out.println("Error al guardar los usuarios.");
		}
	}

	public static void agregarUsuario(Scanner sc) {
		sc.nextLine();
		String nombre = estilosConsola.solicitarNombre(sc, "\nIntroduce el nombre del usuario: ");
		String apellido = estilosConsola.solicitarNombre(sc, "Introduce el primer apellido: ");
		String dni = estilosConsola.solicitarDni(sc, "Introduce el dni: ");
		String dniComprobado = comprobarDni(dni);
		if (dniComprobado != null) {
			String telefono = estilosConsola.solicitarTelefono(sc, "Introduce el teléfono: ");
			String telefonoComprobado = comprobarTelefono(telefono);
			if (telefonoComprobado != null) {
				String correo = estilosConsola.solicitarCorreo(sc, "Introduce el correo: ");
				String correoComprobado = comprobarCorreo(correo);
				if (correoComprobado != null) {
					String[] nuevoJuego = { telefono, nombre, apellido, dni, correo };
					usuarios.add(nuevoJuego);
					guardarUsuariosEnArchivo();
					System.out.println(estilosConsola.ANSI_GREEN + "\nUsuario añadido correctamente.\n"
							+ estilosConsola.ANSI_WHITE);
				} else {
					System.out.println(estilosConsola.ANSI_RED + "\nEl correo ya existe." + estilosConsola.ANSI_WHITE);
				}
			} else {
				System.out.println(estilosConsola.ANSI_RED + "\nEl teléfono ya existe." + estilosConsola.ANSI_WHITE);
			}
		} else {
			System.out.println(estilosConsola.ANSI_RED + "\nEl dni ya existe." + estilosConsola.ANSI_WHITE);
		}
	}

	public static String comprobarTelefono(String telefono) {
		for (String[] usuario : usuarios) {
			if (usuario[0].equals(telefono)) {
				return null;
			}
		}
		return telefono;
	}

	public static String comprobarDni(String dni) {
		for (String[] usuario : usuarios) {
			if (usuario[3].equals(dni)) {
				return null;
			}
		}
		return dni;
	}

	public static String comprobarCorreo(String correo) {
		for (String[] usuario : usuarios) {
			if (usuario[4].equals(correo)) {
				return null;
			}
		}
		return correo;
	}

	public static void buscarUsuario(Scanner sc) {
		sc.nextLine();
		String telefono = estilosConsola.solicitarTexto(sc, "\nIntroduce el teléfono del Usuario:");
		boolean encontrado = false;
		for (String[] usuario : usuarios) {
			if (usuario[3].equals(telefono)) {
				System.out
						.println("\n" + estilosConsola.ANSI_GREEN + "Usuario encontrado:" + estilosConsola.ANSI_WHITE);
				System.out.println(String.join(", ", usuario));
				encontrado = true;
				break;
			}
		}
		if (!encontrado)
			System.out.println(estilosConsola.ANSI_RED + "\nUsuario no encontrado." + estilosConsola.ANSI_WHITE);
	}

	public static void listaUsuarios() {
		System.out.println("\nListado de usuarios registrados: \n");
		System.out.println(estilosConsola.ANSI_PURPLE + "Teléfono       Nombre	 Apellidos	Dni	       Correo "
				+ estilosConsola.ANSI_WHITE);

		// Calcular la longitud máxima de cada campo
		int[] maxLengths = new int[5];
		for (String[] usuario : usuarios) {
			for (int i = 0; i < usuario.length; i++) {
				maxLengths[i] = Math.max(maxLengths[i], usuario[i].length());
			}
		}
		// Imprimir la lista de juegos con formato de columnas
		for (String[] usuario : usuarios) {
			for (int i = 0; i < usuario.length; i++) {
				System.out.print(usuario[i]);
				// Añadir espacios para alinear los datos
				for (int j = 0; j < maxLengths[i] - usuario[i].length() + 6; j++) {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

	public static void eliminarUsuario(Scanner sc) {
		sc.nextLine();
		String dni = estilosConsola.solicitarTexto(sc, "Ingrese el DNI del usuario que desea eliminar: ");
		boolean encontrado = false;
		for (String[] usuario : usuarios) {
			if (usuario[3].equals(dni)) {
				usuarios.remove(usuario);
				guardarUsuariosEnArchivo();
				System.out.println("\nUsuario eliminado correctamente.");
				encontrado = true;
				break;
			}
		}
		if (!encontrado)
			System.out.println("\nUsuario no encontrado.");
	}

	public static String obtenerUsuario(Scanner sc) {
		sc.nextLine();
		String dni = estilosConsola.solicitarTexto(sc, "\nIntroduce el dni del Usuario:");
		boolean encontrado = false;
		for (String[] usuario : usuarios) {
			if (usuario[3].equals(dni)) {
				System.out
						.println("\n" + estilosConsola.ANSI_GREEN + "Usuario encontrado." + estilosConsola.ANSI_WHITE);
				encontrado = true;
				return dni;
			}
		}
		if (!encontrado)
			System.out.println(estilosConsola.ANSI_RED + "\nUsuario no encontrado." + estilosConsola.ANSI_WHITE);
		return null;
	}

	public static void modificarUsuario(Scanner sc) {
		int opcion;
		do {
			estilosConsola.menuModUsuario();
			opcion = estilosConsola.solicitarOpcion(sc);
			switch (opcion) {
			case 1:
				sc.nextLine();
				String telefono = estilosConsola.solicitarTelefono(sc, "\nIntrodiuce el número de teléfono: ");
				boolean telefonoEncontrado = false;
				for (String[] usuario : usuarios) {
					if (usuario[0].equals(telefono)) {
						String nuevoTelefono = estilosConsola.solicitarTelefono(sc,
								"\nIntrodiuce el nuevo número de teléfono: ");
						usuario[0] = nuevoTelefono;
						guardarUsuariosEnArchivo();
						System.out.println(estilosConsola.ANSI_GREEN + "\nEl teléfono se ha cambiado correctamente."
								+ estilosConsola.ANSI_WHITE);
						telefonoEncontrado = true;
						break;
					}
				}
				if (!telefonoEncontrado) {
					System.out.println(estilosConsola.ANSI_RED + "El teléfono no pertenece a ningún usuario."
							+ estilosConsola.ANSI_WHITE);
				}
				break;
			case 2:
				sc.nextLine();
				String correo = estilosConsola.solicitarCorreo(sc, "\nIntrodiuce el correo: ");
				boolean correoEncontrado = false;
				for (String[] usuario : usuarios) {
					if (usuario[4].equals(correo)) {
						String nuevoCorreo = estilosConsola.solicitarCorreo(sc, "\nIntrodiuce el nuevo correo: ");
						usuario[4] = nuevoCorreo;
						guardarUsuariosEnArchivo();
						System.out.println(estilosConsola.ANSI_GREEN + "\nEl correo se ha cambiado correctamente."
								+ estilosConsola.ANSI_WHITE);
						correoEncontrado = true;
						break;
					}
				}
				if (!correoEncontrado) {
					System.out.println(estilosConsola.ANSI_RED + "El correo no pertenece a ningún usuario."
							+ estilosConsola.ANSI_WHITE);
				}
				break;
			case 3:
				System.out.println("Volviendo al menu principal");
				break;
			default:
				System.out.println("\nOpción no válida. Por favor, ingrese un número válido.");
			}
		} while (opcion != 3);
	}
}
