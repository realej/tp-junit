package aplicacion;

import tp.junit.*;
import static tp.junit.Assert.*;

public class TestCalculadora extends TestCase {

    public void metodoDePrueba() {
        Calculadora cal = new Calculadora();
        assertTrue(cal.suma(1, 1) == 2);
    }

    @Override
    public void runTest() {
        this.metodoDePrueba();
    }
}
