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
	private String pokemon1String;
	private String pokemon2String;
	private String pokemon3String;
	private String pokemon4String;
	private String pokemon5String;
	private String pokemon6String;

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

	public String getPokemon1String() {
		return pokemon1String;
	}

	public void setPokemon1String(String pokemon1String) {
		this.pokemon1String = pokemon1String;
	}

	public String getPokemon2String() {
		return pokemon2String;
	}

	public void setPokemon2String(String pokemon2String) {
		this.pokemon2String = pokemon2String;
	}

	public String getPokemon3String() {
		return pokemon3String;
	}

	public void setPokemon3String(String pokemon3String) {
		this.pokemon3String = pokemon3String;
	}

	public String getPokemon4String() {
		return pokemon4String;
	}

	public void setPokemon4String(String pokemon4String) {
		this.pokemon4String = pokemon4String;
	}

	public String getPokemon5String() {
		return pokemon5String;
	}

	public void setPokemon5String(String pokemon5String) {
		this.pokemon5String = pokemon5String;
	}

	public String getPokemon6String() {
		return pokemon6String;
	}

	public void setPokemon6String(String pokemon6String) {
		this.pokemon6String = pokemon6String;
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
