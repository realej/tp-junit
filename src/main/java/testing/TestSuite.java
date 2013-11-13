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
	}
	
	public ArrayList<String> getTagList() {
		ArrayList<String> tagList = new ArrayList<String>();
		return tagList;
	}

	public void testSuite() throws SuiteException {
		throw new SuiteException();
	}
	
}
