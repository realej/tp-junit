/*
 * Responsabilidad: Se encarga de ejecutar las plantillas y
 * de agregar más test a un grupo de test.
 * Patrones Utilizados: Composite - Compuesto
 */
package tp.junit;

import java.util.ArrayList;

public class TestSuite extends Test {

    private ArrayList<Test> tests = new ArrayList<Test>();
    private String suiteName;

    public TestSuite(String name) {
        suiteName = name;
    }

    @Override
    public String getName() {
        return this.suiteName;
    }

    @Override
    public void run(TestResult result) {
        result.addSuiteName(this.suiteName);

        for (Test test : tests) {

            if (!test.classType().equals("TestSuite")) {
                test.setAttribute(setUp);
            }
            test.run(result);
            if (setUp != null) {
                setUp.tearDown();
            }
        }
    }

    public void addTest(Test test) {
        if (this.getName().equals(test.getName()) && "TestSuite".equals(test.classType())) {
            throw new Error("Existe una suite con el mismo nombre");
        }
        for (Test ts : tests) {
            if (ts.getName().equals(test.getName())) {
                throw new Error("Existe un test con el mismo nombre");
            }
        }
        tests.add(test);
    }

    public void addSetUp(SetUp setup) {
        setUp = setup;
    }

    @Override
    public String classType() {
        String name = "TestSuite";
        return name;
    }

    @Override
    public void regularExp(String regex) {
        for (Test test : tests) {
            test.regularExp(regex);
        }
    }

    @Override
    public void haveTag(String tag) {
        for (Test test : tests) {
            test.haveTag(tag);
        }
    }
}
