package itmo.cs.testing.lab2.task1.core.functions.stub;

import itmo.cs.testing.lab2.utils.Parser;

public class StubArccosec extends StubFunction {

	public StubArccosec() {
		super(Parser.parse("/arccosec.txt"));
	}

	@Override
	public double calc(double arg) {
		return super.calc(1 / arg);
	}
}
