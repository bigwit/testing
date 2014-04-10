package itmo.cs.testing.lab2.task1.core.functions;

import static java.lang.Math.*;

import static itmo.cs.testing.lab1.task1.Mathematic.*;

import itmo.cs.testing.lab2.task1.core.AbstractFunction;

public class Arcctg extends AbstractFunction {

	public Arcctg(double acc) {
		super(acc);
	}

	@Override
	public double calc(double arg) {
		return (PI / 2.0) - calcArctg(arg, getAccuracy());
	}

}
