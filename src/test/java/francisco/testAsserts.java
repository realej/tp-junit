package francisco;

import org.junit.Test;

import testing.Assert;
import testing.AssertionException;

public class testAsserts {
	
	@Test(expected=AssertionException.class)
    public void assertFalseWhenTrue() throws AssertionException {
    	Assert.assertFalse(10 > 9);
	}
	
	@Test(expected=AssertionException.class)
    public void assertTrueWhenFalse() throws AssertionException {
    	Assert.assertTrue(10 < 9);
	}
	
	@Test(expected=AssertionException.class)
    public void assertEqualsObject() throws AssertionException {
    	Assert.assertEquals(3,3);
	}
	
	@Test(expected=AssertionException.class)
    public void assertEqualsLong() throws AssertionException {
		Assert.assertEquals(1234567898,1234567898);
	}
	
	@Test(expected=AssertionException.class)
    public void assertEqualsDouble() throws AssertionException {
		Assert.assertEquals(3.34534654565464,3.34534654565464);
	}
}
