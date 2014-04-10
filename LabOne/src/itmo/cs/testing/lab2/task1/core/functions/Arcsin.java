package itmo.cs.testing.lab2.task1.core.functions;

import static itmo.cs.testing.lab1.task1.Mathematic.calcArctg;
import static java.lang.Math.*;
import itmo.cs.testing.lab2.task1.core.AbstractFunction;

public class Arcsin extends AbstractFunction {

	public Arcsin(double acc) {
		super(acc);
	}

	@Override
	public double calc(double x) {
		double r = sqrt(1 - pow(x, 2));
		x = x / r;
		return calcArctg(x, getAccuracy());
	}

}
