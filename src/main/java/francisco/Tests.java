package francisco;
import java.lang.String;

public abstract class Tests {
	
	Reporter report;
	
	public Tests() {
		report = new Reporter();
	}
	
	public abstract void run(); 
	
	protected boolean assertTrue(boolean expresion,String nameTest) {
		
		if (expresion == true) {
			reportTrue(nameTest);
			return true;
		}
		else {
			reportFalse(nameTest);
			return false;
		}
	}
	
	protected boolean assertFalse(boolean expresion,String nameTest) {
		
		if (expresion == false) {
			reportTrue(nameTest);
			return true;
		}
		else {
			reportFalse(nameTest);
			return false;
		}
	}
	
	protected void reportTrue(String nameTest) {
		report.reportTrueTest(nameTest);
	}
	
	protected void reportFalse(String nameTest) {
		report.reportFalseTest(nameTest);
	}

}
