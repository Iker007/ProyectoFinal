package Class;

public class Movimiento {
	private String nombre;
	private Tipo tipo;
	private int da�o;
	private String efecto;

	
	public Movimiento() {
		super();
	}


	public Movimiento(String nombre, Tipo tipo, int da�o, String efecto) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
		this.da�o = da�o;
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


	public int getDa�o() {
		return da�o;
	}


	public void setDa�o(int da�o) {
		this.da�o = da�o;
	}


	public String getEfecto() {
		return efecto;
	}


	public void setEfecto(String efecto) {
		this.efecto = efecto;
	}
	
	

}
