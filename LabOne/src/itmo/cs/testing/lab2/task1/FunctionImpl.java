package itmo.cs.testing.lab2.task1;

import static itmo.cs.testing.lab2.task1.core.Functions.*;

import static java.lang.Math.pow;
import itmo.cs.testing.lab2.task1.core.AbstractFunction;
import itmo.cs.testing.lab2.task1.core.Function;

public class FunctionImpl extends AbstractFunction {

	private Function csc;
	private Function sin;
	private Function tan;
	private Function sec;
	private Function ctg;
	
	public FunctionImpl(double acc) {
		super(acc);
		csc = createArccosec(acc);
		sin = createArcsin(acc);
		tan = createArctg(acc);
		sec = createArcsec(acc);
		ctg = createArctg(acc);
	}

	@Override
	public double calc(double arg) {
		return ((pow(csc.calc(arg) - tan.calc(arg), 3) * sec
				.calc(arg)) / (sin.calc(arg) - ctg.calc(arg)))
				- sec.calc(arg);
	}
}
