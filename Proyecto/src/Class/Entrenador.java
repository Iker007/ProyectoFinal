package Class;

import java.util.ArrayList;

public class Entrenador {
	
	private String name;
	private ArrayList<Pokemon> team;
	private int score;
	private String usuario;
	private String contrase�a;

	public Entrenador() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Pokemon> getTeam() {
		return crearEquipo();
	}

	public void setTeam(ArrayList<Pokemon> team) {
		this.team = team;
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

	public ArrayList<Pokemon> crearEquipo(){
		ArrayList<Pokemon> equipo = new ArrayList<Pokemon>();
		int i = 0;
		for(i = 0; i<= 6; i++) {
			int pok = (int) Math.floor(Math.random()*14+1);	
			//equipo.add(Pokemon.getUid());
		}		
		return equipo;
	}
	
	
}
