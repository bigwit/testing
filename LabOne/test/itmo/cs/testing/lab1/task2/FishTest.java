package itmo.cs.testing.lab1.task2;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import itmo.cs.testing.lab1.task3.Action;
import itmo.cs.testing.lab1.task3.Fish;
import itmo.cs.testing.lab1.task3.Options;

import org.junit.Before;
import org.junit.Test;

public class FishTest {

	private Fish testFish;

	@Before
	public void setUp() {
		testFish = new Fish();
	}
	
	/**
	 * Рыбка должна переливаться
	 */
	@Test
	public void shouldWink() {
		Action action = mock(Action.class);
		when(action.getActionEffect()).thenReturn(Options.WINK);
		
		testFish.setAction(action);
		
		assertTrue(testFish.isWink());
	}
	
	@Test
	public void shouldNotWink() {
		Action action = mock(Action.class);
		when(action.getActionEffect()).thenReturn(Options.NOTHING);
		
		testFish.setAction(action);
		
		assertFalse(testFish.isWink());
	}

}
