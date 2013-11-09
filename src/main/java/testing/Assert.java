package testing;

public class Assert {
	
	public static void AssertTrue(boolean expression) throws AssertionException {
		if (expression == false) {
			throw new AssertionException();
		}
	}
	
	public static void AssertFalse(boolean expression) throws AssertionException {
		if (expression == true) {
			throw new AssertionException();
		}
	}
	
	public static void AssertEquals(Object firstObject, Object secondObject) throws AssertionException {
		if (!firstObject.equals(secondObject)) {
			throw new AssertionException();
		}
	}
	
	public static void AssertEquals(long first, long second) throws AssertionException {
		if (first == second) {
			throw new AssertionException();
		}
	}
	
	public static void AssertEquals(double first, double second) throws AssertionException {
		if (first == second) {
			throw new AssertionException();
		}
	}
	
	
	
	
	
}
