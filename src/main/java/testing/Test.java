package testing;

import java.util.ArrayList;

public abstract class Test {
	protected String name;
	protected TestSuite testSuite;
	protected ArrayList<String> tagList;
	
	
	public abstract void test();
	
	public String getSuiteName() {
		return testSuite.getSuiteName();
	}
	
	public ArrayList<String> getTagList() {
		return tagList;
	}
	
	public String getName() {
		return name;
	}
}
