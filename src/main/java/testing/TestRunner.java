package testing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;

public class TestRunner {
	ArrayList<RunnableTest> testList;

	
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
				try {
					Test test = runnableTest.getTest();
					test.test();
					}catch(AssertionException exception) {
						//Report.testReport(runnableTest.getTest());
						continue;
					}catch(Throwable error) {
						
						continue;
					}
					//test corrio bien
					//reporte	
			}
		}
	}
	
	public void runSuite(String suiteName) {
		for (RunnableTest runnableTest : testList) {
			if(!runnableTest.isSkipped() && matchesSuiteName(suiteName, runnableTest)) {
				runnableTest.getTest().test();
			}			 	
		}
	}
	
	public void runWithTagList(ArrayList<String> tagList) {
		
		Collections.sort(tagList);
		
		for (RunnableTest runnableTest : testList) {
			ArrayList <String>testTagList = runnableTest.getTagList();
			Collections.sort(testTagList);			
			if(!runnableTest.isSkipped() && tagList.equals(testTagList)) {
				runnableTest.getTest().test();
			}			 	
		}
	}
	
	public void runWithRegularExpression(String regularExpression) {
		Pattern pattern = Pattern.compile(regularExpression);
		for (RunnableTest runnableTest : testList) {
			if(!runnableTest.isSkipped() && pattern.matcher(runnableTest.getTestName()).matches()) {
				runnableTest.getTest().test();
			} 	
		}
	}
	
	public void runMatchingAny(String testNameRegularExpression, String testSuiteRegularExpression, ArrayList<String> tagList) {
		Pattern testNamePattern = Pattern.compile(testNameRegularExpression);
		Pattern testSuitePattern = Pattern.compile(testSuiteRegularExpression);		
		Collections.sort(tagList);
		
		for (RunnableTest runnableTest : testList) {
			boolean testNameMatches = testNamePattern.matcher(runnableTest.getTestName()).matches();
			boolean suiteNameMatches = testSuitePattern.matcher(runnableTest.getSuiteName()).matches();
			ArrayList <String>testTagList = runnableTest.getTagList();
			Collections.sort(testTagList);
			
			if(!runnableTest.isSkipped() && (testNameMatches || suiteNameMatches || testTagList.equals(tagList))) {
				runnableTest.getTest().test();
			}			
		}
	}
	

	public void runMatchingAll(String testNameRegularExpression, String testSuiteRegularExpression, ArrayList<String> tagList) {
		Pattern testNamePattern = Pattern.compile(testNameRegularExpression);
		Pattern testSuitePattern = Pattern.compile(testSuiteRegularExpression);		
		Collections.sort(tagList);
		
		for (RunnableTest runnableTest : testList) {
			boolean testNameMatches = testNamePattern.matcher(runnableTest.getTestName()).matches();
			boolean suiteNameMatches = testSuitePattern.matcher(runnableTest.getSuiteName()).matches();
			ArrayList <String>testTagList = runnableTest.getTagList();
			Collections.sort(testTagList);
			
			if(!runnableTest.isSkipped() && testNameMatches && suiteNameMatches && testTagList.equals(tagList)) {
				runnableTest.getTest().test();
			}			
		}
	}
	
	
	
	public void skip(String testName) {
		for (RunnableTest runnableTest : testList) {
			if(runnableTest.getTestName() == testName) {
				runnableTest.setIsSkipped(true);
			}
		}
	}
	
	public void unskip(String testName) {
		for (RunnableTest runnableTest : testList) {
			if(runnableTest.getTestName() == testName) {
				runnableTest.setIsSkipped(false);
			}
		}
	}	
	
	
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
		
		public ArrayList<String> getTagList() {
			return test.getTagList();
		}
		
		public String getTestName() {
			return test.getName();
		}
		
		public void setIsSkipped(boolean bool) {
			isSkipped = bool;
		}
	}
	
}
