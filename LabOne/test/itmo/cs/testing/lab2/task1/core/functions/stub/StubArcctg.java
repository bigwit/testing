package itmo.cs.testing.lab2.task1.core.functions.stub;

import itmo.cs.testing.lab2.utils.Parser;

public class StubArcctg extends StubFunction {

	public StubArcctg() {
		super(Parser.parse("arcctg.txt"));
	}
}
