package clases;

import java.util.List;

public class Entrenador {

	private String usuario;
	private int score;
	private String contraseña;
	private List<Pokemon> pokemons;

	public Entrenador() {
		
	}
	public Entrenador(String usuario, int score, String contraseña, List<Pokemon> pokemons) {
		super();
		this.score = score;
		this.usuario = usuario;
		this.contraseña = contraseña;
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





	public String getContraseña() {
		return contraseña;
	}





	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
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
