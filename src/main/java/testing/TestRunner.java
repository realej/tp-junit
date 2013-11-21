package testing;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;

public class TestRunner {

    ArrayList<TestSuite> testSuiteList;
    Store store;
    public TestRunner() throws FileNotFoundException {
        this.testSuiteList = new ArrayList<TestSuite>();
        Report.createReport("Report.txt");
       store = new Store();
    }

    public void addTestSuite(TestSuite tests) {
        testSuiteList.add(tests);
    }

    public void run() throws IOException {
        for (TestSuite testSuite : testSuiteList) {
            Report.suiteHeaderReport(testSuite);
            //agregue
            Report.suiteFileHeaderReport(testSuite);
            runSuite(testSuite);
            //agregue
            Report.suiteFileFooterReport(testSuite);
            Report.suiteFooterReport(testSuite);
        }
        Report.clear();
    }

    public void runTestOfSuiteStore(String suiteName) throws IOException {
        
        for (SuperTest testSuite : testSuiteList) {
            if (suiteName.equals(testSuite.getName())) {
                Report.suiteHeaderReport(testSuite);
                //agregue
                Report.suiteFileHeaderReport(testSuite);
                testSuite.isStoreTest();
                store.deleteStore();
                runSuite(testSuite);
                //agregue
                Report.suiteFileFooterReport(testSuite);
                Report.suiteFooterReport(testSuite);
            }
        }
        Report.clear();
    }

    public void runTestOfSuite(String suiteName) throws IOException {
        for (SuperTest testSuite : testSuiteList) {
            if (suiteName.equals(testSuite.getName())) {
                Report.suiteHeaderReport(testSuite);
                //agregue
                Report.suiteFileHeaderReport(testSuite);
                runSuite(testSuite);
                //agregue
                Report.suiteFileFooterReport(testSuite);
                Report.suiteFooterReport(testSuite);
            }
        }
        Report.clear();
    }

    public void runSuite(SuperTest testSuite) {
        ArrayList<SuperTest> testList = testSuite.getTestList();
        for (SuperTest runnableTest : testList) {
            String result;
            try {
                runnableTest.testSuite();
                if (!runnableTest.isSkiped()) {
                    runnableTest.test();
                    result = "ok";
                    Report.testReport(runnableTest, result);
                    //agregue
                    Report.testFileReport(runnableTest, result);
                } else {
                    //Not run
                }
            } catch (AssertionException exception) {
                result = "failure";
                Report.testReport(runnableTest, result);
                //agregue
                Report.testFileReport(runnableTest, result);
                continue;
            } catch (SuiteException e) {
                Report.suiteHeaderReport(runnableTest);
                runSuite(runnableTest);
            } catch (Throwable error) {
                result = "error";
                //agregue
                Report.testFileReport(runnableTest, result);
            }
            //result = "ok";
            //Report.testReport(runnableTest, result);
            //agregue
            //Report.testFileReport(runnableTest, result);
        }
    }

    public void runWithTagList(ArrayList<String> tagList) {
        Collections.sort(tagList);
        for (SuperTest testSuite : testSuiteList) {
            Report.suiteHeaderReport(testSuite);
            runSuiteWithTagList(testSuite, tagList);
            Report.suiteFooterReport(testSuite);
        }
    }

    public void runSuiteWithTagList(SuperTest testSuite, ArrayList<String> tagList) {
        ArrayList<SuperTest> testList = testSuite.getTestList();
        for (SuperTest runnableTest : testList) {
            String result;
            ArrayList<String> testTagList = runnableTest.getTagList();
            try {
                runnableTest.testSuite();
                if (!runnableTest.isSkiped() && tagList.equals(testTagList)) {
                    runnableTest.test();
                }
            } catch (AssertionException exception) {
                result = "failure";
                Report.testReport(runnableTest, result);
                continue;
            } catch (SuiteException e) {
                Report.suiteHeaderReport(runnableTest);
                runSuiteWithTagList(runnableTest, tagList);
            } catch (Throwable error) {
                result = "error";
            }
            result = "ok";
            Report.testReport(runnableTest, result);
        }
    }

    public void runWithRegularExpression(String regularExpression) {
        for (SuperTest testSuite : testSuiteList) {
            Report.suiteHeaderReport(testSuite);
            runSuiteWithRegularExpression(testSuite, regularExpression);
            Report.suiteFooterReport(testSuite);
        }
    }

    public void runSuiteWithRegularExpression(SuperTest testSuite, String regularExpression) {
        ArrayList<SuperTest> testList = testSuite.getTestList();
        Pattern pattern = Pattern.compile(regularExpression);
        for (SuperTest runnableTest : testList) {
            String result;
            try {
                runnableTest.testSuite();
                if (!runnableTest.isSkiped() && pattern.matcher(runnableTest.getName()).matches()) {
                    runnableTest.test();
                }
            } catch (AssertionException exception) {
                result = "failure";
                Report.testReport(runnableTest, result);
                continue;
            } catch (SuiteException e) {
                Report.suiteHeaderReport(runnableTest);
                runSuiteWithRegularExpression(runnableTest, regularExpression);
            } catch (Throwable error) {
                result = "error";
            }
            result = "ok";
            Report.testReport(runnableTest, result);
        }
    }

    public void runMatchingAny(String testNameRegularExpression, String testSuiteRegularExpression, ArrayList<String> tagList) {
        for (SuperTest testSuite : testSuiteList) {
            Report.suiteHeaderReport(testSuite);
            runSuiteMatchingAny(testSuite, testNameRegularExpression, testSuiteRegularExpression, tagList);
            Report.suiteFooterReport(testSuite);
        }
    }

    public void runSuiteMatchingAny(SuperTest testSuite, String testNameRegularExpression, String testSuiteRegularExpression, ArrayList<String> tagList) {

        ArrayList<SuperTest> testList = testSuite.getTestList();
        Pattern testNamePattern = Pattern.compile(testNameRegularExpression);
        Pattern testSuitePattern = Pattern.compile(testSuiteRegularExpression);
        Collections.sort(tagList);

        for (SuperTest runnableTest : testList) {
            String result;
            try {

                runnableTest.testSuite();
                boolean testNameMatches = testNamePattern.matcher(runnableTest.getName()).matches();
                boolean suiteNameMatches = testSuitePattern.matcher(runnableTest.getName()).matches();
                ArrayList<String> testTagList = runnableTest.getTagList();

                if (!runnableTest.isSkiped() && (testNameMatches || suiteNameMatches || testTagList.equals(tagList))) {
                    runnableTest.test();
                }
            } catch (AssertionException exception) {
                result = "failure";
                Report.testReport(runnableTest, result);
                continue;
            } catch (SuiteException e) {
                Report.suiteHeaderReport(runnableTest);
                runSuiteMatchingAny(runnableTest, testNameRegularExpression, testSuiteRegularExpression, tagList);
            } catch (Throwable error) {
                result = "error";
            }
            result = "ok";
            Report.testReport(runnableTest, result);
        }
    }

    public void runMatchingAll(String testNameRegularExpression, String testSuiteRegularExpression, ArrayList<String> tagList) {
        for (SuperTest testSuite : testSuiteList) {
            Report.suiteHeaderReport(testSuite);
            runSuiteMatchingAny(testSuite, testNameRegularExpression, testSuiteRegularExpression, tagList);
            Report.suiteFooterReport(testSuite);
        }
    }

    public void runSuiteMatchingAll(SuperTest testSuite, String testNameRegularExpression, String testSuiteRegularExpression, ArrayList<String> tagList) {

        ArrayList<SuperTest> testList = testSuite.getTestList();
        Pattern testNamePattern = Pattern.compile(testNameRegularExpression);
        Pattern testSuitePattern = Pattern.compile(testSuiteRegularExpression);
        Collections.sort(tagList);

        for (SuperTest runnableTest : testList) {
            String result;
            try {

                runnableTest.testSuite();
                boolean testNameMatches = testNamePattern.matcher(runnableTest.getName()).matches();
                boolean suiteNameMatches = testSuitePattern.matcher(runnableTest.getName()).matches();
                ArrayList<String> testTagList = runnableTest.getTagList();

                if (!runnableTest.isSkiped() && (testNameMatches && suiteNameMatches && testTagList.equals(tagList))) {
                    runnableTest.test();
                }
            } catch (AssertionException exception) {
                result = "failure";
                Report.testReport(runnableTest, result);
                continue;
            } catch (SuiteException e) {
                Report.suiteHeaderReport(runnableTest);
                runSuiteMatchingAll(runnableTest, testNameRegularExpression, testSuiteRegularExpression, tagList);
            } catch (Throwable error) {
                result = "error";
            }
            result = "ok";
            Report.testReport(runnableTest, result);
        }
    }
}
