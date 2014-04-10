package itmo.cs.testing.lab2.task1.core.functions.stub;

import static java.lang.Math.*;

import itmo.cs.testing.lab2.utils.Parser;

public class StubArcsec extends StubFunction {

	public StubArcsec() {
		super(Parser.parse("/arcsec.txt"));
	}

	@Override
	public double calc(double arg) {
		arg = 1.0 / arg;
		double x = sqrt((1 - arg) / (1 + arg));
		if (abs(x) < 1) {
			return super.calc(arg);
		} else {
			return Double.NaN;
		}
	}
}
