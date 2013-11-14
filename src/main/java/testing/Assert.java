package testing;

public class Assert {
	
	public static void assertTrue(boolean expression) throws AssertionException {
		if (expression == false) {
			throw new AssertionException();
		}
	}
	
	public static void assertFalse(boolean expression) throws AssertionException {
		if (expression == true) {
			throw new AssertionException();
		}
	}
	
	public static void assertEquals(Object firstObject, Object secondObject) throws AssertionException {
		if (!firstObject.equals(secondObject)) {
			throw new AssertionException();
		}
	}
	
	public static void assertEquals(long first, long second) throws AssertionException {
		if (first == second) {
			throw new AssertionException();
		}
	}
	
	public static void assertEquals(double first, double second) throws AssertionException {
		if (first == second) {
			throw new AssertionException();
		}
	}
	
	
	
	
	
}
