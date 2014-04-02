package itmo.cs.testing.lab2.task1;

import itmo.cs.testing.lab2.task1.core.Function;
import itmo.cs.testing.lab2.task1.core.Functions;

public class FunctionImpl implements Function {
	
	Function csc = Functions.CSC;
	Function sin = Functions.SIN;
	Function tan = Functions.TAN;
	Function sec = Functions.SEC;
	Function cub = Functions.CUBE;
	Function ctg = Functions.CTG;
	
	@Override
	public double calc(double arg) {
		return ((cub.calc(csc.calc(arg) - tan.calc(arg)) * sec.calc(arg)) / 
				(sin.calc(arg) - ctg.calc(arg))) - sec.calc(arg);
	}
}
