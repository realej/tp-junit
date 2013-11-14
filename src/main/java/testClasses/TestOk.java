package testClasses;

import testing.Assert;
import testing.Test;

public class TestOk extends Test{

	public TestOk(String testName) {
		super(testName);
	}

	@Override
	public void test() throws Throwable {
		Assert.assertTrue(true);	
	}

}
