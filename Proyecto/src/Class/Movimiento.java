package Class;

public class Movimiento {
	private String nombre;
	private Tipo tipo;
	private int daño;
	private String efecto;

	
	public Movimiento() {
		super();
	}


	public Movimiento(String nombre, Tipo tipo, int daño, String efecto) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
		this.daño = daño;
		this.efecto = efecto;
	}

	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Tipo getTipo() {
		return tipo;
	}


	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}


	public int getDaño() {
		return daño;
	}


	public void setDaño(int daño) {
		this.daño = daño;
	}


	public String getEfecto() {
		return efecto;
	}


	public void setEfecto(String efecto) {
		this.efecto = efecto;
	}
	
	

}
