package francisco;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test
     */
    public void testApp()
    {
        assertTrue( true );
    }
    
	public void testAssertTrueWhenTrue() {
		TestAsserts test = new TestAsserts();
		assertTrue(test.assertTrue(true,"testAssertTrueWhenTrue"));
		
	}
	
	public void testAssertTrueWhenFalse() {
		TestAsserts test = new TestAsserts();
		assertTrue(test.assertTrue(true,"testAssertTrueWhenFalse"));	
	}
	
	public void testAssertFalseWhenFalse() {
		TestAsserts test = new TestAsserts();
		assertTrue(test.assertTrue(true,"testAssertFalseWhenFalse"));			
	}
	
	public void testAssertFalseWhenTrue() {
		TestAsserts test = new TestAsserts();
		assertTrue(test.assertTrue(true,"testAssertFalseWhenTrue"));	
	}
    
}
