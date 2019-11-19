package clases;

import java.util.ArrayList;

import interfaz.VentanaFinCombate;

public class Ranking {
	
	private int score1;
	private int score2;
	private String primero;
	private String segundo;
	private String tercero;
	private int debilitados;
	public Ranking() {
		super();
	}
	
	public int getScore1() {
		return score1;
	}

	public void setScore1(int score1) {
		this.score1 = score1;
	}

	public int getScore2() {
		return score2;
	}

	public void setScore2(int score2) {
		this.score2 = score2;
	}

	public String getPrimero() {
		return primero;
	}

	public void setPrimero(String primero) {
		this.primero = primero;
	}

	public String getSegundo() {
		return segundo;
	}

	public void setSegundo(String segundo) {
		this.segundo = segundo;
	}

	public String getTercero() {
		return tercero;
	}

	public void setTercero(String tercero) {
		this.tercero = tercero;
	}

	public int getDebilitados() {
		return debilitados;
	}

	public void setDebilitados(int debilitados) {
		this.debilitados = debilitados;
	}

	public void esGanadorEntrenador2(Entrenador e1, Entrenador e2) {
		debilitados = 0;
		score1 = e1.getScore();
		score2 = e2.getScore();
		ArrayList<Pokemon> pokemons = e1.getTeam();
		for(Pokemon p: pokemons) {
			if(p.equals(null)) {
				debilitados++;
			}
			if(debilitados == 6) {
				score2++;
				VentanaFinCombate v = new VentanaFinCombate();
			}
			else {
				score1++;
				VentanaFinCombate v = new VentanaFinCombate();
			}
		}
		e1.setScore(score1);
		e2.setScore(score2);
	}
	
}
