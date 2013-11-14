package testing;

import java.util.ArrayList;

public abstract class SuperTest {
	
	private String name;
	
	public SuperTest(String suiteName) {
		name = suiteName;
	}
	
	public String getName() {
		return name;
	}
	
	public abstract boolean isSkiped();

	public abstract ArrayList<SuperTest> getTestList();
	
	public abstract ArrayList<String> getTagList();
	
	public abstract void test() throws Throwable;
	
	public abstract void testSuite() throws SuiteException;
	
	public abstract void setSuite(SuperTest suite);

}