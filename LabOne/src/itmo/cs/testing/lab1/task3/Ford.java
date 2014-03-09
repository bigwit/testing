package itmo.cs.testing.lab1.task3;

public class Ford extends Man {
	
	public Ford() {
		super();
		// при инициализации Форда кладем ему 
		// в левую руку стеклянный флакончик
		putVialToLeftHand();
	}
	
	private void putVialToLeftHand() {
		hands[0].put(null, Vial.class);
	}
	
}
