package BaseDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GestorBD {
	
	private Connection conn = null;
	
	public void conectar() throws BDException {
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jbdc:sqlite:datos/ejemplo.bd");
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			throw new BDException("No se pudo cargar el driver", e);
		} catch (SQLException e) {
			// TODO: handle exception
			throw new BDException("No se ha podido conectar a la BD", e);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
