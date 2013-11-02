/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * Responsabilidad: Se encarga de ejecutar el test y
 * modificar si este fue de resultado positivo o negativo
 * Patrones utilizados: Template Method - runTest()
 *                      Command - run()
 *                       Composite - Hoja
 */
package tp.junit;

public abstract class TestCase  extends Test {
    
    @Override
    public void run(TestResult result) {
        try {
            runTest();
            result.addPassed("");
        } catch (Error e) {
            StackTraceElement[] f = e.getStackTrace();
            result.addFail(f[1].getClassName());

        }
    }
  
    abstract public void runTest();
}
