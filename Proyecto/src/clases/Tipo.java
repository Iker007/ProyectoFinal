package clases;

import java.io.Serializable;

public class Tipo implements Serializable{
	private String nombre;
	
	
	
	public Tipo() {
		super();
	}


	public Tipo(String nombre) {
		super();
		this.nombre = nombre;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
