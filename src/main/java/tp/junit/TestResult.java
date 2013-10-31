/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.junit;

import java.util.ArrayList;

/**
 *
 * @author Julian
 */
public class TestResult {

    private ArrayList<TestState> failures;
    private ArrayList<TestState> passes;
    private int tCount;

    public TestResult() {
        this.passes = new ArrayList<TestState>();
        this.failures = new ArrayList<TestState>();
        tCount = 0;
    }

    public void addFail(String msg) {
        this.failures.add(new TestState(msg, TestState.State.FAIL));
        this.tCount++;
    }

    public void addPassed(String msg) {
        this.passes.add(new TestState(msg, TestState.State.PASSED));
        this.tCount++;
    }

    public ArrayList<TestState> getFailures() {
        return this.failures;
    }

    public ArrayList<TestState> getPasses() {
        return this.passes;
    }
    
    public int getTestCount() {
        return this.tCount;
    }
}
