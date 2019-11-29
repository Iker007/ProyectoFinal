package clases;

public class Entrenador {

	private String name;
	private int score;
	private String usuario;
	private String contraseña;
	private Pokemon pokemon1;
	private Pokemon pokemon2;
	private Pokemon pokemon3;
	private Pokemon pokemon4;
	private Pokemon pokemon5;
	private Pokemon pokemon6;

	public Entrenador() {}

	public Entrenador(String name, int score, String usuario, String contraseña, Pokemon pokemon1, Pokemon pokemon2,
			Pokemon pokemon3, Pokemon pokemon4, Pokemon pokemon5, Pokemon pokemon6) {
		this.name = name;
		this.score = score;
		this.usuario = usuario;
		this.contraseña = contraseña;
		this.pokemon1 = pokemon1;
		this.pokemon2 = pokemon2;
		this.pokemon3 = pokemon3;
		this.pokemon4 = pokemon4;
		this.pokemon5 = pokemon5;
		this.pokemon6 = pokemon6;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Pokemon getPokemon1() {
		return pokemon1;
	}

	public void setPokemon1(Pokemon pokemon1) {
		this.pokemon1 = pokemon1;
	}

	public Pokemon getPokemon2() {
		return pokemon2;
	}

	public void setPokemon2(Pokemon pokemon2) {
		this.pokemon2 = pokemon2;
	}

	public Pokemon getPokemon3() {
		return pokemon3;
	}

	public void setPokemon3(Pokemon pokemon3) {
		this.pokemon3 = pokemon3;
	}

	public Pokemon getPokemon4() {
		return pokemon4;
	}

	public void setPokemon4(Pokemon pokemon4) {
		this.pokemon4 = pokemon4;
	}

	public Pokemon getPokemon5() {
		return pokemon5;
	}

	public void setPokemon5(Pokemon pokemon5) {
		this.pokemon5 = pokemon5;
	}

	public Pokemon getPokemon6() {
		return pokemon6;
	}

	public void setPokemon6(Pokemon pokemon6) {
		this.pokemon6 = pokemon6;
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

	public int pokemonAleatorio() {
		return (int) Math.floor(Math.random() * 14 + 1);
		// equipo.add(Pokemon.getUid());
	}

	public void comprobarParaIniciarSesion() {

	}

}
