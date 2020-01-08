package clases;

import java.util.ArrayList;
import java.util.List;

public class Pokemon {
	private String nombre;
	private int id;
	private Tipo tipo1;
	private Tipo tipo2;	
	private Movimiento movimiento1;
	private Movimiento movimiento2;
	private int attack;
	private int defense;
	private int hp;
	private int speed;

	public Pokemon() {
		super();
	}

	public Pokemon(String nombre, int id, Tipo tipo1, Tipo tipo2, Movimiento movimiento1, Movimiento movimiento2,
			int attack, int defense, int hp, int speed) {
		super();
		this.nombre = nombre;
		this.id = id;
		this.tipo1 = tipo1;
		this.tipo2 = tipo2;
		this.movimiento1 = movimiento1;
		this.movimiento2 = movimiento2;
		this.attack = attack;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getAttack() {
		return attack;
	}

	public void setAttack(int atak) {
		this.attack = atak;
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


	
}
