package testing;

import java.util.ArrayList;

public abstract class Test {
	protected String name;
	protected ArrayList<String> tagList;
	
	private Test(String name, ArrayList<String> tagList) {
		this.name = name;
		this.tagList = tagList;
	}
	
	public Test createTest(TestSuite testSuite, String testName) {
		if(!testSuite.getTestNameList().contains(testName)) {

			Test test = createNewTest(testName);
			testSuite.getTestList().add(test);
			return test;
		}
		else {
			return null;
		}		
	}
	
	protected abstract Test createNewTest(String testName);
	
	public abstract void test() throws AssertionException;
	
	
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
