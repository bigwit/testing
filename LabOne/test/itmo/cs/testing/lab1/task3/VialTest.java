package itmo.cs.testing.lab1.task3;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import itmo.cs.testing.lab1.task3.Fish.Size;
import itmo.cs.testing.lab1.task3.Vial.Material;

import java.awt.Color;

import org.junit.Test;

public class VialTest {

	private Vial testVial;

	/**
	 * Во флакончике должна плавать маленькая желтая рыбка
	 */
	@Test
	public void shouldSwimLittleYellowFish() {
		final Fish dummyFish = mock(Fish.class);
		when(dummyFish.getColor()).thenReturn(Color.YELLOW);
		when(dummyFish.getSize()).thenReturn(Size.LITTLE);
		
		testVial = new Vial(Material.GLASS);
		testVial.putFish(dummyFish);
		
		assertTrue(testVial.hasSmallFish());
		assertTrue(testVial.hasYellowFish());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldCrashWhenMaterialIsNull() {
		testVial = new Vial(null);
		fail("should crash");
	}

}
