package testing;

import java.util.ArrayList;


public class TestSuite extends SuperTest{
	
	ArrayList<SuperTest> testList;
	
	public TestSuite(String suiteName) {
		super(suiteName);
		testList = new ArrayList<SuperTest>();
	}

	public ArrayList<SuperTest> getTestList() {
		return testList;
	}
	
	public void addTestSuite(TestSuite testSuite) {
		testSuite.concatName(testSuite.getName());
		testList.add(testSuite);
	}
	
	public ArrayList<String> getTestNameList() {
		ArrayList<String> testNameList = new ArrayList<String>(); 
		for (SuperTest test : testList) {
			testNameList.add(test.getName());
		}
		return testNameList;
	}
	
	public boolean isSkiped() {
		return true;
	}

	public void test() throws AssertionException {
		//Polimorfismo.
	}
	
	public ArrayList<String> getTagList() {
		ArrayList<String> tagList = new ArrayList<String>();
		return tagList;
	}

	public void testSuite(TestRunner testRunner) throws AssertionException {
		testRunner.runSuite(this);
	}
	
	public void testSuiteWithTagList(TestRunner testRunner, ArrayList<String> tagList) throws AssertionException {
		testRunner.runSuiteWithTagList(this,tagList);
	}

	public void testSuiteWithRegularExpression(TestRunner testRunner, String regularExpression) throws AssertionException {
		testRunner.runSuiteWithRegularExpression(this,regularExpression);
	}

	public void testSuiteMatchingAny(TestRunner testRunner,String testNameRegularExpression,String testSuiteRegularExpression, ArrayList<String> tagList) throws AssertionException {
		testRunner.runSuiteMatchingAny(this,testNameRegularExpression,testSuiteRegularExpression,tagList);
	}
	
	public void testSuiteMatchingAll(TestRunner testRunner,String testNameRegularExpression,String testSuiteRegularExpression, ArrayList<String> tagList) throws AssertionException {
		testRunner.runSuiteMatchingAll(this,testNameRegularExpression,testSuiteRegularExpression,tagList);
	}
}
