/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import static tp.junit.Assert.assertTrue;
import tp.junit.TestCase;

/**
 *
 * @author Administrador
 */
public class testSumaCalculadoraConSetUp extends TestCase {

    public void metodoPruebaConSetUp() {
        Calculadora calc = (Calculadora) getSetUp().ObtenerAtributo(0);
        assertTrue(calc.suma(1, 1) == 2);
    }

    @Override
    public void runTest() {
        metodoPruebaConSetUp();
    }
}
