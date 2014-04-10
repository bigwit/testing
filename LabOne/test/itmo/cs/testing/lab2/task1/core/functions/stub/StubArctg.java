package itmo.cs.testing.lab2.task1.core.functions.stub;

import itmo.cs.testing.lab2.utils.Parser;

public class StubArctg extends StubFunction {
	
	public StubArctg() {
		super(Parser.parse("/arctg.txt"));
	}
}
