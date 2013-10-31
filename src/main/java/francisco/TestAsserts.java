package francisco;

public class TestAsserts extends Test {

	public TestAsserts() {
		super();
	}

	public void testAssertTrueWhenTrue() {
		assertTrue(4 > 3,"testAssertTrueWhenTrue");
	}
	
	public void testAssertTrueWhenFalse() {
		assertTrue(4 < 3,"testAssertTrueWhenTrue");
	}
	
	public void testAssertFalseWhenFalse() {
		assertFalse(4 < 3,"testAssertTrueWhenTrue");
	}
	
	public void testAssertFalseWhenTrue() {
		assertFalse(4 > 3,"testAssertTrueWhenTrue");
	}
	
	
	public void run() {
		testAssertTrueWhenTrue();
		testAssertTrueWhenFalse();
		testAssertFalseWhenFalse();
		testAssertFalseWhenTrue();
	}

}
