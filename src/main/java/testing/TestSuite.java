package testing;

import java.util.ArrayList;


public abstract class TestSuite{
	protected String suiteName;
	ArrayList<Test> testList;
	
	
	public String getSuiteName() {
		return suiteName;
	}
	
	public ArrayList<Test> getTestList() {
		return testList;
	}
	
	public ArrayList<String> getTestNameList() {
		ArrayList<String> testNameList = new ArrayList<String>(); 
		for (Test test : testList) {
			testNameList.add(test.getName());
		}
		return testNameList;
	}
}
