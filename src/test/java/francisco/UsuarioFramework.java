/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package francisco;

import java.io.FileNotFoundException;
import java.io.IOException;
import testClasses.*;
import testing.*;

/**
 *
 * @author Julian
 */
public class UsuarioFramework {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        TestRunner runner = new TestRunner();
        TestSuite suiteSuma = new SuiteSuma("suiteSuma");
        Test tSuma = new TestSumaOperation("TestSuma");
        Test time = new TestTime("tiempo", 1.0);
        suiteSuma.addTest(tSuma);
        suiteSuma.addTest(time);
        runner.addTestSuite(suiteSuma);
        runner.runTestOfSuite("suiteSuma");
        Test tSuma2 = new TestOtraSumaOperation("TestSuma2");
        suiteSuma.addTest(tSuma2);
        runner.runTestOfSuiteStore("suiteSuma");

    }
}