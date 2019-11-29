package clases;

import java.util.ArrayList;
import java.util.List;

public class Pokemon {
	private String nombre;
	private static int UNIQUE_ID = 0;
	private int uid = ++UNIQUE_ID;
	private Tipo tipo1;
	private Tipo tipo2;	
	private Movimiento movimiento1;
	private Movimiento movimiento2;
	private int atak;
	private int defense;
	private int hp;
	private int speed;

	public Pokemon() {
		super();
	}

	public Pokemon(String nombre, int uid, Tipo tipo1, Tipo tipo2, Movimiento movimiento1, Movimiento movimiento2,
			int atak, int defense, int hp, int speed) {
		super();
		this.nombre = nombre;
		this.uid = uid;
		this.tipo1 = tipo1;
		this.tipo2 = tipo2;
		this.movimiento1 = movimiento1;
		this.movimiento2 = movimiento2;
		this.atak = atak;
		this.defense = defense;
		this.hp = hp;
		this.speed = speed;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public static int getUNIQUE_ID() {
		return UNIQUE_ID;
	}

	public static void setUNIQUE_ID(int uNIQUE_ID) {
		UNIQUE_ID = uNIQUE_ID;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public Tipo getTipo1() {
		return tipo1;
	}

	public void setTipo1(Tipo tipo1) {
		this.tipo1 = tipo1;
	}


	public Tipo getTipo2() {
		return tipo2;
	}

	public void setTipo2(Tipo tipo2) {
		this.tipo2 = tipo2;
	}

	public Movimiento getMovimiento1() {
		return movimiento1;
	}

	public void setMovimiento1(Movimiento movimiento1) {
		this.movimiento1 = movimiento1;
	}

	public Movimiento getMovimiento2() {
		return movimiento2;
	}

	public void setMovimiento2(Movimiento movimiento2) {
		this.movimiento2 = movimiento2;
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

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
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
