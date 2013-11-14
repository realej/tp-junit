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

import java.util.ArrayList;

/**
 *
 * @author Julian
 */
public class TestResult {

    private ArrayList<TestState> failures;
    private ArrayList<TestState> passes;
    private ArrayList<TestState> error;
    private String suiteName = "";
    private int tCount;

    public TestResult() {
        this.passes = new ArrayList<TestState>();
        this.failures = new ArrayList<TestState>();
        this.error = new ArrayList<TestState>();
        tCount = 0;
    }

    public void addSuiteName(String name){
        if ("".equals(this.suiteName)) { 
            this.suiteName = name;
        }
        else {
            this.suiteName += ("."+name);
        }
    }
    
    public void addFail(String msg, double time) {  
      //  String tiempo = " : ( " + Double.toString(time) + "s )";
     //   msg += tiempo;
        this.failures.add(new TestState(suiteName + "." + msg, TestState.State.FAIL,time));
        this.tCount++;
    }

    public void addPassed(String msg, double time) {
      // String tiempo = " : ( " + Double.toString(time) + "s )";
       // msg += tiempo;
        this.passes.add(new TestState(suiteName + "." + msg, TestState.State.PASSED,time));
        this.tCount++;
    }

    public void addError(String msg, double time) {
     //  String tiempo = " : ( " + Double.toString(time) + "s )";
      //  msg += tiempo;
        this.error.add(new TestState(suiteName + "." + msg, TestState.State.ERROR,time));
        this.tCount++;
    }

    public ArrayList<TestState> getFailures() {
        return this.failures;
    }

    public ArrayList<TestState> getPasses() {
        return this.passes;
    }

    public ArrayList<TestState> getError() {
        return this.error;
    }

    public int getTestCount() {
        return this.tCount;
    }
}
