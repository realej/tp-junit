package aplicacion;
import tp.junit.Assert;
import static tp.junit.Assert.*;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
 /*
 * @author Julian
 */
public class TestCalculadora {

    public static void main(String[] args) {
        Calculadora cal = new Calculadora();
       try { 
        assertTrue(cal.suma(1, 1) == 3);
       }
       catch (Error e) {
           System.out.println("Prueba negativa, funciona el assertTrue");
       }

    }
}
