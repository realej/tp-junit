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
        TestSuite suite = new TestSuite();
        TestCalculadora tcalc = new TestCalculadora();
        suite.addTest(tcalc);
        suite.run();
    }
}
