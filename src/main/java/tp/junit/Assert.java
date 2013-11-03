/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * Responsabilidad: Contener los asserts con los que se van a probar
 * los valores y enviar excepciones si alguno fallo.
 */
package tp.junit;

public class Assert {

    public static void assertTrue(boolean valor) throws AssertException {
        if (valor == false) {
            throw new AssertException();
        }
    }

    public static void assertFalse(boolean valor) throws AssertException {
        if (valor == true) {
            throw new AssertException();
        }
    }

    public static void assertEquals(Object object1, Object object2) throws AssertException {
        boolean result = object1.equals(object2);
        if (!result) {
            throw new AssertException();
        }
    }

    public static void fail() throws AssertException {
        throw new AssertException();
    }
}
