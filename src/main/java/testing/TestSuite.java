package testing;

import java.util.ArrayList;

public abstract class TestSuite{
	protected String suiteName;
	ArrayList<String> testNameList;
	
	
	public String getSuiteName() {
		return suiteName;
	}
	
	public ArrayList<String> getTestNameList() {
		return testNameList;
	}
}
