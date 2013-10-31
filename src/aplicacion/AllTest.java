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
        TestSuite suite = new TestSuite();
        TestCalculadora tcalc = new TestCalculadora();
        TestRestaCalculadora tRestaCalc = new TestRestaCalculadora();
        suite.addTest(tcalc);
        suite.addTest(tRestaCalc);
        handler.init(suite);
     }
}
