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
        TestSuite suite1 = new TestSuite("suite1");
        TestCalculadora tcalc = new TestCalculadora();
        TestRestaCalculadora tRestaCalc = new TestRestaCalculadora();
        testMultiplicacionCalculadora tSetUp = new testMultiplicacionCalculadora();
        TestSetUp setup = new TestSetUp();
        suite.addSetUp(setup);
        suite.addTest(tcalc);
        suite.addTest(suite1);
        suite1.addTest(tRestaCalc);
        suite.addTest(tSetUp);
        handler.init(suite);
    }
}
