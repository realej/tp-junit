/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import tp.junit.*;

/**
 *
 * @author Julian
 */
public class AllTest {

    public static void main(String[] args) {
        TestRunner handler = new TestRunner();
        TestSuite suite = new TestSuite("suite");
        TestSuite suite1 = new TestSuite("suite");
        TestCalculadora tcalc = new TestCalculadora();
        TestCalculadora tcalc1 = new TestCalculadora();
        TestRestaCalculadora tRestaCalc = new TestRestaCalculadora();
        //testMultiplicacionCalculadora tSetUp = new testMultiplicacionCalculadora();
        //TestSetUp setup = new TestSetUp();
        //suite.addSetUp(setup);
        suite.addTest(tcalc);
//       suite.addTest(tcalc1);
        suite.addTest(suite1);
 //       suite1.addTest(tRestaCalc);
        handler.init(suite);
        //handler.init(suite,".*Resta.*");
    }
}
