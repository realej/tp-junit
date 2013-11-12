package testing;

import java.util.ArrayList;

public abstract class SuperTest {
	
	private String name;
	
	public abstract void test() throws AssertionException;
	
	public abstract boolean isSkiped();
	
	public abstract String getName();

	public abstract ArrayList<SuperTest> getTestList();
	
	public abstract ArrayList<String> getTagList();
	
	public abstract void testSuite(TestRunner testRunner) throws AssertionException;
	
	public abstract void testSuiteWithTagList(TestRunner testRunner, ArrayList<String> tagList) throws AssertionException;
	
	public abstract void testSuiteWithRegularExpression(TestRunner testRunner, String regularExpression) throws AssertionException;
	
	public abstract void testSuiteMatchingAny(TestRunner testRunner, String testNameRegularExpression, String testSuiteRegularExpression, ArrayList<String> tagList) throws AssertionException;
}