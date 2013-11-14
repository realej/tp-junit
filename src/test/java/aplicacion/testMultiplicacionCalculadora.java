/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import tp.junit.*;
import static tp.junit.Assert.assertTrue;

public class testMultiplicacionCalculadora extends TestCase {

    public void metodoPruebaConSetUp() {
        Calculadora calc = (Calculadora) getSetUp().ObtenerAtributo(0);
        assertTrue(calc.resta(1, 1) == 0);
    }

    @Override
    public void runTest() {
        metodoPruebaConSetUp();
    }
}
