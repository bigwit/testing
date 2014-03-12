package itmo.cs.testing.lab1.task3;

import java.util.logging.Logger;

public class Hand {

	private Logger log = Logger.getLogger(Hand.class.getName());

	// предмет в руке
	private Object item;

	// по дефолту в руке хзч
	public Hand() {
		item = new Object();
	}

	/**
	 * Кладем в руку какой-то объект. Если объект равен <code>null</code>, то
	 * считается, что в руке ничего не лежит
	 */
	public void put(Object object) {
		if (object == null) {
			log.warning("Рука ничего не держит");
		}
		this.item = object;
	}

	public Object getItem() {
		return this.item;
	}

}
