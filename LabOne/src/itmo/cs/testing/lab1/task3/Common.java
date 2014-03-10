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
	
	public void sentenceThree() {
		artur = new Artur();
		artur.setAction(new Action(Options.SIMPLE, "WANT"));
		Desire desireArtur = new Desire();
		// за что можно было бы зацепиться
		desireArtur.setActions(new Action(Options.SIMPLE, "BE"), new Action(Options.SIMPLE, "CLING"));
		// что то ЗНАКОМОЕ. за что можно МЫСЛЕННО зацепиться
		desireArtur.setOptions(Options.MENTALLY, Options.FAMILIAR_ABOUT);
		artur.setDesire(desireArtur);
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
