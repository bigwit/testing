package itmo.cs.testing.lab1.task3;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FourthSentenceTest {
	
	private Event event;
	
	@Before
	public void setUp() {
		event = new Event();
		event.fourth();
	}
	
	@Test
	public void testWhatArturIsSureIfSomeObjectExists() {
		if(Dentrassi.getInstance().getUnderwear() != null && 
				event.getSomeMan() != null && 
				event.getMatrixes() != null &&
				event.getSomeMan().getBirthplace().equals(Event.COUNTRY)) {
			for(Eye eye : event.getArtur().getEyes()) {
				if(eye.getFocus().getClass() == CornflakesPacket.class) {
					assertEquals(event.getArtur().getState(), State.SURE);
					break;
				}
			}
		}
	}
	
	@Test
	public void testWhatSomeManFromBetelgeuse() {
		assertEquals(event.getSomeMan().getBirthplace(), Event.COUNTRY);
	}
	
	@Test
	public void testWhatSomeManIsGraly() {
		assertEquals(event.getSomeMan().getAction().getAction(), Event.SOME_MAN_ACTION);
	}
	
	@Test
	public void testWhatMatrixesExists() {
		assertNotNull(event.getMatrixes());
	}
	
	@Test
	public void testWhatDentrassiUnderwearExists() {
		assertNotNull(Dentrassi.getInstance().getUnderwear());
	}
	
	
}