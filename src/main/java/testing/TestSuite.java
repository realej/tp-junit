package testing;

import java.util.ArrayList;


public class TestSuite extends SuperTest{
	
	protected String suiteName;
	ArrayList<SuperTest> testList;
	
	public TestSuite (String suiteName) {
		this.suiteName = suiteName;
	}
	
	public String getSuiteName() {
		return suiteName;
	}
	
	public ArrayList<SuperTest> getTestList() {
		return testList;
	}
	
	public ArrayList<String> getTestNameList() {
		ArrayList<String> testNameList = new ArrayList<String>(); 
		for (SuperTest test : testList) {
			testNameList.add(test.getName());
		}
		return testNameList;
	}
	
	public void addTest(Test test) {
		testList.add(test);
	}
	
	public boolean isSkiped() {
		return true;
	}

	public void test() throws AssertionException {
		//Polimorfismo.
	}
	
	public String getName() {
		return suiteName;
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
