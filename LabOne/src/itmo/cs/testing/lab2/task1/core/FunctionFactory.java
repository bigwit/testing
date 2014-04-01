package itmo.cs.testing.lab2.task1.core;

import itmo.cs.testing.lab2.task1.core.functions.*;
import itmo.cs.testing.lab2.task1.core.FunctionNames;

import java.util.HashMap;
import java.util.Map;

public class FunctionFactory {

	private static Map<FunctionNames, Function> funcs =
			new HashMap<FunctionNames, Function>(){
		private static final long serialVersionUID = 16549L;
		
		{
			put(FunctionNames.CSC, new Csc());
			put(FunctionNames.TAN, new Tan());
			put(FunctionNames.SEC, new Sec());
			put(FunctionNames.CTG, new Ctg());
			put(FunctionNames.CUBE, new Cube());
			put(FunctionNames.SIN, new Sin());
		}
	};

	public static Function newFunction(FunctionNames name) {
		return funcs.get(name);
	}

}
