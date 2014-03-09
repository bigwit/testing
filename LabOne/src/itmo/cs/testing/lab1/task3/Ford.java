package itmo.cs.testing.lab1.task3;

public class Ford extends Man {
	
	private Hand[] hands = new Hand[2];
	
	public Ford() {
		// при инициализации Форда кладем ему 
		// в левую руку стеклянный флакончик
		putVialToLeftHand();
	}
	
	private void putVialToLeftHand() {
		hands[0].put(null, Vial.class);
	}
	
}
