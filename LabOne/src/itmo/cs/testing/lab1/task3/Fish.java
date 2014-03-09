package itmo.cs.testing.lab1.task3;

import java.util.logging.Logger;

public class Fish {
	
	private static Logger log = Logger.getLogger(Fish.class.getName());
	
	private Options color;
	private Options size;
	private Action action;
	
	public Fish(Options clr, Options sz) {
		if(clr == null || sz == null) {
			log.warning("Не корректные данные. Будут применены параметры по умолчанию.");
			setDefaultParams();
		}
		// по умолчанию рыбка плавает, переливаясь
		action = new Action(Options.BLINK, "SWIM");
	}
	
	// по умолчанию рыбка желтая и маленькая
	private void setDefaultParams() {
		this.color = Options.YELLOW;
		this.size = Options.SMALL;
	} 
	
	public Options getColor() {
		return this.color;
	}
	
	public Options getSize() {
		return this.size;
	}
	
	public Action getAction() {
		return this.action;
	}
	
}
