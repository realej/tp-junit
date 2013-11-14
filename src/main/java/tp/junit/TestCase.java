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

    private double calcularTiempo(double tiempoInicial, double tiempoFinal) {
        return (tiempoFinal-tiempoInicial)/1000000; 
    }

    @Override
    public String getName() {
        return testName;
    }

    @Override
    public void run(TestResult result) {
        long tiempoInicial = 0, tiempoFinal = 0;
        if (run == true) {
            try {
                tiempoInicial = System.nanoTime();
                runTest();
                tiempoFinal = System.nanoTime();
                result.addPassed(testName, calcularTiempo(tiempoInicial, tiempoFinal));
            } catch (AssertException e) {
                tiempoFinal = System.nanoTime();
                result.addFail(testName, calcularTiempo(tiempoInicial, tiempoFinal));
            } catch (Throwable e) {
                tiempoFinal = System.nanoTime();
                result.addError(testName, calcularTiempo(tiempoInicial, tiempoFinal));
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
        if (matches == false) {
            if (!testName.matches(regex)) {
                run = false;
            } else {
                matches = true;
                run = true;
            }
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
            } else {
                matches = true;
                run = true;
            }
        }
    }
}
