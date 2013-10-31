package francisco;

public class TestAsserts extends Test {

	public TestAsserts() {
		super();
	}

	public void testAssertTrueWhenTrue() {
		assertTrue(assertTrue(4 > 3,"testAssertTrueWhenTrue"),"testCuatroMayorQueTres");
	}
	
	public void run() {
		testAssertTrueWhenTrue();
	}

}
