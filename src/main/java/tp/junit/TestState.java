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

        PASSED, FAIL, ERROR
    }
    private String mensage = "";
    private State stt;

    public TestState(String msg, State st) {
        this.mensage = msg;
        this.stt = st;
    }

    public String getState() {
        return this.mensage;
    }
}
