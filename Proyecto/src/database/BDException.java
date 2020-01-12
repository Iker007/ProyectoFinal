package database;

//Esta clase sirve para que ponga el mensaje de los fallos de la BD
public class BDException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BDException(String mensaje, Throwable e) {
		super(mensaje,e);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
