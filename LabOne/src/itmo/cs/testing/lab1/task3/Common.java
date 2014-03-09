package itmo.cs.testing.lab1.task3;

public class Common {
	
	// logic part
	
	Ford ford;
	
	public void main() {
		
	}
	
	// инфа о Форде
	public Ford getFord() {
		return this.ford;
	}
	
	
	// initialize part
	
	{
		ford = new Ford();
	}
	
	private Common() {}
	
	private static Common instance = null;
	
	static {
		instance = new Common();
	}
	
	public static Common getInstance() {
		return instance;
	}
	
}
