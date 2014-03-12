package itmo.cs.testing.lab1.task3;

import itmo.cs.testing.lab1.task3.Fish.Size;

import java.awt.Color;

/**
 * Флакончик
 */
public class Vial {

	/**
	 * Материал флакончика
	 */
	public static enum Material {
		GLASS, CRYSTAL
	}

	private Material material;
	
	private Fish fish;

	/**
	 * Инициализируем флакочик из указанного материала
	 */
	public Vial(Material m) {
		if (m == null)
			throw new IllegalArgumentException();
		material = m;
	}

	/** 
	 * добавляем рыбку во флакончик 
	 */
	public void putFish(Fish fish) {
		if (fish != null)
			this.fish = fish;
	}
	
	/**
	 * Содержит ли флакончик желтую рыбку
	 */
	public boolean hasYellowFish() {
		return (fish != null 
				&& Color.YELLOW.equals(fish.getColor()));
	}
	
	/**
	 * Содержит ли флакончик маленькую рыбку
	 */
	public boolean hasSmallFish() {
		return (fish != null 
				&& Size.LITTLE.equals(fish.getSize()));
	}

	/**
	 * Возвращает <code>true</code>, если флакончик стеклянный
	 */
	public boolean isGlass() {
		return Material.GLASS.equals(material);
	}
}
