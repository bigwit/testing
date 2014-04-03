package itmo.cs.testing.lab2.task1.core;

import itmo.cs.testing.lab2.task1.core.functions.*;

public final class Functions {

	private Functions() {}
	
	public static Function createArctg(double acc) {
		return new Arctg(acc);
	}
	
	public static Function createArcctg(double acc) {
		return new Arcctg(acc);
	}
	
	public static Function createArccosec(double acc) {
		return new Arccosec(acc);
	}
	
	public static Function createArcsec(double acc) {
		return new Arcsec(acc);
	}
	
	public static Function createArcsin(double acc) {
		return new Arcsin(acc);
	}
}
