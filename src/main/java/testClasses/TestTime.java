    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testClasses;

import testing.NewTest;
import testing.Assert;

/**
 *
 * @author Administrador
 */
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
