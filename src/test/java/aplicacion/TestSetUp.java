/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import tp.junit.SetUp;

/**
 *
 * @author Administrador
 */
public class TestSetUp extends SetUp {

    @Override
    public void agregarAtributos() {
        Calculadora calc = new Calculadora();
        agregarAtributo(calc);        
    }
    
    
}
