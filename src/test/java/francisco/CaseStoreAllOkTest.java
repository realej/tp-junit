package francisco;

import java.io.FileNotFoundException;
import java.io.IOException;
import testClasses.SuiteSuma;
import testClasses.TestOtraSumaOperation;
import testClasses.TestSumaOperation;
import testing.Test;
import testing.TestRunner;
import testing.TestSuite;

public class CaseStoreAllOkTest {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        TestRunner runner = new TestRunner();
        TestSuite suiteSuma = new SuiteSuma("suiteSuma");
        Test tSuma = new TestSumaOperation("TestSuma");
        Test tSuma2 = new TestOtraSumaOperation("TestSuma2");
        suiteSuma.addTest(tSuma);
        suiteSuma.addTest(tSuma2);
        runner.addTestSuite(suiteSuma);
        runner.runTestOfSuite("suiteSuma");
        //No correra ningun test ya que todos fueron exitosos.
        runner.runTestOfSuiteStore("suiteSuma");

    }
}
