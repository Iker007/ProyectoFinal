package Class;

public class Tipo {
	private String nombre;
	private static int UNIQUE_ID = 0;
	private int uid = ++UNIQUE_ID;
	
	
	public Tipo() {
		super();
	}


	public Tipo(String nombre, int uid) {
		super();
		this.nombre = nombre;
		this.uid = uid;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getUid() {
		return uid;
	}


	public void setUid(int uid) {
		this.uid = uid;
	}
	
	

}
