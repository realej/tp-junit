package francisco;

import java.io.IOException;

public abstract class Test {
	
	Reporter report;
	
	public Test() throws IOException {
		report = new Reporter("Reporte Tests");
	}
	
	public abstract void run(); 
	
	protected void assertTrue(boolean expresion) {
		
		if (expresion == true) {
			reportTrue();
		}
		else {
			reportFalse();
		}
	}
	
	protected void assertFalse(boolean expresion) {
		
		if (expresion == false) {
			reportTrue();
		}
		else {
			reportFalse();
		}
	}
	
	protected void reportTrue() {
		
	}
	
	protected void reportFalse() {
		
	}

}
