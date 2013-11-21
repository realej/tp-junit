/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testClasses;

import testing.Assert;
import testing.NewTest;

/**
 *
 * @author Administrador
 */
public class TestTime extends NewTest {

    public TestTime(String testName, long time){
        super(testName,time);       
    }
    
    @Override
    public void runTest() throws Throwable {
       Thread.sleep(2000);
      Assert.assertTrue(true);
    }
    
}
