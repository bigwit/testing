package itmo.cs.testing.lab2.task1.core.functions;

import static java.lang.Math.*;
import static itmo.cs.testing.lab1.task1.Mathematic.*;

import itmo.cs.testing.lab2.task1.core.AbstractFunction;

public class Arcsec extends AbstractFunction {

	public Arcsec(double acc) {
		super(acc);
	}

	@Override
	public double calc(double x) {
		x = 1 / x;
		return 2 * calcArctg(sqrt((1 - x) / (1 + x)), getAccuracy());
	}

}
