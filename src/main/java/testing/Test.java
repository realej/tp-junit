package testing;

import java.util.ArrayList;
import java.util.Collections;

public abstract class Test extends SuperTest{
	protected String name;
	protected ArrayList<String> tagList;
	protected boolean isSkiped;
	
	
	private Test(String name, ArrayList<String> tagList) {
		super(name);
		this.tagList = tagList;
		isSkiped = false;
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
	
	public void testSuite(TestRunner testRunner) {
	
	}
	
	public ArrayList<String> getTagList() {
		Collections.sort(tagList);	
		return tagList;
	}
	
	public void setTag(String tag) {
		tagList.add(tag);
	}
	
	public String getName() {
		return name;
	}
	
	public boolean isSkiped() {
		return isSkiped;
	}
	
	public void skip() {
		isSkiped = true;
	}
	
	public void unSkip() {
		isSkiped = false;
	}
	
}
