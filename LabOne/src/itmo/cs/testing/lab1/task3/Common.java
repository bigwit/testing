package itmo.cs.testing.lab1.task3;

import java.awt.Color;

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
		// создаем пожелания артура
		Desire desireArtur = new Desire();
		// за что можно было бы зацепиться
		desireArtur.setActions(new Action(Options.SIMPLE, "BE"), new Action(Options.SIMPLE, "CLING"));
		// что то ЗНАКОМОЕ. за что можно МЫСЛЕННО зацепиться
		desireArtur.setOptions(Options.MENTALLY, Options.FAMILIAR_ABOUT);
		artur.setDesire(desireArtur);
	}
	
	private String country = "Betelgeuse";
	
	// неполное предложение (последнее)
	public void sentencesFour() {
		// скворншельские матрицы
		SkvornshelskMatrix[] matrix = new SkvornshelskMatrix[1];
		
		// человек с Бетельгейзе
		Man someMan = new Man().setBirthplace(country);
		// с маленькой желтой рыбкой в руках
		someMan.putToHand(new Fish(Color.YELLOW, Options.SMALL));
		// предлагает засунуть рыбу в ухо)))
		someMan.setAction(new Action(Options.SIMPLE, "shove fish in ear"));
		
		artur = new Artur();
		// если бы рядом с нижним бельем дентрасси, скворншельскими 
		// матрацами и человеком с Бетельгейзе, держащим маленькую 
		// рыбку и предлагающим засунуть ее в ухо
		if(Dentrassi.getInstance().getUnderwear() != null && matrix != null && someMan.getBirthplace().equals(country)) {
			for(Eye eye : artur.getEyes()) {
				// он увидел пакет кукурузных хлопьев
				if(eye.getFocus().getClass() == CornflakesPacket.class) {
					// он чувствовал бы себя увереннее
					artur.setState(State.SURE);
				}
			}
		}
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
