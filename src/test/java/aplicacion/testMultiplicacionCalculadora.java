package aplicacion;

import tp.junit.*;
import static tp.junit.Assert.assertTrue;

public class testMultiplicacionCalculadora extends TestCase {

    public void metodoPruebaConSetUp() {
        Calculadora calc = (Calculadora) getSetUp().getAttribute(0);
        assertTrue(calc.multiplica(2, 2) == 4);
    }

    @Override
    public void runTest() {
        metodoPruebaConSetUp();
    }
}
