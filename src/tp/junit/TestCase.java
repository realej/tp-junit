/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.junit;

public class TestCase implements Test {

    @Override
    public void run() {
        try {
            runTest();
        } catch (Error e) {
            StackTraceElement[] f = e.getStackTrace();
            System.out.println(f[1].getMethodName());
        }
    }

    public void runTest() {
        //tenes que redifinirlo en el usuario
    }
}
