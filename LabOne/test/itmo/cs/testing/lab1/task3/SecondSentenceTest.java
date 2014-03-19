package itmo.cs.testing.lab1.task3;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SecondSentenceTest {
	
	private Event event;
	
	@Before
	public void setUp() {
		event = new Event();
		event.second();
	}
	
	@Test
	public void testWhatActionEyesIsBlink() {
		for(Eye eye : event.getArtur().getEyes()) {
			assertEquals(eye.getAction().getAction(), "BLINK");
		}
	}
	
	@Test
	public void testWhatArturIsWatch() {
		assertEquals(event.getArtur().getAction().getAction(), "WATCH");
	}
	
	@Test
	public void testWhatArturWatchToFord() {
		assertTrue(event.getArtur().isFocused(event.getFord()));
	}
	
}
