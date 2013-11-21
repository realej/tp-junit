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
        Test tSuma = new TestSumaOperation("tSuma");
        Test time = new TestTime("tiempo",1);
        suiteSuma.addTest(tSuma);
        suiteSuma.addTest(time);
        runner.addTestSuite(suiteSuma);
        runner.run();
    }
}
