package casosDePrueba;

import aplicacion.TestSetUp;
import aplicacion.TestSetUp2;
import aplicacion.testMultiplicacionCalculadora;
import aplicacion.testSumaCalculadoraConSetUp;
import java.io.IOException;
import tp.junit.TestRunner;
import tp.junit.TestSuite;

public class casoCinco {

    public static void main(String[] args) throws IOException {
        TestRunner handler = new TestRunner();
        TestSuite suite = new TestSuite("suite");

        TestSuite otraSuite1 = new TestSuite("otra suite 1");
        TestSetUp setup1 = new TestSetUp();
        otraSuite1.addSetUp(setup1);
        testMultiplicacionCalculadora testConSetUp = new testMultiplicacionCalculadora();
        otraSuite1.addTest(testConSetUp);

        TestSuite otraSuite2 = new TestSuite("otra suite 2");
        TestSetUp2 setup2 = new TestSetUp2();
        otraSuite2.addSetUp(setup2);

        testSumaCalculadoraConSetUp testConSetUp2 = new testSumaCalculadoraConSetUp();
        otraSuite2.addTest(testConSetUp2);

        suite.addTest(otraSuite1);
        suite.addTest(otraSuite2);

        TestSetUp setup = new TestSetUp();
        suite.addSetUp(setup);
        handler.run(suite);
    }
}
