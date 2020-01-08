import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import clases.Movimiento;
import clases.Tipo;

public class MovimientoTest {
	
	private Movimiento m;
	private Tipo t;
	
	@Before
	public void setUp() {
		Tipo t1 = new Tipo("Fuego");
		this.t = t1;
		m = new Movimiento("Ascuas", t1, 100, null);
	}
	
	@Test
	public void testGetNombre() {
		assertEquals("Ascuas", m.getNombre());
	}
	@Test
	public void testGetTipo() {
		assertEquals(t, m.getTipo());
	}
	@Test
	public void testGetDaño() {
		assertEquals(100, m.getDaño());
	}
	@Test
	public void testGetEfecto() {
		assertEquals(null, m.getEfecto());
	}

}
