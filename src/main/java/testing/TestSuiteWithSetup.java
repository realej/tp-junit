package testing;

public abstract class TestSuiteWithSetup extends TestSuite implements Setupable{
	
	public TestSuiteWithSetup(String suiteName) {
		super(suiteName);
	}

	protected Context context;
	
	public Context getContext() {
		return context;
	}

}
