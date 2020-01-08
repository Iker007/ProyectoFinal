import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import clases.Tipo;

public class TipoTest {

	private Tipo t;
	
	@Before
	public void setUp() {
		t = new Tipo("Fuego");
	}
	@Test
	public void testGetNombre() {
		assertEquals("Fuego", t.getNombre());
	}
}
