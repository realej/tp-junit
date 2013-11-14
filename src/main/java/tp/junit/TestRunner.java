/*
 * Responsabilidad: Se encarga de gestionar los resultados de los test,
 * llevando una lista para los que fallaron y
 * otra para los que pasaron satisfactoriamente.
 */
package tp.junit;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class TestRunner {

    private TestResult result;
    private File resultTxt;

    public TestRunner() {
        resultTxt = new File("resultTest.txt");
    }

    public void run(TestSuite suite) throws IOException {
        this.result = new TestResult();
        suite.run(result);
        this.printResults();
    }

    public void runWithRegex(TestSuite suite, String regex) throws IOException {
        this.result = new TestResult();
        suite.regularExp(regex);
        suite.run(result);
        this.printResults();
    }

    public void runWithTag(TestSuite suite, String tag) throws IOException {
        this.result = new TestResult();
        searchTag(suite, tag);
        suite.run(result);
        this.printResults();
    }

    public void runWithTagAndRegex(TestSuite suite, String tag, String regex) throws IOException {
        this.result = new TestResult();
        searchTag(suite, tag);
        suite.regularExp(regex);
        suite.run(result);
        this.printResults();
    }

    private void searchTag(TestSuite suite, String tag) throws IOException {
        StringTokenizer tk = new StringTokenizer(tag, ",");
        while (tk.hasMoreTokens()) {
            suite.haveTag(tk.nextToken());
        }
    }

    private void printSummary(TestResult result, PrintWriter pw) throws IOException {
        StringBuilder summary = new StringBuilder();
        if (!result.getFailures().isEmpty()) {
            summary.append("[failure] Summary");
        } else {
            summary.append("[success] Summary");
        }

        summary.append(System.getProperty("line.separator"));
        summary.append("=====================");
        summary.append(System.getProperty("line.separator"));
        summary.append("Run: " + result.getTestCount());
        summary.append(System.getProperty("line.separator"));
        summary.append("Errors: " + result.getError().size());
        summary.append(System.getProperty("line.separator"));
        summary.append("Failures: " + result.getFailures().size());
        summary.append(System.getProperty("line.separator"));
        summary.append("Skipped: " + result.getSkipped().size());
        summary.append(System.getProperty("line.separator"));
        System.out.println(summary.toString());
        pw.append(summary.toString());
    }

    private ArrayList<String> getSuitesNames() {
        ArrayList<String> listSuitesNames = new ArrayList<String>();
        for (TestState state : result.getPasses()) {
            if (!listSuitesNames.contains(state.getSuiteNameTestCase())) {
                listSuitesNames.add(state.getSuiteNameTestCase());
            }
        }
        for (TestState state : result.getFailures()) {
            if (!listSuitesNames.contains(state.getSuiteNameTestCase())) {
                listSuitesNames.add(state.getSuiteNameTestCase());
            }
        }
        for (TestState state : result.getError()) {
            if (!listSuitesNames.contains(state.getSuiteNameTestCase())) {
                listSuitesNames.add(state.getSuiteNameTestCase());
            }
        }
        return listSuitesNames;
    }

    private void printResultSuite(String suiteName, PrintWriter pw) throws IOException {
        StringBuilder resultTestCase = new StringBuilder();
        resultTestCase.append(suiteName);
        resultTestCase.append(System.getProperty("line.separator"));
        resultTestCase.append("---------------------");
        resultTestCase.append(System.getProperty("line.separator"));
        for (TestState state : result.getPasses()) {
            if (state.getSuiteNameTestCase().equals(suiteName)) {
                resultTestCase.append(state.getResultTestCase()).append(" ").append(state.getTestCaseName());
                resultTestCase.append(System.getProperty("line.separator"));
            }
        }
        for (TestState state : result.getFailures()) {
            if (state.getSuiteNameTestCase().equals(suiteName)) {
                resultTestCase.append(state.getResultTestCase()).append(" ").append(state.getTestCaseName());
                resultTestCase.append(System.getProperty("line.separator"));
            }
        }
        for (TestState state : result.getError()) {
            if (state.getSuiteNameTestCase().equals(suiteName)) {
                resultTestCase.append(state.getResultTestCase()).append(" ").append(state.getTestCaseName());
                resultTestCase.append(System.getProperty("line.separator"));
            }
        }
        resultTestCase.append(System.getProperty("line.separator"));
        System.out.println(resultTestCase.toString());
        pw.append(resultTestCase.toString());
    }

    private void printResults() throws IOException {
        XMLCreator xml = new XMLCreator();
        FileWriter fileTxt = new FileWriter(resultTxt);
        BufferedWriter bw = new BufferedWriter(fileTxt);
        PrintWriter pw = new PrintWriter(bw);
        ArrayList<String> listSuites = getSuitesNames();

        for (String suite : listSuites) {
            printResultSuite(suite, pw);
            xml.agregarSuite(suite, result);
        }

        printSummary(result, pw);

        pw.close();
        bw.close();
        xml.guardar("Resultado");
    }
}
