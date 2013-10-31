package francisco;
import java.lang.String;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println("SUnit 1.0 realizando tests...");
        
        /*Cree la clase de Test que implemento y luego corralos con el metodo run(), que ya 
         * especifico en la clase de prueba*/

		TestAsserts pruebas = new TestAsserts();
		pruebas.run();
		System.out.println("SUnit 1.0 finalizo los tests");
    }    
	
}	
