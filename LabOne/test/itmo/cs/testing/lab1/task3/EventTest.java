package itmo.cs.testing.lab1.task3;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EventTest {

	private Event event;

	@Before
	public void setUp() throws Exception {
		event = new Event();
	}

	@Test
	public void testFisrtSentence() {
		event.first();
		
		assertTrue(event.isVialIsGlass() && event.isFishIsYellowAndLittle() && event.isWink());
	}
}
