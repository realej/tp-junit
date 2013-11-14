package com.fiuba.junit;

import aplicacion.TestCalculadora;
import aplicacion.TestError;
import aplicacion.TestRestaCalculadora;
import aplicacion.TestRestaCalculadoraCorrecta;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tp.junit.AssertException;
import tp.junit.TestCase;
import tp.junit.TestResult;
import tp.junit.TestSuite;

public class TestTp {

    public TestTp() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testSuiteRunFail() {
        TestSuite suite = new TestSuite("suite");
        TestResult result = new TestResult();
        TestRestaCalculadora tRestaCalc = new TestRestaCalculadora();
        suite.addTest(tRestaCalc);
        suite.run(result);
        assertEquals(result.getFailures().size(), 1);
    }

    @Test
    public void testSuiteRunCorrect() {
        TestSuite suite = new TestSuite("suite");
        TestResult result = new TestResult();
        TestRestaCalculadoraCorrecta tRestaCalc = new TestRestaCalculadoraCorrecta();
        suite.addTest(tRestaCalc);
        suite.run(result);
        assertEquals(result.getPasses().size(), 1);
    }

    @Test
    public void testAssertTrueCorrect() {
        boolean fallo = false;
        try {
            tp.junit.Assert.assertTrue(true);
        } catch (AssertException e) {
            fallo = true;
        }
        assertTrue(!fallo);
    }

    @Test
    public void testAssertTrueFail() {
        boolean fallo = false;
        try {
            tp.junit.Assert.assertTrue(false);
        } catch (AssertException e) {
            fallo = true;
        }
        assertTrue(fallo);
    }

    @Test
    public void testAssertFalseCorrect() {
        boolean fallo = false;
        try {
            tp.junit.Assert.assertFalse(false);
        } catch (AssertException e) {
            fallo = true;
        }
        assertTrue(!fallo);
    }

    @Test
    public void testAssertFalseFail() {
        boolean fallo = false;
        try {
            tp.junit.Assert.assertFalse(true);
        } catch (AssertException e) {
            fallo = true;
        }
        assertTrue(fallo);
    }

    @Test
    public void testAssertEqualsFail() {
        boolean fallo = false;
        try {
            tp.junit.Assert.assertEquals(1, 2);
        } catch (AssertException e) {
            fallo = true;
        }
        assertTrue(fallo);
    }

    @Test
    public void testAssertEqualsCorrect() {
        boolean fallo = false;
        try {
            tp.junit.Assert.assertEquals(1, 1);
        } catch (AssertException e) {
            fallo = true;
        }
        assertTrue(!fallo);
    }

    @Test
    public void testFail() {
        boolean fallo = false;
        try {
            tp.junit.Assert.fail();
        } catch (AssertException e) {
            fallo = true;
        }
        assertTrue(fallo);
    }

    @Test
    public void testSuiteAddTest() {
        TestSuite suite = new TestSuite("suite");
        TestResult result = new TestResult();
        TestCalculadora tcalc = new TestCalculadora();
        TestRestaCalculadora tRestaCalc = new TestRestaCalculadora();
        suite.addTest(tcalc);
        suite.addTest(tRestaCalc);
        suite.run(result);
        assertEquals(2, result.getTestCount());
    }

    @Test
    public void testTestCaseRegexTrue() {
        TestCase test = new TestCalculadora();
        test.regularExp(".*dora");
        assertTrue(test.isRunner());
    }

    @Test
    public void testTestCaseRegexFail() {
        TestCase test = new TestCalculadora();
        test.regularExp(".*cualquiera");
        assertFalse(test.isRunner());
    }

    @Test
    public void testAddTestCaseSameName() {
        TestSuite suite = new TestSuite("suite");
        TestCalculadora tcalc = new TestCalculadora();
        TestCalculadora tcalc2 = new TestCalculadora();
        suite.addTest(tcalc);
        boolean fallo = false;
        try {
            suite.addTest(tcalc2);
        } catch (Error e) {
            fallo = true;
        }
        assertTrue(fallo);
    }

    @Test
    public void testAddTestSuiteSameName() {
        TestSuite suite = new TestSuite("suite");
        TestSuite suite2 = new TestSuite("suite");
        boolean fallo = false;
        try {
            suite.addTest(suite2);
        } catch (Error e) {
            fallo = true;
        }
        assertTrue(fallo);
    }

    @Test
    public void testSuiteRegexMatch() {
        TestSuite suite = new TestSuite("suite");
        TestResult result = new TestResult();
        TestCalculadora tcalc = new TestCalculadora();
        TestRestaCalculadora tRestaCalc = new TestRestaCalculadora();
        suite.addTest(tcalc);
        suite.addTest(tRestaCalc);
        suite.regularExp(".*Resta.*");
        suite.run(result);
        assertEquals(1, result.getFailures().size());
        assertEquals(1, result.getSkipped().size());
        assertEquals(2, result.getTestCount());
    }

    @Test
    public void testSuiteRegexNotMatch() {
        TestSuite suite = new TestSuite("suite");
        TestResult result = new TestResult();
        TestCalculadora tcalc = new TestCalculadora();
        TestRestaCalculadora tRestaCalc = new TestRestaCalculadora();
        suite.addTest(tcalc);
        suite.addTest(tRestaCalc);
        suite.regularExp(".*Ninguno.*");
        suite.run(result);
        assertEquals(2, result.getSkipped().size());
        assertEquals(2, result.getTestCount());
    }

    @Test
    public void testSuiteRunError() {
        TestSuite suite = new TestSuite("suite");
        TestResult result = new TestResult();
        TestError tError = new TestError();
        suite.addTest(tError);
        suite.run(result);
        assertEquals(result.getError().size(), 1);
    }

    @Test
    public void testTagMatch() {

        TestSuite suite = new TestSuite("suite");
        TestResult result = new TestResult();
        TestCalculadora tcalc = new TestCalculadora();
        TestRestaCalculadora tRestaCalc = new TestRestaCalculadora();
        tcalc.addTag("SLOW");
        tRestaCalc.addTag("BD");
        suite.addTest(tcalc);
        suite.addTest(tRestaCalc);
        suite.haveTag("SLOW");
        suite.run(result);
        assertEquals(1, result.getPasses().size());
        assertEquals(1, result.getSkipped().size());
        assertEquals(2, result.getTestCount());
    }

    @Test
    public void testTagNotMatch() {

        TestSuite suite = new TestSuite("suite");
        TestResult result = new TestResult();
        TestCalculadora tcalc = new TestCalculadora();
        TestRestaCalculadora tRestaCalc = new TestRestaCalculadora();
        tcalc.addTag("SLOW");
        tRestaCalc.addTag("BD");
        suite.addTest(tcalc);
        suite.addTest(tRestaCalc);
        suite.haveTag("NOTEXIST");
        suite.run(result);
        assertEquals(2, result.getSkipped().size());
        assertEquals(2, result.getTestCount());
    }

    @Test
    public void testTagAndRegexMatch2() {

        TestSuite suite = new TestSuite("suite");
        TestResult result = new TestResult();
        TestCalculadora tcalc = new TestCalculadora();
        TestRestaCalculadora tRestaCalc = new TestRestaCalculadora();
        tcalc.addTag("SLOW");
        tRestaCalc.addTag("BD");
        suite.addTest(tcalc);
        suite.addTest(tRestaCalc);
        suite.haveTag("SLOW");
        suite.regularExp(".*Resta.*");
        suite.run(result);
        assertEquals(1, result.getPasses().size());
        assertEquals(1, result.getFailures().size());
        assertEquals(2, result.getTestCount());
    }

    @Test
    public void testTagAndRegexMatchTag() {

        TestSuite suite = new TestSuite("suite");
        TestResult result = new TestResult();
        TestCalculadora tcalc = new TestCalculadora();
        TestRestaCalculadora tRestaCalc = new TestRestaCalculadora();
        tcalc.addTag("SLOW");
        tRestaCalc.addTag("BD");
        suite.addTest(tcalc);
        suite.addTest(tRestaCalc);
        suite.haveTag("SLOW");
        suite.regularExp(".*NotMatch.*");
        suite.run(result);
        assertEquals(1, result.getSkipped().size());
        assertEquals(1, result.getPasses().size());
        assertEquals(2, result.getTestCount());
    }

    @Test
    public void testTagAndRegexMatchRegex() {

        TestSuite suite = new TestSuite("suite");
        TestResult result = new TestResult();
        TestCalculadora tcalc = new TestCalculadora();
        TestRestaCalculadora tRestaCalc = new TestRestaCalculadora();
        tcalc.addTag("SLOW");
        tRestaCalc.addTag("BD");
        suite.addTest(tcalc);
        suite.addTest(tRestaCalc);
        suite.haveTag("NotMatch");
        suite.regularExp(".*Resta.*");
        suite.run(result);
        assertEquals(1, result.getSkipped().size());
        assertEquals(1, result.getFailures().size());
        assertEquals(2, result.getTestCount());

    }
}