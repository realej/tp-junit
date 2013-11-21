package testClasses;

import testing.NewTest;
import testing.Assert;

public class TestTime extends NewTest {

    public TestTime(String testName, Double time) {
        super(testName, time);
    }

    @Override
    public void runTest() throws Throwable {
        Thread.sleep(5000);
        Assert.assertTrue(true);
    }
}
