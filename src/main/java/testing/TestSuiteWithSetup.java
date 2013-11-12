package testing;

public abstract class TestSuiteWithSetup extends TestSuite implements Setupable{

	protected Context context;
	
	public TestSuiteWithSetup(String suiteName) {
		super(suiteName);
	}
	
	public Context getContext() {
		return context;
	}
	
	public void setObjectContext(String key, Object value) {
		context.setObject(key, value);
	}

}
