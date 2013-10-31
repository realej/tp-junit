package francisco;

public abstract class Test {
	
	public abstract void run(); 
	
	protected boolean assertTrue(boolean expresion) {
		
		if (expresion == true) {
			return true;
		}
		else {
			return false;
		}
	}
	
	protected boolean assertFalse(boolean expresion) {
		
		if (expresion == false) {
			return true;
		}
		else {
			return false;
		}
	}

}
