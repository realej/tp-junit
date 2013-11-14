package aplicacion;

import tp.junit.*;
import static tp.junit.Assert.*;

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
