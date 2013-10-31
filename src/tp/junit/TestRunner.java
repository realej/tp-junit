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
    }
}
