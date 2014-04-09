package itmo.cs.testing.lab2.task1.core;

import itmo.cs.testing.lab2.task1.core.functions.Arccosec;
import itmo.cs.testing.lab2.task1.core.functions.Arcctg;
import itmo.cs.testing.lab2.task1.core.functions.Arcsec;
import itmo.cs.testing.lab2.task1.core.functions.Arcsin;
import itmo.cs.testing.lab2.task1.core.functions.Arctg;

public class RealFunctionFactory implements FunctionFactory {
	
	private double accuracy;
	
	public RealFunctionFactory(double accuracy) {
		this.accuracy = accuracy;
	}

	@Override
	public Function createArctg() {
		return new Arctg(accuracy);
	}

	@Override
	public Function createArcctg() {
		return new Arcctg(accuracy);
	}

	@Override
	public Function createArcsin() {
		return new Arcsin(accuracy);
	}

	@Override
	public Function createArccosec() {
		return new Arccosec(accuracy);
	}

	@Override
	public Function createArcsec() {
		return new Arcsec(accuracy);
	}

}
