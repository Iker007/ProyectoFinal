import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import clases.Entrenador;
import clases.Movimiento;
import clases.Pokemon;
import clases.Tipo;

public class EntrenadorTest {

	private List<Pokemon> pokemons;
	
	private Entrenador e;
	
	@Before
	public void setUp() {
		List<Pokemon> pokemons = new ArrayList<Pokemon>();
		Tipo t1 = new Tipo("Agua");
		Tipo t2 = new Tipo("Fuego");
		Tipo t3 = new Tipo("Planta");
		Movimiento m1 = new Movimiento("Burbuja", t1, 100, "a");
		Movimiento m2 = new Movimiento("Ascuas", t2, 110, "b");
		Movimiento m3 = new Movimiento("Absorber", t3, 130, null);
		Movimiento m4 = new Movimiento("Hoja aguda", t3, 10, null);
		Pokemon p1 = new Pokemon("alpha", 0, t1, t2, m1, m2, 110, 120, 300, 80);
		Pokemon p2 = new Pokemon("beta", 0, t2, t3, m1, m3, 105, 120, 350, 120);
		Pokemon p3 = new Pokemon("delta", 0, t1, null, m4, m2, 90, 90, 400, 180);
		Pokemon p4 = new Pokemon("gamma", 0, t2, null, m3, m2, 50, 80, 500, 50);
		Pokemon p5 = new Pokemon("yota", 0, t1, t3, m1, m4, 180, 20, 200, 90);
		Pokemon p6 = new Pokemon("omega", 0, t2, t2, m3, m4, 150, 100, 600, 80);
		pokemons.add(p1);
		pokemons.add(p2);
		pokemons.add(p3);
		pokemons.add(p4);
		pokemons.add(p5);
		pokemons.add(p6);
		e = new Entrenador("RED", 100, "c", pokemons);
		this.pokemons = pokemons;

	}
	@Test
	public void testGetUsuario() {
		assertEquals("RED", e.getUsuario());
	}
	@Test
	public void testGetScore() {
		assertEquals(100, e.getScore());
	}
	@Test
	public void testGetContraseña() {
		assertEquals("c", e.getContraseña());
	}
	@Test
	public void testGetPokemons() {
		assertEquals(pokemons, e.getPokemons());
	}
}
