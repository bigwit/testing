package itmo.cs.testing.lab1.task3;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.*;

public class ArturTest {

	private Artur testArtur;

	@Before
	public void setUp() {
		testArtur = new Artur();
	}

	/**
	 * Должен определить флакончик, на который фокусирует взгляд
	 */
	@Test
	public void shouldDetermineTheVial() {
		Vial stubVial = mock(Vial.class);
		
		testArtur.setFocus(stubVial);
		
		assertTrue(testArtur.isFocused(stubVial));
	}
	
	/**
	 * Должен различать разные флакончики
	 */
	@Test
	public void shouldDiscernObjectsOfSameType() {
		Vial first = mock(Vial.class);
		Vial second = mock(Vial.class);
		
		testArtur.setFocus(first);
		
		assertFalse(testArtur.isFocused(second));
	}

}
