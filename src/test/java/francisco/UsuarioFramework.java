/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package francisco;
import testClasses.*;
import testing.*;

/**
 *
 * @author Julian
 */
public class UsuarioFramework {

    public static void main(String[] args) {
        TestRunner runner = new TestRunner();
        TestSuite suiteSuma = new SuiteSuma("suiteSuma");
        Test tSuma = new TestSumaOperation("tSuma");
        suiteSuma.addTest(tSuma);
        runner.addTestSuite(suiteSuma);
        runner.run();
    }
}
