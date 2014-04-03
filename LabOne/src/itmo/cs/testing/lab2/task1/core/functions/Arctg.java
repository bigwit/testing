package itmo.cs.testing.lab2.task1.core.functions;

import static itmo.cs.testing.lab1.task1.Mathematic.*;

import itmo.cs.testing.lab2.task1.core.AbstractFunction;

public class Arctg extends AbstractFunction {

	public Arctg(double acc) {
		super(acc);
	}

	@Override
	public double calc(double arg) {
		return calcArctg(arg, getAccuracy());
	}

}
