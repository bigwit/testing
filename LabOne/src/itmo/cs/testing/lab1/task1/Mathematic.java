package itmo.cs.testing.lab1.task1;

import static java.lang.Math.*;
import static java.lang.Double.*;

public class Mathematic {

	public static double calcArctg(double argument, double accuracy) {
		if (isNaN(argument) || isNaN(accuracy) 
				|| isInfinite(argument) || isInfinite(accuracy)
				|| abs(argument) >= 1)
			return NaN;
		final double sqrArg = pow(argument, 2);
		double prev = 0.0;
		double cur = argument;
		double numerator = argument;
		double result = argument;
		int i = 1;
		
		do {
			prev = cur;
			numerator *= sqrArg;
			cur = pow(-1, i) * numerator / ((i++ << 1) + 1);
			result += cur;
		} while (abs(prev - cur) > accuracy && i < MAX_ITERATIONS);
			
		
		return result;
	}

	private static final int MAX_ITERATIONS = 50_000_000;
}
