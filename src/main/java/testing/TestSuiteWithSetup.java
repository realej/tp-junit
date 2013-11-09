package testing;

public abstract class TestSuiteWithSetup extends TestSuite implements Setupable{
	
	protected Context context;
	
	public Context getContext() {
		return context;
	}

}
