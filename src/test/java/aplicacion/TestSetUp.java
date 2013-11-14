package aplicacion;

import tp.junit.SetUp;

public class TestSetUp extends SetUp {
    Calculadora calc = new Calculadora();
    
    @Override
    public void addAttributes() {
        addAttribute(calc);
    }
}
