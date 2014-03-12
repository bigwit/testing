package itmo.cs.testing.lab1.task3;

public class Ford extends Man {
	
	public Ford() {
		super();
	}
	
	/**
	 * Держит ли Форд в руке флакончик
	 */
	public boolean hasVial() {
		return (getTypeItemInHand() != null && getTypeItemInHand().equals(Vial.class));
	}
}
