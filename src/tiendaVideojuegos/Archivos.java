package tiendaVideojuegos;

import java.io.*;

public class Archivos {
	
	File archivo;

	protected void crearArchivo() {
		archivo = new File("archivo.txt");
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
	
	protected void eliminarArchivo() {
		if (archivo.delete()) {
			System.out.println("Archivo eliminado con éxito");
		} else {
			System.out.println("Error al eliminar el archivo");
		}
	}
	
	protected void escribirArchivo() {
		try {
			FileWriter escritura = new FileWriter(archivo);
			escritura.write("Saludos xd, ");
			escritura.write("Saludos xd!!");
			escritura.close();
			System.out.println("Texto añadido con exito");
		} catch(IOException e) {
			e.printStackTrace(System.out);
		}
	}
}
