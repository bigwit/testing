package itmo.cs.testing.lab2.task1;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import itmo.cs.testing.lab2.task1.core.Function;
import itmo.cs.testing.lab2.task1.core.FunctionFactory;
import itmo.cs.testing.lab2.task1.core.RealFunctionFactory;
import itmo.cs.testing.lab2.task1.core.functions.stub.StubFunctionFactory;

import java.util.Arrays;
import java.util.List;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class FunctionTest {
	
	private static final double ACCURACY = 1e-6;
	
	private static final Function ETALON = new FunctionImpl(
			new StubFunctionFactory(), ACCURACY);
	
	private final Function testExpr;
	
	public FunctionTest(Function expr) {
		testExpr = expr;
	}
	
	@Test
	public void shouldCalcFunction() {
		for (double x = -1.0; x <= 1.0; x += 0.1) {
			double actualResult = testExpr.calc(x);
			double expected = ETALON.calc(x);
			assertEquals(expected, actualResult, ACCURACY * 10);
		}
	}
	
	@Test
	public void shouldReturnNaNWhenYieldLowerBounds() {
		final double invalidArg = -1.01;
		double actualResult = testExpr.calc(invalidArg);
		double expected = ETALON.calc(invalidArg);

		assertThat(actualResult, equalTo(expected));
	}
	
	@Test
	public void shouldReturnNaNWhenInvalidArgs() {
		final double invalidArg = Double.NaN;
		double actualResult = testExpr.calc(invalidArg);
		double expected = ETALON.calc(invalidArg);

		assertThat(actualResult, equalTo(expected));
	}
	
	@Test
	public void shouldReturnNaNWhenYieldUpperBounds() {
		final double invalidArg = 1.01;
		double actualResult = testExpr.calc(invalidArg);
		double expected = ETALON.calc(invalidArg);

		assertThat(actualResult, equalTo(expected));
	}

	@Parameters
	public static List<Object[]> data() {
		FunctionFactory real = new RealFunctionFactory(ACCURACY);
		FunctionFactory stub = new StubFunctionFactory();
		return Arrays.asList(new Object[][] {
				{ new FunctionImpl(real.createArcsin(), real.createArctg(), stub.createArcctg(), stub.createArccosec(), stub.createArcsec(), ACCURACY) },
				{ new FunctionImpl(stub.createArcsin(), real.createArctg(), real.createArcctg(), stub.createArccosec(), stub.createArcsec(), ACCURACY) },
				{ new FunctionImpl(real.createArcsin(), real.createArctg(), real.createArcctg(), stub.createArccosec(), stub.createArcsec(), ACCURACY) },
				{ new FunctionImpl(stub.createArcsin(), real.createArctg(), stub.createArcctg(), real.createArccosec(), stub.createArcsec(), ACCURACY) },
				{ new FunctionImpl(real.createArcsin(), real.createArctg(), stub.createArcctg(), real.createArccosec(), stub.createArcsec(), ACCURACY) },
				{ new FunctionImpl(stub.createArcsin(), real.createArctg(), real.createArcctg(), real.createArccosec(), stub.createArcsec(), ACCURACY) },
				{ new FunctionImpl(real.createArcsin(), real.createArctg(), real.createArcctg(), real.createArccosec(), stub.createArcsec(), ACCURACY) },
				{ new FunctionImpl(stub.createArcsin(), real.createArctg(), stub.createArcctg(), stub.createArccosec(), real.createArcsec(), ACCURACY) },
				{ new FunctionImpl(real.createArcsin(), real.createArctg(), stub.createArcctg(), stub.createArccosec(), real.createArcsec(), ACCURACY) },
				{ new FunctionImpl(stub.createArcsin(), real.createArctg(), real.createArcctg(), stub.createArccosec(), real.createArcsec(), ACCURACY) },
				{ new FunctionImpl(real.createArcsin(), real.createArctg(), real.createArcctg(), stub.createArccosec(), real.createArcsec(), ACCURACY) },
				{ new FunctionImpl(stub.createArcsin(), real.createArctg(), stub.createArcctg(), real.createArccosec(), real.createArcsec(), ACCURACY) },
				{ new FunctionImpl(real.createArcsin(), real.createArctg(), stub.createArcctg(), real.createArccosec(), real.createArcsec(), ACCURACY) },
				{ new FunctionImpl(stub.createArcsin(), real.createArctg(), real.createArcctg(), real.createArccosec(), real.createArcsec(), ACCURACY) },
				{ new FunctionImpl(real.createArcsin(), real.createArctg(), real.createArcctg(), real.createArccosec(), real.createArcsec(), ACCURACY) },
		});
	}

}
