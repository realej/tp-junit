package casosDePrueba;

import aplicacion.TestCalculadora;
import aplicacion.TestRestaCalculadora;
import aplicacion.TestRestaCalculadoraCorrecta;
import java.io.IOException;
import tp.junit.TestRunner;
import tp.junit.TestSuite;

/**
 *
 * @author Rosso
 */
public class CasoConRegex {
        public static void main(String[] args) throws IOException {
        TestRunner handler = new TestRunner();
        TestSuite suite = new TestSuite("suite");;
        TestCalculadora testCalc = new TestCalculadora();
        TestRestaCalculadora testRestaCalc = new TestRestaCalculadora();
        TestRestaCalculadoraCorrecta testRestaCalc2 = new TestRestaCalculadoraCorrecta();  
        suite.addTest(testCalc); 
        suite.addTest(testRestaCalc);
        suite.addTest(testRestaCalc2);
        handler.runWithRegex(suite,".*Correcta.*");
      
    }
}
