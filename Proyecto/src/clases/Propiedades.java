package clases;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Propiedades {

	public static void main(String[] args) {

		Properties p = new Properties();
		p.setProperty("carpeta", "c:\\users\\all\\datos");
		p.setProperty("usuario", "red");
		p.setProperty("ventana", "800, 600");

		try {
			FileOutputStream fos = new FileOutputStream(new File("usuario.ini"));
			try {
				p.store(fos, "Configuración inicial");
			} catch (IOException e) {
				System.out.println("No se ha podido escribir en el fichero" + e.getMessage());

			} finally {
				try {
					fos.close();
				} catch (IOException e2) {

				}
			}
		} catch (FileNotFoundException e3) {
			System.out.println("No se ha podido abrir el fichero" + e3.getMessage());
		}

		System.out.println("Configuración inicial finalizada");
	}

}
