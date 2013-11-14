package testClasses;

import java.util.ArrayList;

import testing.Assert;
import testing.AssertionException;
import testing.Test;
import testing.TestSuite;

public class TestError extends Test {

	public TestError(String testName) {
		super(testName);
	}

	public void test() throws Throwable {
		ArrayList<String> list = new ArrayList<String>();
		list.add("uno");
		int index = 3;
		Assert.assertTrue(list.get(index) == "uno");
	}

}
