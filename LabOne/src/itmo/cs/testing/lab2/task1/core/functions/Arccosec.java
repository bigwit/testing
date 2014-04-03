package itmo.cs.testing.lab2.task1.core.functions;

import itmo.cs.testing.lab2.task1.core.AbstractFunction;

public class Arccosec extends AbstractFunction {

	public Arccosec(double acc) {
		super(acc);
	}

	@Override
	public double calc(double x) {
		return new Arcsin(getAccuracy()).calc(1 / x);
	}

}
