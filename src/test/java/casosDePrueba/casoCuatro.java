package casosDePrueba;

import aplicacion.TestSetUp;
import aplicacion.testMultiplicacionCalculadora;
import aplicacion.testSumaCalculadoraConSetUp;
import java.io.IOException;
import tp.junit.TestRunner;
import tp.junit.TestSuite;

public class casoCuatro {
     public static void main(String[] args) throws IOException {
        TestRunner handler = new TestRunner();
        TestSuite suite = new TestSuite("suite");
        testMultiplicacionCalculadora testConSetUp = new testMultiplicacionCalculadora();
        testSumaCalculadoraConSetUp testConSetUp2 = new testSumaCalculadoraConSetUp();
        TestSetUp setup = new TestSetUp();
        suite.addSetUp(setup);
        suite.addTest(testConSetUp);
        suite.addTest(testConSetUp2);
        handler.run(suite);
    }
}
