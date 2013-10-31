/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import tp.junit.*;


public class TestRestaCalculadora extends TestCase {

    public void metodoDePrueba2() {
        Calculadora cal = new Calculadora();
        assertTrue(cal.resta(1, 1) == 1);
    }

    @Override
    public void runTest() {
        this.metodoDePrueba2();
    }
}
   
