/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package casosDePrueba;

import aplicacion.TestSetUp;
import aplicacion.testMultiplicacionCalculadora;
import java.io.IOException;
import tp.junit.TestRunner;
import tp.junit.TestSuite;

public class casoTres {

    public static void main(String[] args) throws IOException {
        TestRunner handler = new TestRunner();
        TestSuite suite = new TestSuite("suite");
        testMultiplicacionCalculadora testConSetUp = new testMultiplicacionCalculadora();
        TestSetUp setup = new TestSetUp();
        suite.addSetUp(setup);
        suite.addTest(testConSetUp);
        handler.run(suite);
    }
}
