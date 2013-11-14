/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import tp.junit.SetUp;

public class TestSetUp2 extends SetUp {

    Calculadora calc = new Calculadora();

    @Override
    public void addAttributes() {
        addAttribute(calc);
    }
}
