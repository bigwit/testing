package itmo.cs.testing.lab2.task1;

import itmo.cs.testing.lab2.task1.core.Function;
import itmo.cs.testing.lab2.task1.core.FunctionFactory;
import itmo.cs.testing.lab2.task1.core.FunctionNames;

public class FunctionImpl implements Function {
	
	Function csc = FunctionFactory.newFunction(FunctionNames.CSC);
	Function sin = FunctionFactory.newFunction(FunctionNames.SIN);
	Function tan = FunctionFactory.newFunction(FunctionNames.TAN);
	Function sec = FunctionFactory.newFunction(FunctionNames.SEC);
	Function cub = FunctionFactory.newFunction(FunctionNames.CUBE);
	Function ctg = FunctionFactory.newFunction(FunctionNames.CTG);
	
	@Override
	public double calc(double arg) {
		return ((cub.calc(csc.calc(arg) - tan.calc(arg)) * sec.calc(arg)) / 
				(sin.calc(arg) - ctg.calc(arg))) - sec.calc(arg);
	}
}
