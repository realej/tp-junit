/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * Responsabilidad: Se encarga de gestionar los resultados de los test,
 * llevando una lista para los que fallaron y
 * otra para los que pasaron satisfactoriamente.
 */
package tp.junit;

public class TestRunner {

    private TestResult result;

    public TestRunner() {
    }

    public void init(TestSuite suite) {
        this.result = new TestResult();
        suite.run(result);
        this.printResults();
    }
    public void init(TestSuite suite,String regex){
        this.result = new TestResult();
        suite.regularExp(regex);
        suite.run(result);
        this.printResults();
    }

    private void printResultTestCase(TestState state) {
        StringBuilder resultTestCase = new StringBuilder();
        resultTestCase.append(state.getSuiteNameTestCase());
        resultTestCase.append(System.getProperty("line.separator"));
        resultTestCase.append("---------------------");
        resultTestCase.append(System.getProperty("line.separator"));
        resultTestCase.append(state.getResultTestCase()).append(" ").append(state.getTestCaseName());
        resultTestCase.append(System.getProperty("line.separator"));
        System.out.println(resultTestCase.toString());
    }

    private void printSummary(TestResult result) {
        StringBuilder titleSummary = new StringBuilder();
        if (!result.getFailures().isEmpty()) {
            titleSummary.append("[failure] Summary");
        } else {
            titleSummary.append("[success] Summary");
        }

        titleSummary.append(System.getProperty("line.separator"));
        titleSummary.append("=====================");

        System.out.println(titleSummary.toString());
        System.out.println("Run: " + result.getTestCount());
        System.out.println("Errors: " + result.getError().size());
        System.out.println("Failures: " + result.getFailures().size());
    }

    private void printResults() {
        Ventana ventana = new Ventana(result.getTestCount(), result.getPasses().size(), result.getFailures().size());

        for (TestState state : result.getFailures()) {
            printResultTestCase(state);
            ventana.agregarMetodosErroneos(state.getState());
        }

        for (TestState state : result.getPasses()) {
            printResultTestCase(state);
        }

        for (TestState state : result.getError()) {
            printResultTestCase(state);
         }
        
        printSummary(result);

        ventana.mostrar();

    }
}
