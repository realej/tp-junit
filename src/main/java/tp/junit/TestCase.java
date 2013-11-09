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
    private String tags;
    private boolean matches = false;

    public TestCase() {
        testName = this.getClass().getName();
        testName = testName.substring(testName.lastIndexOf(".") + 1);
        tags = new String();
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
    public void regularExp(String regex) {
        if (!testName.matches(regex)) {
            run = false;
        }
    }

    public boolean isRunner() {
        return run;
    }

    public void addTag(String tag) {
        tags = tags.concat(tag);
        tags = tags.concat(",");
    }

    @Override
    public void haveTag(String tag) {
        String regex = ".*" + tag + ".*";
        if (matches == false) {
            if (!tags.matches(regex)) {
                run = false;
            }else{
                matches = true;
                run = true;
            }
        }
    }
}
