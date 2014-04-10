package itmo.cs.testing.lab2.task1.core.functions.stub;

import itmo.cs.testing.lab2.utils.Parser;

public class StubArcsec extends StubFunction {

	public StubArcsec() {
		super(Parser.parse("/arcsec.txt"));
	}

	@Override
	public double calc(double arg) {
		return super.calc(1 / arg);
	}
}
