package testClasses;

import testing.TestSuiteWithSetup;

public class SuiteSuma extends TestSuiteWithSetup {

	public SuiteSuma(String suiteName) {
		super(suiteName);
	}

	@Override
	public void setUp() {
		setObjectContext("cuatro", 4);
		setObjectContext("cinco", 5);
		setObjectContext("seis", 6);
	}

	public void teardown() {
		// TODO Auto-generated method stub
	}

}
