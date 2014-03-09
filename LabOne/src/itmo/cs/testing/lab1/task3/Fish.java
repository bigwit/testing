package itmo.cs.testing.lab1.task3;

import java.awt.Color;
import java.util.logging.Logger;

public class Fish {
	
	private static Logger log = Logger.getLogger(Fish.class.getName());
	
	private Color color;
	private Options size;
	private Action action;
	
	public Fish(Color clr, Options sz) {
		if(clr == null || sz == null) {
			log.warning("Некорректные данные. Будут применены параметры по умолчанию.");
			setDefaultParams();
		}
		// по умолчанию рыбка плавает, переливаясь
		action = new Action(Options.WINK, "SWIM");
	}
	
	// по умолчанию рыбка желтая и маленькая
	private void setDefaultParams() {
		this.color = Color.YELLOW;
		this.size = Options.SMALL;
	} 
	
	public Color getColor() {
		return this.color;
	}
	
	public Options getSize() {
		return this.size;
	}
	
	public Action getAction() {
		return this.action;
	}
	
}
