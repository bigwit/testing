package itmo.cs.testing.lab2.task1.core;

public abstract class AbstractFunction implements Function {

	private double acc;

	public AbstractFunction(double acc) {
		this.acc = acc;
	}
	
	public double getAccuracy() {
		return acc;
	}
	
}
