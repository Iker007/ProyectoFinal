package Class;

import java.util.ArrayList;
import java.util.List;

public class Pokemon {
	private String nombre;
	private static int UNIQUE_ID = 0;
	private int uid = ++UNIQUE_ID;
	private Tipo[] tipo;
	private List<Movimiento> movimientos;
	private int atak;
	private int defense;
	private int hp;
	
	
	
	public Pokemon() {
		super();
	}
	
	

	
	public Pokemon(String nombre, int uid, Tipo[] tipo, List<Movimiento> movimientos, int atak, int defense, int hp) {
		super();
		this.nombre = nombre;
		this.uid = uid;
		this.tipo = tipo;
		this.movimientos = movimientos;
		this.atak = atak;
		this.defense = defense;
		this.hp = hp;
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




	public Tipo[] getTipo() {
		return tipo;
	}
	




	public void setTipo(Tipo[] tipo) {
		this.tipo = tipo;
	}




	public List<Movimiento> getMovimientos() {
		return movimientos;
	}




	public void setMovimientos(List<Movimiento> movimientos) {
		this.movimientos = movimientos;
	}




	public int getAtak() {
		return atak;
	}




	public void setAtak(int atak) {
		this.atak = atak;
	}




	public int getDefense() {
		return defense;
	}




	public void setDefense(int defense) {
		this.defense = defense;
	}




	public int getHp() {
		return hp;
	}




	public void setHp(int hp) {
		this.hp = hp;
	}




	public static void main(String[] arg0) {
		List<Pokemon> a = new ArrayList<Pokemon>();
		Pokemon p1 = new Pokemon();
		Pokemon p2 = new Pokemon();
		Pokemon p3 = new Pokemon();
		Pokemon p4 = new Pokemon();
		Pokemon p5 = new Pokemon();
		Pokemon p6 = new Pokemon();
		a.add(p1);
		a.add(p2);
		a.add(p3);
		a.add(p4);
		a.add(p5);
		a.add(p6);
		
		for (int i = 0; i <= 5; i++) {
			System.out.println(a.get(i).getUid());
		}
		
	}

	
	
	
	
	

}
