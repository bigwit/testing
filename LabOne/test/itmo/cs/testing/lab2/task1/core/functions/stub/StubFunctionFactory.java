package itmo.cs.testing.lab2.task1.core.functions.stub;

import itmo.cs.testing.lab2.task1.core.Function;
import itmo.cs.testing.lab2.task1.core.FunctionFactory;

public class StubFunctionFactory implements FunctionFactory {

	@Override
	public Function createArctg() {
		return new StubArctg();
	}

	@Override
	public Function createArcctg() {
		return new StubArcctg();
	}

	@Override
	public Function createArcsin() {
		return new StubArcsin();
	}

	@Override
	public Function createArccosec() {
		return new StubArccosec();
	}

	@Override
	public Function createArcsec() {
		return new StubArcsec();
	}

}
