/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * Responsabilidad: Encapsular los estados posibles de un test.
 */
package tp.junit;

/**
 *
 * @author Julian
 */
public class TestState {

    public enum State {

        PASSED, FAIL, ERROR, SKIPPED
    }
    private String mensage = "";
    private State stt;
    private double time;
    public TestState(String msg, State st, double tiempo) {
        this.mensage = msg;
        this.stt = st;
        this.time = tiempo;
    }

    public String getState() {
        return this.mensage;
    }
    
    public String getResultTestCase() {
        return "["+stt.toString()+"]"+" : (" + Double.toString(time) + "seg) ;";
    }
    
    public String getSuiteNameTestCase() {
        return mensage.substring(0,mensage.lastIndexOf("."));
    }
    
    public String getTestCaseName() {
        return mensage.substring(mensage.lastIndexOf(".")+1); 
    }
    
    public String getTime(){
        return Double.toString(time);
    }
}
