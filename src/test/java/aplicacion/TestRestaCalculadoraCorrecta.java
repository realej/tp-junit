/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import tp.junit.TestCase;

/**
 *
 * @author Rosso
 */
public class TestRestaCalculadoraCorrecta extends TestCase {

    public void metodoDePrueba2() {
        Calculadora cal = new Calculadora();
        assertTrue(cal.resta(1, 1) == 0);
    }

    @Override
    public void runTest() {
        this.metodoDePrueba2();
    }
}
