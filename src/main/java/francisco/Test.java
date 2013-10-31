package francisco;

import java.io.IOException;

import com.sun.xml.internal.bind.v2.runtime.Name;

public abstract class Test {
	
	Reporter report;
	
	public Test() throws IOException {
		report = new Reporter("Reporte Tests");
	}
	
	public abstract void run(); 
	
	protected void assertTrue(boolean expresion,String nameTest) throws IOException {
		
		if (expresion == true) {
			reportTrue(nameTest);
		}
		else {
			reportFalse(nameTest);
		}
	}
	
	protected void assertFalse(boolean expresion,String nameTest) throws IOException {
		
		if (expresion == false) {
			reportTrue(nameTest);
		}
		else {
			reportFalse(nameTest);
		}
	}
	
	protected void reportTrue(String nameTest) throws IOException {
		report.reportTrueTest(nameTest);
	}
	
	protected void reportFalse(String nameTest) throws IOException {
		report.reportFalseTest(nameTest);
	}

}
