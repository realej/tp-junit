package testing;

import java.util.ArrayList;

public abstract class Test {
	protected String name;
	protected TestSuite testSuite;
	protected ArrayList<String> tagList;
	
	private Test(String name, TestSuite testSuite, ArrayList<String> tagList) {
		this.name = name;
		this.testSuite = testSuite;
		this.tagList = tagList;
	}
	
	public Test createTest(String testName) {
		if(testSuite.getTestNameList().contains(testName)) {
			testSuite.getTestNameList().add(testName);
			return createNewTest(testName);			
		}
		else {
			return null;
		}		
	}
	
	protected abstract Test createNewTest(String testName);
	
	public abstract void test() throws AssertionError;
	
	public String getSuiteName() {
		return testSuite.getSuiteName();
	}
	
	public ArrayList<String> getTagList() {
		return tagList;
	}
	
	public String getName() {
		return name;
	}
	
	public void setTag(String tag) {
		tagList.add(tag);
	}
	
}
