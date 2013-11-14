package testClasses;

import testing.Assert;
import testing.AssertionException;
import testing.Test;

public class TestOtraSumaOperation extends Test{

	public TestOtraSumaOperation(String testName) {
		super(testName);
	}

	protected TestOtraSumaOperation createNewTest(String testName) {
		TestOtraSumaOperation test = new TestOtraSumaOperation(testName);
		return test;
	}

	public void test() throws AssertionException {
		Operation operation = new Operation();
		int resultado = operation.suma(1,5);
		Assert.assertFalse(resultado == 10);
	}
}
