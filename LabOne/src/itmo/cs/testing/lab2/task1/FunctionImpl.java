package itmo.cs.testing.lab2.task1;

import static java.lang.Math.pow;
import itmo.cs.testing.lab2.task1.core.AbstractFunction;
import itmo.cs.testing.lab2.task1.core.Function;
import itmo.cs.testing.lab2.task1.core.FunctionFactory;

public class FunctionImpl extends AbstractFunction {

	private Function cosec;
	private Function sin;
	private Function tg;
	private Function sec;
	private Function ctg;

	public FunctionImpl(Function arcSin, Function arcTg, Function arcCtg,
			Function arcCosec, Function arcSec, double acc) {
		super(acc);
		sin = arcSin;
		tg = arcTg;
		ctg = arcCtg;
		cosec = arcCosec;
		sec = arcSec;
	}

	public FunctionImpl(FunctionFactory factory, double accuracy) {
		super(accuracy);
		sin = factory.createArcsin();
		tg = factory.createArctg();
		ctg = factory.createArcctg();
		cosec = factory.createArccosec();
		sec = factory.createArcsec();
	}

	@Override
	public double calc(double arg) {
		double cosecValue = cosec.calc(1 / arg);
		double tgValue = tg.calc(arg);
		double secValue = sec.calc(1 / arg);
		double ctgValue = ctg.calc(arg);
		double sinValue = sin.calc(arg);
		return ((pow(cosecValue - tgValue, 3) * secValue) / (sinValue - ctgValue)) - secValue;
	}
}
