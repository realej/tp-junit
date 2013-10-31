/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.junit;

public class TestRunner {

    private TestResult result;

    public TestRunner() {
        this.result = new TestResult();
    }

    public void init(TestSuite suite) {
        suite.run(result);
        this.printResults();
    }

    private void printResults() {
       

        System.out.println("Cantidad total de Test: " + result.getTestCount());
        System.out.println("\033[32mCantidad de tests satisfactorios: " + result.getPasses().size());
        System.out.println("\033[31mCantidad de tests fallidos: " + result.getFailures().size());
        Ventana ventana = new Ventana(result.getTestCount(),result.getPasses().size(),result.getFailures().size());
        
        for (TestState state : result.getFailures()) {
            System.out.println("Test Fallido: " + state.getState());
        }
    }
}
