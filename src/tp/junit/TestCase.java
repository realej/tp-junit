/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.junit;

public class TestCase implements Test {

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

    public void runTest() {
        //tenes que redifinirlo en el usuario
    }
}
