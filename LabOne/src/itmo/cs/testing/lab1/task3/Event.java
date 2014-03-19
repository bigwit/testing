package itmo.cs.testing.lab1.task3;

import java.awt.Color;

import itmo.cs.testing.lab1.task3.Fish.Size;
import itmo.cs.testing.lab1.task3.Vial.Material;

public class Event {

	private Ford ford;
	private Artur artur;

	public Ford getFord() {
		return this.ford;
	}

	public Artur getArtur() {
		return this.artur;
	}

	/*	 first sentence	*/

	private boolean vialIsGlass;
	private boolean fishIsYellowAndLittle;
	private boolean isWink;

	public void first() {
		ford = new Ford();
		Vial v = new Vial(Material.GLASS);
		this.setVialIsGlass(true);
		ford.putToHand(v);
		Fish fish = new Fish(Color.YELLOW, Size.LITTLE);
		fish.setAction(new Action(Options.WINK, "BLINK"));
		v.putFish(fish);
		this.setFishIsYellowAndLittle(v.hasSmallFish() && v.hasYellowFish());
		this.setWinkFish(fish.isWink());
	}

	public boolean isVialIsGlass() {
		return vialIsGlass;
	}

	public void setVialIsGlass(boolean vialIsGlass) {
		this.vialIsGlass = vialIsGlass;
	}

	public boolean isFishIsYellowAndLittle() {
		return fishIsYellowAndLittle;
	}

	public void setFishIsYellowAndLittle(boolean fishIsYellowAndLittle) {
		this.fishIsYellowAndLittle = fishIsYellowAndLittle;
	}

	public boolean isWinkFish() {
		return isWink;
	}

	public void setWinkFish(boolean isWink) {
		this.isWink = isWink;
	}

	/*	 second sentence	*/

	public void second() {
		artur = new Artur();
		ford = new Ford();

		artur.setEyesAction(new Action(Options.NOTHING, "BLINK"));
		artur.setAction(new Action(Options.WINK, "WATCH"));
		artur.setFocus(ford);
	}

	/*	 third sentence   */

	public void third() {
		artur = new Artur();

		artur.setAction(new Action(Options.NOTHING, "WANT"));
		Desire desireArtur = new Desire();
		// за что можно было бы зацепиться
		desireArtur.setActions(new Action(Options.NOTHING, "BE"), new Action(Options.NOTHING, "CLING"));
		// что то ЗНАКОМОЕ. за что можно МЫСЛЕННО зацепиться
		desireArtur.setOptions(Options.MENTALLY, Options.FAMILIAR_ABOUT);
		artur.setDesire(desireArtur);
	}

	/*   fourth sentence   */

	public static final String COUNTRY = "Betelgeuse";
	public static final String SOME_MAN_ACTION = "SHOVE FISH IN EAR";
	
	private Man someMan;
	
	// скворншельские матрицы
	private SkvornshelskMatrix[] matrixes = new SkvornshelskMatrix[1];
	
	public SkvornshelskMatrix[] getMatrixes() {
		return this.matrixes;
	}
	
	public Man getSomeMan() {
		return this.someMan;
	}
	
	public void fourth() {
		// человек с Бетельгейзе
		someMan = new Man();
		someMan.setBirthplace(Event.COUNTRY);
		// с маленькой желтой рыбкой в руках
		someMan.putToHand(new Fish(Color.YELLOW, Size.LITTLE));
		// предлагает засунуть рыбу в ухо)))
		someMan.setAction(new Action(Options.NOTHING, "SHOVE FISH IN EAR"));

		artur = new Artur();
		artur.setFocus(new CornflakesPacket());
		
		// если бы рядом с нижним бельем дентрасси, скворншельскими 
		// матрацами и человеком с Бетельгейзе, держащим маленькую 
		// рыбку и предлагающим засунуть ее в ухо
		if(Dentrassi.getInstance().getUnderwear() != null && 
				getSomeMan() != null && 
				getMatrixes() != null &&
				getSomeMan().getBirthplace().equals(Event.COUNTRY)) {
			for(Eye eye : getArtur().getEyes()) {
				// он увидел пакет кукурузных хлопьев
				if(eye.getFocus().getClass() == CornflakesPacket.class) {
					// он чувствовал бы себя увереннее
					getArtur().setState(State.SURE);
					break;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		new Event().fourth();
		System.out.println("ok");
	}
	
}
