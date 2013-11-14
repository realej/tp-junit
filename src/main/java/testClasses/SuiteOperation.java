package testClasses;
import testing.TestSuiteWithSetup;

public class SuiteOperation extends TestSuiteWithSetup{

	public SuiteOperation(String suiteName) {
		super(suiteName);
	}

	public void teardown() {
		
	}

	public void setUp() {
		setObjectContext("uno", 1);
		setObjectContext("dos", 2);
		setObjectContext("tres", 3);
	}

}
