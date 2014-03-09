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
	
	// кладем в руку какой-то конкретный объект
	// либо говорим какого типа объект положить
	public void put(Object object, Class<?> typeOfObject) {
		if(object == null && typeOfObject == null) {
			log.warning("негоже так... ");
			return;
		}
		if(object != null) {
			this.item = object;
			return;
		}
		try {
			Object objInHand = (Object)typeOfObject.newInstance();
			this.item = objInHand;
		} catch (Exception e) {
			// если такой объект не создается
			// ну что же... печалька.
			// кладем тогда в руку ... что попало
			log.warning("Не удалось взять в руку " + typeOfObject.getName() + ". Положим туда то-нибудь =)");
		}
	}
	
	public Object getItem() {
		return this.item;
	}
	
}
