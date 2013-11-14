package aplicacion;

import tp.junit.TestCase;
import static tp.junit.Assert.*;

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
