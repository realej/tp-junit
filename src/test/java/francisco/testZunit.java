package francisco;

import static org.junit.Assert.*;

import org.junit.Test;

import testClasses.TestOtraSumaOperation;
import testClasses.TestSumaOperation;
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
	
	}

}
