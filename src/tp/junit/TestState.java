/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.junit;

/**
 *
 * @author Julian
 */
public class TestState {

    public enum State {

        PASSED, FAIL, ERROR
    }
    private String mensage = "";
    private State stt;
    
    public TestState(String msg, State st) {
        this.mensage = msg;
        this.stt = st;
    }
}
