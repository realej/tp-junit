package testing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;

public class TestRunner {
	
	ArrayList<TestSuite> testSuiteList;

	
	public void addTestSuite(TestSuite tests) {
		testSuiteList.add(tests);
	}
	
	public void run() {
		for (SuperTest testSuite : testSuiteList) {
			runSuite(testSuite);
		}
	}
	
	public void runSuite(SuperTest testSuite) {
		ArrayList<SuperTest> testList = testSuite.getTestList();	
		for (SuperTest runnableTest : testList) {
				try {
					runnableTest.testSuite(this);
					if(!runnableTest.isSkiped()) {
						runnableTest.test();
					}
					}catch(AssertionException exception) {
						//Reportar failure
						continue;
					}catch(Throwable error) {
						//Reportar error
						continue;
						//Reportar ok
					}
		}
	}
	
	public void runTestOfSuite(String suiteName) {
		for (SuperTest testSuite : testSuiteList) {
			if (suiteName == testSuite.getName()) {
				runSuite(testSuite);
			}
		}
	}
	
	public void runWithTagList(ArrayList<String> tagList) {
		Collections.sort(tagList);
		for (SuperTest testSuite : testSuiteList) {
			runSuiteWithTagList(testSuite,tagList);
		}
	}
	
	public void runSuiteWithTagList(SuperTest testSuite, ArrayList<String> tagList) {
		ArrayList<SuperTest> testList = testSuite.getTestList();
		for (SuperTest runnableTest : testList) {
			ArrayList <String>testTagList = runnableTest.getTagList();
				try {
					runnableTest.testSuiteWithTagList(this, tagList);
					if(!runnableTest.isSkiped() && tagList.equals(testTagList)) {
						runnableTest.test();
					}
					}catch(AssertionException exception) {
						//Reportar failure
						continue;
					}catch(Throwable error) {
						//Reportar error
						continue;
						//Reportar ok
					}
		}		
	}
	
	public void runWithRegularExpression(String regularExpression) {
		for (SuperTest testSuite : testSuiteList) {
			runSuiteWithRegularExpression(testSuite, regularExpression);
		}
	}
	
	public void runSuiteWithRegularExpression(SuperTest testSuite, String regularExpression) {
		ArrayList<SuperTest> testList = testSuite.getTestList();
		Pattern pattern = Pattern.compile(regularExpression);
		for (SuperTest runnableTest : testList) {
				try {
					runnableTest.testSuiteWithRegularExpression(this, regularExpression);
					if(!runnableTest.isSkiped() && pattern.matcher(runnableTest.getName()).matches()) {
						runnableTest.test();
					}
					}catch(AssertionException exception) {
						//Reportar failure
						continue;
					}catch(Throwable error) {
						//Reportar error
						continue;
						//Reportar ok
					}
		}
	}
	
	public void runMatchingAny(String testNameRegularExpression, String testSuiteRegularExpression, ArrayList<String> tagList) {
		for (SuperTest testSuite : testSuiteList) {
			runSuiteMatchingAny(testSuite,testNameRegularExpression, testSuiteRegularExpression, tagList);
		}
	}
	
	public void runSuiteMatchingAny(SuperTest testSuite, String testNameRegularExpression, String testSuiteRegularExpression, ArrayList<String> tagList) {
		ArrayList<SuperTest> testList = testSuite.getTestList();
		Pattern testNamePattern = Pattern.compile(testNameRegularExpression);
		Pattern testSuitePattern = Pattern.compile(testSuiteRegularExpression);		
		Collections.sort(tagList);
		for (SuperTest runnableTest : testList) {
				try {
					runnableTest.testSuiteMatchingAny(this, testNameRegularExpression, testSuiteRegularExpression, tagList);
					boolean testNameMatches = testNamePattern.matcher(runnableTest.getName()).matches();
					boolean suiteNameMatches = testSuitePattern.matcher(runnableTest.getName()).matches();
					ArrayList <String>testTagList = runnableTest.getTagList();
					if(!runnableTest.isSkiped() && (testNameMatches || suiteNameMatches || testTagList.equals(tagList))) {
						runnableTest.test();
					}
					}catch(AssertionException exception) {
						//Reportar failure
						continue;
					}catch(Throwable error) {
						//Reportar error
						continue;
						//Reportar ok
					}
		}
	}
	
	public void runMatchingAll(String testNameRegularExpression, String testSuiteRegularExpression, ArrayList<String> tagList) {
		for (SuperTest testSuite : testSuiteList) {
			runSuiteMatchingAny(testSuite,testNameRegularExpression, testSuiteRegularExpression, tagList);
		}
	}
	
	public void runSuiteMatchingAll(SuperTest testSuite, String testNameRegularExpression, String testSuiteRegularExpression, ArrayList<String> tagList) {
		ArrayList<SuperTest> testList = testSuite.getTestList();
		Pattern testNamePattern = Pattern.compile(testNameRegularExpression);
		Pattern testSuitePattern = Pattern.compile(testSuiteRegularExpression);		
		Collections.sort(tagList);
		for (SuperTest runnableTest : testList) {
				try {
					runnableTest.testSuiteMatchingAny(this, testNameRegularExpression, testSuiteRegularExpression, tagList);
					boolean testNameMatches = testNamePattern.matcher(runnableTest.getName()).matches();
					boolean suiteNameMatches = testSuitePattern.matcher(runnableTest.getName()).matches();
					ArrayList <String>testTagList = runnableTest.getTagList();
					if(!runnableTest.isSkiped() && testNameMatches && suiteNameMatches && testTagList.equals(tagList)) {
						runnableTest.test();
					}
					}catch(AssertionException exception) {
						//Reportar failure
						continue;
					}catch(Throwable error) {
						//Reportar error
						continue;
						//Reportar ok
					}
		}
	}
	
}	
