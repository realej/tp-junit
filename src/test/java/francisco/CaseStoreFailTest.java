package francisco;

import java.io.FileNotFoundException;
import java.io.IOException;
import testClasses.SuiteSuma;
import testClasses.TestSumaOperation;
import testClasses.TestTime;
import testing.Test;
import testing.TestRunner;
import testing.TestSuite;

public class CaseStoreFailTest {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        TestRunner runner = new TestRunner();
        TestSuite suiteSuma = new SuiteSuma("suiteSuma");
        Test tSuma = new TestSumaOperation("TestSuma");
        Test time = new TestTime("tiempo", 1);
        suiteSuma.addTest(tSuma);
        suiteSuma.addTest(time);
        runner.addTestSuite(suiteSuma);
        runner.runTestOfSuite("suiteSuma");
        //Solo corre el Test "tiempo" en runTestOfSuiteStore ya que es el unico que fallo.
        runner.runTestOfSuiteStore("suiteSuma");

    }
}
