package clases;

import java.io.Serializable;

public class Movimiento implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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

	
	//Implementacion de eficacia por tipos
//	public int esEficaz(Movimiento mov) {
//		String tipo = mov.getTipo().getNombre();
//		int esEfectivo = 3;
//		if (tipo == "psychyc") {
//			// if(pokemon enemigo. gettipo = dark){
//			// return 1;}
//			// if(pokemon enemigo. gettipo = psychyc){
//			// return 1;}
//			// if(pokemon enemigo. gettipo = steel){
//			// return 1;}
//			// if(pokemon enemigo. gettipo = fight){
//			// return 2;}
//			// if(pokemon enemigo. gettipo = poison){
//			// return 2;}
//		} else if (tipo == "normal") {
//			// if(pokemon enemigo. gettipo = ghosts){
//			// return 1;}
//			// if(pokemon enemigo. gettipo = steel){
//			// return 1;}
//			// if(pokemon enemigo. gettipo = rock){
//			// return 1;}
//		} else if (tipo == "dark") {
//			// if(pokemon enemigo. gettipo = dark){
//			// return 1;}
//			// if(pokemon enemigo. gettipo = psychyc){
//			// return 2;}
//			// if(pokemon enemigo. gettipo = ghost){
//			// return 2;}
//			// if(pokemon enemigo. gettipo = steel){
//			// return 1;}
//			// if(pokemon enemigo. gettipo = fight){
//			// return 2;}
//		} else if (tipo == "fire") {
//			// if(pokemon enemigo. gettipo = fire){
//			// return 1;}
//			// if(pokemon enemigo. gettipo = steel){
//			// return 2;}
//			// if(pokemon enemigo. gettipo = water){
//			// return 1;}
//			// if(pokemon enemigo. gettipo = dragon){
//			// return 1;}
//			// if(pokemon enemigo. gettipo = ice){
//			// return 2;}
//			// if(pokemon enemigo. gettipo = plant){
//			// return 2;}
//		} else if (tipo == "steel") {
//			// if(pokemon enemigo. gettipo = fire){
//			// return 1;}
//			// if(pokemon enemigo. gettipo = water){
//			// return 1;}
//			// if(pokemon enemigo. gettipo = steel){
//			// return 1;}
//			// if(pokemon enemigo. gettipo = electric){
//			// return 1;}
//			// if(pokemon enemigo. gettipo = rock){
//			// return 2;}
//			// if(pokemon enemigo. gettipo = ice){
//			// return 2;}
//		} else if (tipo == "flying") {
//			// if(pokemon enemigo. gettipo = steel){
//			// return 1;}
//			// if(pokemon enemigo. gettipo = plant){
//			// return 2;}
//			// if(pokemon enemigo. gettipo = electric){
//			// return 1;}
//			// if(pokemon enemigo. gettipo = fight){
//			// return 2;}
//			// if(pokemon enemigo. gettipo = rock){
//			// return 1;}
//		} else if (tipo == "ghost") {
//			// if(pokemon enemigo. gettipo = normal){
//			// return 1;}
//			// if(pokemon enemigo. gettipo = ghost){
//			// return 2;}
//			// if(pokemon enemigo. gettipo = psych){
//			// return 2;}
//			// if(pokemon enemigo. gettipo = dark){
//			// return 1;}
//		} else if (tipo == "dragon") {
//			// if(pokemon enemigo. gettipo = steel){
//			// return 1;}
//			// if(pokemon enemigo. gettipo = dragon){
//			// return 2;}
//		} else if (tipo == "water") {
//			// if(pokemon enemigo. gettipo = fire){
//			// return 2;}
//			// if(pokemon enemigo. gettipo = water){
//			// return 1;}
//			// if(pokemon enemigo. gettipo = dragon){
//			// return 1;}
//			// if(pokemon enemigo. gettipo = plant){
//			// return 1;}
//			// if(pokemon enemigo. gettipo = rock){
//			// return 2;}
//		} else if (tipo == "electric") {
//			// if(pokemon enemigo. gettipo = water){
//			// return 2;}
//			// if(pokemon enemigo. gettipo = dragon){
//			// return 1;}
//			// if(pokemon enemigo. gettipo = plant){
//			// return 1;}
//			// if(pokemon enemigo. gettipo = elec){
//			// return 1;}
//			// if(pokemon enemigo. gettipo = flying){
//			// return 2;}
//		} else if (tipo == "plant") {
//			// if(pokemon enemigo. gettipo = water){
//			// return 2;}
//			// if(pokemon enemigo. gettipo = steel){
//			// return 1;}
//			// if(pokemon enemigo. gettipo = dragon){
//			// return 1;}
//			// if(pokemon enemigo. gettipo = fire){
//			// return 1;}
//			// if(pokemon enemigo. gettipo = flying){
//			// return 1;}
//			// if(pokemon enemigo. gettipo = poison){
//			// return 1;}
//			// if(pokemon enemigo. gettipo = rock){
//			// return 2;}
//		} else if (tipo == "poison") {
//			// if(pokemon enemigo. gettipo = plant){
//			// return 2;}
//			// if(pokemon enemigo. gettipo = steel){
//			// return 1;}
//			// if(pokemon enemigo. gettipo = ghost){
//			// return 1;}
//			// if(pokemon enemigo. gettipo = rock){
//			// return 1;}
//			// if(pokemon enemigo. gettipo = poison){
//			// return 1;}
//		} else if (tipo == "ice") {
//			// if(pokemon enemigo. gettipo = plant){
//			// return 2;}
//			// if(pokemon enemigo. gettipo = steel){
//			// return 1;}
//			// if(pokemon enemigo. gettipo = dragon){
//			// return 2;}
//			// if(pokemon enemigo. gettipo = flying){
//			// return 2;}
//			// if(pokemon enemigo. gettipo = water){
//			// return 1;}
//			// if(pokemon enemigo. gettipo = fire){
//			// return 1;}
//			// if(pokemon enemigo. gettipo = ice){
//			// return 1;}
//		} else if (tipo == "fight") {
//			// if(pokemon enemigo. gettipo = steel){
//			// return 2;}
//			// if(pokemon enemigo. gettipo = ghost){
//			// return 1;}
//			// if(pokemon enemigo. gettipo = rock){
//			// return 2;}
//			// if(pokemon enemigo. gettipo = flying){
//			// return 1;}
//			// if(pokemon enemigo. gettipo = psy){
//			// return 1;}
//			// if(pokemon enemigo. gettipo = ice){
//			// return 2;}
//			// if(pokemon enemigo. gettipo = dark){
//			// return 2;}
//			// if(pokemon enemigo. gettipo = normal){
//			// return 2;}
//			// if(pokemon enemigo. gettipo = poison){
//			// return 1;}
//		} else if (tipo == "rock") {
//			// if(pokemon enemigo. gettipo = fire){
//			// return 2;}
//			// if(pokemon enemigo. gettipo = steel){
//			// return 1;}
//			// if(pokemon enemigo. gettipo = ice){
//			// return 2;}
//			// if(pokemon enemigo. gettipo = flying){
//			// return 2;}
//			// if(pokemon enemigo. gettipo = fight){
//			// return 1;}
//		} else {
//			esEfectivo = 3;
//		}
//		return esEfectivo;
//	}

}
