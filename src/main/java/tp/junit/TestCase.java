/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * Responsabilidad: Se encarga de ejecutar el test y
 * modificar si este fue de resultado positivo o negativo
 * Patrones utilizados: Template Method - runTest()
 *                      Command - run()
 *                       Composite - Hoja
 */
package tp.junit;

public abstract class TestCase extends Test {

    private String testName;
    private boolean run = true;

    public TestCase() {
        testName = this.getClass().getName();
        testName = testName.substring(testName.lastIndexOf(".") + 1);
    }

    @Override
    public String getName() {
        return testName;
    }

    @Override
    public void run(TestResult result) {
        if (run == true) {
            try {
                runTest();
                result.addPassed(testName);
            } catch (AssertException e) {
                result.addFail(testName);

            } catch (Throwable e) {
                result.addError(testName);
            }
        }
    }

    abstract public void runTest();

    @Override
    public String classType() {
        String name = "TestCase";
        return name;
    }
    
    @Override
    public void regularExp(String regex){
        if( !testName.matches(regex) ){
            run =false;
        }
    }
}
