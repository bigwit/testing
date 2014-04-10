package itmo.cs.testing.lab2.task1.core.functions.stub;

import static java.lang.Math.*;

import itmo.cs.testing.lab2.utils.Parser;

public class StubArcsin extends StubFunction {

	public StubArcsin() {
		super(Parser.parse("/arcsin.txt"));
	}
	
	@Override
	public double calc(double arg) {
		double x = arg / sqrt(1 - pow(arg, 2));
		if (abs(x) < 1) {
			return super.calc(arg);
		} else {
			return Double.NaN;
		}
	}

}
