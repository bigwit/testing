package itmo.cs.testing.lab1.task3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

public class ThirdSentenceTest {
	
	private Event event;
	
	@Before
	public void setUp() {
		event = new Event();
		event.third();
	}
	
	@Test
	public void testWhatArturIsWant() {
		assertEquals(event.getArtur().getAction().getAction(), "WANT");
	}
	
	@Test
	public void testWhatArturBeAndClingInDesire() {
		Desire desireArtur = new Desire();
		desireArtur.setActions(new Action(Options.NOTHING, "BE"), new Action(Options.NOTHING, "CLING"));
		desireArtur.setOptions(Options.MENTALLY, Options.FAMILIAR_ABOUT);
		
		assertThat(event.getArtur().getDesire(), CoreMatchers.equalTo(desireArtur));
	}
	
}
