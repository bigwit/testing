package itmo.cs.testing.lab1.task3;

public class Common {
	
	// logic part
	
	Ford ford;
	Artur artur;
	
	
	// действия второго предложения
	public void sentenceTwo() {
		// все что делал форд - делается при инициализации
		artur = new Artur(); // артур 
		// моргая глазами
		artur.setEyesAction(new Action(Options.SIMPLE, "BLINK"));
		// смотрел
		artur.setAction(new Action(Options.SIMPLE, "WATCH"));
		// на него (Форда)
		artur.setFocus(ford);
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
