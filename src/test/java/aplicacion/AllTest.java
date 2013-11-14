/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import java.io.IOException;
import tp.junit.*;

/**
 *
 * @author Julian
 */
public class AllTest {

    public static void main(String[] args) throws IOException {
        TestRunner handler = new TestRunner();
        TestSuite suite = new TestSuite("suite");
        //TestSuite suite1 = new TestSuite("suite1");
        TestCalculadora tcalc = new TestCalculadora();
        TestRestaCalculadora tRestaCalc = new TestRestaCalculadora();
        TestRestaCalculadoraCorrecta tRestaCalc2 = new TestRestaCalculadoraCorrecta();
        //testMultiplicacionCalculadora tSetUp = new testMultiplicacionCalculadora();
        //TestSetUp setup = new TestSetUp();
        //suite.addSetUp(setup);
        tcalc.addTag("SLOW");
        tRestaCalc.addTag("BD");  
        suite.addTest(tcalc); 
        suite.addTest(tRestaCalc);
        suite.addTest(tRestaCalc2);
        //handler.run(suite);
        //handler.runWithTag(suite,"SLOW,BD");
        //handler.runWithRegex(suite,".*Resta.*");
        handler.runWithTagAndRegex(suite,"SLOW,BD",".*Correcta.*");
    }
}
