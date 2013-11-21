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

public class CaseStoreFailAndNewTest {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        TestRunner runner = new TestRunner();
        TestSuite suiteSuma = new SuiteSuma("suiteSuma");
        Test tSuma = new TestSumaOperation("TestSuma");
        Test tSuma2 = new TestOtraSumaOperation("TestSuma2");
        Test time = new TestTime("tiempo", 1.0);
        suiteSuma.addTest(tSuma);
        suiteSuma.addTest(time);
        runner.addTestSuite(suiteSuma);
        runner.runTestOfSuite("suiteSuma");
        suiteSuma.addTest(tSuma2);
        //Solo corre el Test "tiempo" y TestSuma2 en runTestOfSuiteStore.
        runner.runTestOfSuiteStore("suiteSuma");

    }
}
