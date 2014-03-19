package itmo.cs.testing.lab1.task3;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FirstSentenceTest {

	private Event event;

	@Before
	public void setUp() throws Exception {
		event = new Event();
		event.first();
	}

	@Test
	public void testVialIsGlass() {
		assertTrue(event.isVialIsGlass());
	}
	
	@Test
	public void testFishIsYellowAndLittle() {
		assertTrue(event.isFishIsYellowAndLittle());
	}
	
	@Test
	public void testFishIsWink() {
		assertTrue(event.isWinkFish());
	}
	
	@Test
	public void testHasVialInHandFord() {
		assertTrue(event.getFord().hasVial());
	}
}
