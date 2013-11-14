package testing;

public abstract class TestSuiteWithSetup extends TestSuite implements Setupable{

	protected Context context;
	
	public TestSuiteWithSetup(String suiteName) {
		super(suiteName);
		context = new Context();
	}
	
	public Context getContext() {
		return context;
	}
	
	public void setObjectContext(String key, Object value) {
		context.setObject(key, value);
	}
	
	public void testSuite() throws SuiteException {
		setUp();
		throw new SuiteException();
	}

}
