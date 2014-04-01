package itmo.cs.testing.lab2.task1.core.functions;

import itmo.cs.testing.lab2.task1.core.Function;

public class Cube implements Function {

	private static final double CUBE = 3;

	@Override
	public double calc(double arg) {
		return Math.pow(arg, CUBE);
	}

}
