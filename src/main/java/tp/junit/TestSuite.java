/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * Responsabilidad: Se encarga de ejecutar las plantillas y
 * de agregar más test a un grupo de test.
 * Patrones Utilizados: Composite - Compuesto
 */
package tp.junit;

import java.util.ArrayList;

public class TestSuite implements Test {

    private ArrayList<Test> tests = new ArrayList<Test>();
    private SetUp setUp;
    
    @Override
    public void run(TestResult result) {
        for (Test test : tests) {
            test.run(result);
        }
    }

    public void addTest(Test test) {
        tests.add(test);
    }
    
    public void addSetUp(SetUp setup){
       setUp = setup;
    }
    
}
