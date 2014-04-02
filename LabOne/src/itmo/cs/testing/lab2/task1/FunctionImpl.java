package itmo.cs.testing.lab2.task1;

import itmo.cs.testing.lab2.task1.core.Function;
import itmo.cs.testing.lab2.task1.core.FunctionFactory;

public class FunctionImpl implements Function {
	
	Function csc = FunctionFactory.CSC;
	Function sin = FunctionFactory.SIN;
	Function tan = FunctionFactory.TAN;
	Function sec = FunctionFactory.SEC;
	Function cub = FunctionFactory.CUBE;
	Function ctg = FunctionFactory.CTG;
	
	@Override
	public double calc(double arg) {
		return ((cub.calc(csc.calc(arg) - tan.calc(arg)) * sec.calc(arg)) / 
				(sin.calc(arg) - ctg.calc(arg))) - sec.calc(arg);
	}
}
