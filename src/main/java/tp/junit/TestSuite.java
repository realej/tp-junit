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

public class TestSuite extends Test {
    
    private ArrayList<Test> tests = new ArrayList<Test>();
    private SetUp setUp = null;
    
    @Override
    public void run(TestResult result) {
        
        for (Test test : tests) {
            //Aca falta comparar si es un suite o no
            if (!test.className().equals("TestSuite")) {
                test.setAtributos(setUp);
            }
            test.run(result);
            if (setUp != null) {
                setUp.tearDown();
            }
        }
    }
    
    public void addTest(Test test) {
        tests.add(test);
    }
    
    public void addSetUp(SetUp setup) {
        setUp = setup;
    }
    
    @Override
    public String className() {
        String name = "TestSuite";
        return name;
    }
}
