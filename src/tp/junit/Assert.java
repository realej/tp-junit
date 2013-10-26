/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.junit;

/**
 *
 * @author Rosso
 * prueba julian Commit
 */
public class Assert {

    public static void assertTrue(boolean valor) throws Error {
        if (valor == false) {
            throw new Error();
        }
    }

    public static void assertFalse(boolean valor) throws Error {
        if (valor == true) {
            throw new Error();
        }
    }

    public static void assertEquals(Object object1, Object object2) throws Error {
        boolean result = object1.equals(object2);
        if (!result) {
            throw new Error();
        }
    }
}
