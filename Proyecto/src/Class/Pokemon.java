package Class;

public class Pokemon {
	private String nombre;
	private static int id;
	private Tipo[] tipo;
	private Movimiento[] movimientos;
	
	
	public Pokemon() {
		super();
	}


	public Pokemon(String nombre, Tipo[] tipo, Movimiento[] movimientos) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
		this.movimientos = movimientos;
	}
	
	
	

}
