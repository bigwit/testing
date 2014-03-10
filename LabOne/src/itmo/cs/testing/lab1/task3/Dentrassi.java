package itmo.cs.testing.lab1.task3;

public class Dentrassi {
	
	private static Dentrassi instance = null;
	
	private Underwear underwear;
	
	private Dentrassi() {
		underwear = new Underwear();
	}
	
	static {
		instance = new Dentrassi();
	}
	
	public static Dentrassi getInstance() {
		return instance;
	}
	
	public Underwear getUnderwear() {
		return this.underwear;
	}
	
}
