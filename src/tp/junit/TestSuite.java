/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.junit;

import java.util.ArrayList;

public class TestSuite implements Test {

    private ArrayList<Test> tests = new ArrayList<>();

    @Override
    public void run(TestResult result) {
        for (Test test : tests) {
            test.run(result);
        }
    }

    public void addTest(Test test) {
        tests.add(test);
    }
}
