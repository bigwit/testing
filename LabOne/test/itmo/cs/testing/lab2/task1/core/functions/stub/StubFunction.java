package itmo.cs.testing.lab2.task1.core.functions.stub;

import static java.lang.Math.*;

import java.util.ArrayList;
import java.util.Collection;

import itmo.cs.testing.lab2.task1.core.Function;
import itmo.cs.testing.lab2.utils.ResultUnit;

public abstract class StubFunction implements Function {

	private final Collection<ResultUnit> source;
	
	public StubFunction(Collection<ResultUnit> values) {
		source = new ArrayList<>(values);
	}
	
	@Override
	public double calc(double arg) {
		for (ResultUnit unit : source) {
			double sourceArg = unit.getX();
			if (abs(sourceArg - arg) < 1e-9) {
				return unit.getY();
			}
		}
		return Double.NaN;
	}
	
}
