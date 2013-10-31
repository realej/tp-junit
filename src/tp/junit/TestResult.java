/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.junit;

/**
 *
 * @author Julian
 */
public class TestResult {

    public enum State {

        PASSED, FAIL, ERROR
    }
    private String mensaje = "";
    private State stt;

    public TestResult() {
    }

    public TestResult(State st, String msg) {
        this.mensaje = msg;
        this.stt = st;
    }

    public void setEstado(State st, String msg) {
        this.mensaje = msg;
        this.stt = st;
    }
}
