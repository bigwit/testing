package itmo.cs.testing.lab1.task2;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Mockito.*;

import itmo.cs.testing.lab1.task3.Fish;
import itmo.cs.testing.lab1.task3.Ford;
import itmo.cs.testing.lab1.task3.Vial;
import itmo.cs.testing.lab1.task3.Vial.Material;

import org.junit.Before;
import org.junit.Test;

public class FordTest {
	
	private Ford ford;
	
	@Before
	public void setUp() {
		ford = new Ford();
	}

	/**
	 * Форд должен держать в руке стеклянный флакончик
	 */
	@Test
	public void shouldKeepVialInHand() {
		Fish dummyFish = mock(Fish.class);
		
		Vial vial = new Vial(Material.GLASS);
		vial.putFish(dummyFish);

		ford.putToHand(vial);
		
		assertThat(ford.hasVial(), is(true));
	}

}
