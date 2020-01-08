import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import clases.Movimiento;
import clases.Pokemon;
import clases.Tipo;

public class PokemonTest {
	
	private Pokemon p;
	private Movimiento m1;
	private Movimiento m2;
	private Tipo t1;
	private Tipo t2;
	
	@Before
	public void setUp() {
		Tipo t1 = new Tipo("Fuego");
		Tipo t2 = new Tipo("Hielo");
		Movimiento m1 = new  Movimiento("Ascuas", t1, 50, null);
		Movimiento m2 = new  Movimiento("Granizo", t2, 0, "Tiempo");
		this.m1 = m1;
		this.m2 = m2;
		this.t1 = t1;
		this.t2 = t2;
		p = new Pokemon("alpha", 3, t1, t2, m1, m2, 100, 80, 90, 120);
	}
	
	@Test
	public void testGetNombre() {
		assertEquals("alpha", p.getNombre());
	}
	@Test
	public void testGetId() {
		assertEquals(3, p.getId());
	}
	@Test
	public void testGetTipo1() {
		assertEquals(t1, p.getTipo1());
	}
	@Test
	public void testGetTipo2() {
		assertEquals(t2, p.getTipo2());
	}
	@Test
	public void testGetMovimiento1() {
		assertEquals(m1, p.getMovimiento1());
	}
	@Test
	public void testGetMovimiento2() {
		assertEquals(m2, p.getMovimiento2());
	}
	@Test
	public void testGetAttack() {
		assertEquals(100, p.getAttack());
	}
	@Test
	public void testGetDefense() {
		assertEquals(80, p.getDefense());
	}
	@Test
	public void testGetHp() {
		assertEquals(90, p.getHp());
	}
	@Test
	public void testGetSpeed() {
		assertEquals(120, p.getSpeed());
	}
}
