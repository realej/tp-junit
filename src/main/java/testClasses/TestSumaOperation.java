package testClasses;

import testing.Assert;
import testing.AssertionException;
import testing.Test;

public class TestSumaOperation extends Test{
	
	public TestSumaOperation(String name) {
		super(name);
	}

	public void test() throws AssertionException {
		Operation operation = new Operation();
		int resultado = operation.suma(5,5);
		Assert.assertTrue(resultado == 10);
	}

}
