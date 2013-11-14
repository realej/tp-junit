package casosDePrueba;

import aplicacion.TestCalculadora;
import aplicacion.TestRestaCalculadora;
import aplicacion.TestRestaCalculadoraCorrecta;
import java.io.IOException;
import tp.junit.TestRunner;
import tp.junit.TestSuite;

public class CasoConTagRegex {
    public static void main(String[] args) throws IOException {
        TestRunner handler = new TestRunner();
        TestSuite suite = new TestSuite("suite");
        TestCalculadora tcalc = new TestCalculadora();
        TestRestaCalculadora tRestaCalc = new TestRestaCalculadora();
        TestRestaCalculadoraCorrecta tRestaCalc2 = new TestRestaCalculadoraCorrecta();
        tcalc.addTag("SLOW");
        tRestaCalc.addTag("BD");  
        suite.addTest(tcalc); 
        suite.addTest(tRestaCalc);
        suite.addTest(tRestaCalc2);
        handler.runWithTagAndRegex(suite,"SLOW,BD",".*Correcta.*");
    }
}
