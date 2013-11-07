/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import tp.junit.TestCase;

/**
 *
 * @author Rosso
 */
public class TestError extends TestCase{

    @Override
    public void runTest() {
        throw new Error();
    }
    
}
