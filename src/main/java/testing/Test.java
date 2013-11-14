package testing;

import java.util.ArrayList;
import java.util.Collections;

public abstract class Test extends SuperTest{
	protected String name;
	protected ArrayList<String> tagList;
	protected boolean isSkiped;
	protected SuperTest suite;
	
	
	protected Test(String testName) {
		super(testName);
		this.tagList = new ArrayList<String>();
		isSkiped = false;
	}
	
	public Test createTest(String testName) {
		Test test = createNewTest(testName);
		return test;	
	}
	
	protected abstract Test createNewTest(String testName);
	
	public abstract void test() throws AssertionException;
	
	public void testSuite() {
		
	}
	
	public ArrayList<SuperTest> getTestList() {
		return null;
	}
	
	public ArrayList<String> getTagList() {
		Collections.sort(tagList);	
		return tagList;
	}
	
	public void setTag(String tag) {
		tagList.add(tag);
	}
	
	public void setSuite(SuperTest suite) {
		this.suite = suite; 
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
