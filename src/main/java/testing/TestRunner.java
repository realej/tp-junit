package testing;

import java.util.ArrayList;
import java.util.HashMap;

public class TestRunner {
	ArrayList<RunnableTest> testList;
	
	private class RunnableTest {
		Test test;
		boolean isSkipped;
		
		public RunnableTest(Test test, boolean isSkipped) {
			this.test = test;
			this.isSkipped = isSkipped;			
		}
		
		public boolean isSkipped() {
			return isSkipped;
		}
		
		public Test getTest() {
			return test;
		}
		
		public String getSuiteName() {
			return test.getSuiteName();
		}
	}
	
	public void addTest(Test test, boolean isSkipped) {
		RunnableTest runnableTest = new RunnableTest(test, isSkipped);
		testList.add(runnableTest);
	}
	
	private boolean matchesSuiteName(String suiteName, RunnableTest runnableTest) {
		return suiteName == runnableTest.getSuiteName();
	}
	
	public void run() {
		for (RunnableTest runnableTest : testList) {
			if(!runnableTest.isSkipped()) {
				runnableTest.getTest().test();
			}			 	
		}
	}
	
	public void run(String suiteName) {
		for (RunnableTest runnableTest : testList) {
			if(!runnableTest.isSkipped() && matchesSuiteName(suiteName, runnableTest)) {
				runnableTest.getTest().test();
			}			 	
		}
	}
	
	public void run(ArrayList<String> tagList) {
		
	}
	
	
	public void skip() {
		
	}
	
	public void unskip() {
		
	}
	
}
