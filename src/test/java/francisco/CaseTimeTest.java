/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package francisco;

import java.io.FileNotFoundException;
import java.io.IOException;
import testClasses.SuiteSuma;
import testClasses.TestOtraSumaOperation;
import testClasses.TestSumaOperation;
import testClasses.TestTime;
import testing.Test;
import testing.TestRunner;
import testing.TestSuite;

/**
 *
 * @author Administrador
 */
public class CaseTimeTest {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        TestRunner runner = new TestRunner();
        TestSuite suiteSuma = new SuiteSuma("suite");
        Test time = new TestTime("tiempo Max 1 seg", 1.0);
        suiteSuma.addTest(time);
        Test time2 = new TestTime("timepo Max 10 seg", 10.0);

        suiteSuma.addTest(time2);
        runner.addTestSuite(suiteSuma);
        runner.runTestOfSuite("suite");

    }
}
