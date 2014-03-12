package itmo.cs.testing.lab1.task1;

import static java.lang.Double.*;
import static java.lang.Math.*;
import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class MathematicTest {

	private final double argument;

	private final double accuracy;

	private final double expected;

	public MathematicTest(double argument, double accuracy, double expected) {
		this.argument = argument;
		this.accuracy = accuracy;
		this.expected = expected;
	}

	@Parameters
	public static List<Object[]> data() {
		List<Object[]> data = new ArrayList<>();

		data.addAll(Arrays.asList(new Object[][] { { NaN, NaN, NaN },
				{ NaN, 1e-3, NaN }, { 1.0, NaN, NaN } }));

		for (double acc = 1e-3; acc > 1e-7; acc *= 1e-1) {
			for (double x = -2; x < 2; x += 1e-1) {
				data.add(new Object[] { x, acc, (abs(x) < 1) ?  atan(x) : NaN });
			}
		}
		return data;
	}

	@Test
	public void shouldReturnCorrectFunctionResult() {
		double result = Mathematic.calcArctg(argument, accuracy);

		assertEquals(expected, result, accuracy);
	}

}
