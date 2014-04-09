package itmo.cs.testing.lab2.task1.core.functions.stub;

import java.util.HashMap;
import java.util.Map;

import itmo.cs.testing.lab2.task1.core.Function;
import itmo.cs.testing.lab2.utils.ResultUnit;

public abstract class StubFunction implements Function {

	private final Map<Double, Double> table = new HashMap<>();
	
	public StubFunction(Iterable<ResultUnit> values) {
		for (ResultUnit unit : values) {
			table.put(unit.getX(), unit.getY());
		}
	}
	
	@Override
	public double calc(double arg) {
		Double value = table.get(arg);
		return (value != null) ? value : Double.NaN;
	}
	
}
