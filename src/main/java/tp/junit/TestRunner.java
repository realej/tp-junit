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

    private void printResults() {
        Ventana ventana = new Ventana(result.getTestCount(), result.getPasses().size(), result.getFailures().size());

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

        for (TestState state : result.getFailures()) {
            ventana.agregarMetodosErroneos(state.getState());
            System.out.println("Test Fallido: " + state.getState());

        }
        ventana.mostrar();

    }
}
