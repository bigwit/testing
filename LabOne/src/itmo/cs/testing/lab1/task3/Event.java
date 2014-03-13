package itmo.cs.testing.lab1.task3;

import java.awt.Color;

import itmo.cs.testing.lab1.task3.Fish.Size;
import itmo.cs.testing.lab1.task3.Vial.Material;

public class Event {
	
	Ford ford;
	Artur artur;
	private boolean vialIsGlass;
	private boolean fishIsYellowAndLittle;
	private boolean isWink;
	
	public void first() {
		ford = new Ford();
		Vial v = new Vial(Material.GLASS);
		this.setVialIsGlass(true);
		
		Fish fish = new Fish(Color.YELLOW, Size.LITTLE);
		fish.setAction(new Action(Options.WINK, "BLINK"));
		v.putFish(fish);
		this.setFishIsYellowAndLittle(v.hasSmallFish() && v.hasYellowFish());
		
		this.setWink(fish.isWink());
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

	public boolean isWink() {
		return isWink;
	}

	public void setWink(boolean isWink) {
		this.isWink = isWink;
	}
	
}
