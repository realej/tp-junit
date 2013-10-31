/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.junit;

public abstract class TestCase extends Assert implements Test {

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
