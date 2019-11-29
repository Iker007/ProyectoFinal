package clases;

import java.util.ArrayList;
import java.util.List;

public class Pokemon {
	private String nombre;
	private static int UNIQUE_ID = 0;
	private int uid = ++UNIQUE_ID;
	private Tipo tipo1;
	private Tipo tipo2;
	private String tipo1String;
	private String tipo2String;
	private Movimiento movimiento1;
	private Movimiento movimiento2;
	private String movimiento1String;
	private String movimiento2String;
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

	public String getTipo1String() {
		return tipo1String;
	}

	public void setTipo1String(String tipo1String) {
		this.tipo1String = tipo1String;
	}

	public Tipo getTipo2() {
		return tipo2;
	}

	public void setTipo2(Tipo tipo2) {
		this.tipo2 = tipo2;
	}

	public String getTipo2String() {
		return tipo2String;
	}

	public void setTipo2String(String tipo2String) {
		this.tipo2String = tipo2String;
	}

	public Movimiento getMovimiento1() {
		return movimiento1;
	}

	public void setMovimiento1(Movimiento movimiento1) {
		this.movimiento1 = movimiento1;
	}

	public String getMovimiento1String() {
		return movimiento1String;
	}

	public void setMovimiento1String(String movimiento1String) {
		this.movimiento1String = movimiento1String;
	}

	public Movimiento getMovimiento2() {
		return movimiento2;
	}

	public void setMovimiento2(Movimiento movimiento2) {
		this.movimiento2 = movimiento2;
	}

	public String getMovimiento2String() {
		return movimiento2String;
	}

	public void setMovimiento2String(String movimiento2String) {
		this.movimiento2String = movimiento2String;
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
