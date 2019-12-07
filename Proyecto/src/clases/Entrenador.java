package clases;

import java.util.List;

public class Entrenador {

	private String usuario;
	private int score;
	private String contrase�a;
	private List<Pokemon> pokemons;

	public Entrenador() {
		
	}
	public Entrenador(String usuario, int score, String contrase�a, List<Pokemon> pokemons) {
		super();
		this.score = score;
		this.usuario = usuario;
		this.contrase�a = contrase�a;
		this.pokemons = pokemons;
	}

	public int getScore() {
		return score;
	}





	public void setScore(int score) {
		this.score = score;
	}





	public String getUsuario() {
		return usuario;
	}





	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}





	public String getContrase�a() {
		return contrase�a;
	}





	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}





	public List<Pokemon> getPokemons() {
		return pokemons;
	}





	public void setPokemons(List<Pokemon> pokemons) {
		this.pokemons = pokemons;
	}





	public int pokemonAleatorio() {
		return (int) Math.floor(Math.random() * 14 + 1);
	}

	public void comprobarParaIniciarSesion() {

	}

}
