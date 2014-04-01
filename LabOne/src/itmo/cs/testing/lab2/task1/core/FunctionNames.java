package itmo.cs.testing.lab2.task1.core;

public enum FunctionNames {
	CSC("csc"),
	TAN("tan"),
	SEC("cos"),
	SIN("sin"),
	CTG("cot"),
	CUBE("cube");
	
	private String name;
	
	FunctionNames(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
}
