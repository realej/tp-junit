/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package casosDePrueba;

import aplicacion.*;
import tp.junit.TestRunner;
import tp.junit.TestSuite;
import tp.junit.TestCase;

/*
 * Unicidad de los nombres de TestCase
 */
public class casoUno {

    static class TestA extends TestCase {

        @Override
        public void runTest() {
        }
    }

    public static void main(String[] args) {
        TestRunner handler = new TestRunner();
        TestSuite B = new TestSuite();
        TestA A = new TestA();
        B.addTest(A);
        handler.init(B);
    }
}
