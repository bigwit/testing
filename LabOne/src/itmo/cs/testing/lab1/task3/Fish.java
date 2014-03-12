package itmo.cs.testing.lab1.task3;

import java.awt.Color;

public class Fish {
	
	/**
	 * Размер рыбки
	 */
	public static enum Size {
		LITTLE, BIG
	}
	
	private Color color;
	private Size size;
	private Action action;
	
	public Fish() {
		this(null, null);
	}
	
	public Fish(Color color, Size size) {
		this.color = (color != null) ? color : Color.YELLOW;
		this.size = (size != null) ? size : Size.LITTLE;
	}
	
	/**
	 * Цвет рыбки
	 */
	public Color getColor() {
		return this.color;
	}
	
	/**
	 * Размер рыбки
	 */
	public Size getSize() {
		return this.size;
	}
	
	/**
	 * Действие рыбки
	 */
	public Action getAction() {
		return this.action;
	}
	
	/**
	 * Переливается ли рыбка
	 */
	public boolean isWink() {
		return Options.WINK.equals(action.getActionEffect());
	}
	
	/**
	 * Задать рыбке новое действие
	 */
	public void setAction(Action action) {
		if (action == null)
			throw new IllegalArgumentException("action cannot be null");
		this.action = action;
	}
}
