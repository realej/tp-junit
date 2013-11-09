package testing;

public abstract class Test {
	protected String name;
	protected TestSuite testSuite;
	
	
	public abstract void test();
	public String getSuiteName() {
		return testSuite.getSuiteName();
	}
	
}
