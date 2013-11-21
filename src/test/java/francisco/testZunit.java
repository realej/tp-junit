package francisco;

import static org.junit.Assert.*;

import org.junit.Test;

import testClasses.SuiteOperation;
import testClasses.SuiteSuma;
import testClasses.TestError;
import testClasses.TestOk;
import testClasses.TestOtraSumaOperation;
import testClasses.TestSumaOperation;
import testing.AssertionException;
import testing.Context;
import testing.TestSuite;

public class testZunit {

    @Test
    public void nameTestOfSuiteUniqueness() {
        TestSumaOperation firstTest = new TestSumaOperation("test suma");
        TestOtraSumaOperation secondTest = new TestOtraSumaOperation("test suma");
        TestSuite suite = new TestSuite("suite");
        suite.addTest(firstTest);
        int resultado = suite.addTest(secondTest);
        assertTrue(resultado == 1);
    }

    @Test
    public void nameSuiteOfSuiteUniqueness() {
        TestSuite firstSuite = new TestSuite("first Suite");
        TestSuite secondSuite = new TestSuite("first Suite");
        TestSuite principalSuite = new TestSuite("principal suite");
        principalSuite.addTest(firstSuite);
        int resultado = principalSuite.addTest(secondSuite);
        assertTrue(resultado == 1);
    }

    @Test
    public void setupTestSuiteSimple() {
        SuiteOperation suite = new SuiteOperation("Suite");
        suite.setUp();
        Context context = suite.getContext();
        int object = (Integer) context.getObject("uno");
        assertTrue(object == 1);
    }

    @Test
    public void setupTestSuiteComplex() {
        SuiteOperation principalSuite = new SuiteOperation("Principal suite");
        SuiteSuma secondSuite = new SuiteSuma("Second Suite");
        principalSuite.setUp();
        secondSuite.setUp();
        Context principalContext = principalSuite.getContext();
        Context secondContext = secondSuite.getContext();
        int object = (Integer) principalContext.getObject("uno");
        int object2 = (Integer) secondContext.getObject("seis");
        assertTrue(object == 1);
        assertTrue(object2 == 6);
    }

    @Test
    public void testWithError() {
        TestError test = new TestError("test error");
        try {
            test.test();
        } catch (AssertionException exception) {
            assertTrue(false);
        } catch (Throwable e) {
            assertTrue(true);
        }
    }

    @Test
    public void testOk() {
        TestOk test = new TestOk("test OK");
        try {
            test.test();
        } catch (AssertionException exception) {
            assertTrue(false);
        } catch (Throwable e) {
            assertTrue(false);
        }
        assertTrue(true);
    }

}
