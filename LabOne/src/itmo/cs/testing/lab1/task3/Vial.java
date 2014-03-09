package itmo.cs.testing.lab1.task3;

import java.awt.Color;
import java.util.ArrayList;

// флакончик
public class Vial {
	
	Options[] options;
	ArrayList<Fish> fishes;
 	
	// инициализируя флакочик, делаем его стеклянным
	// и инициализируем пространство для погружения рыбок.
	// и добавляем рыбку (маленькую желтую)
	public Vial() {
		options = new Options[1];
		options[0] = Options.GLASS;
		fishes = new ArrayList<>();
		add(new Fish(Color.YELLOW, Options.SMALL));
	}
	
	// добавляем рыбку во флакончик
	private void add(Fish fish) {
		if(fish != null)
			this.fishes.add(fish);
	}
}
