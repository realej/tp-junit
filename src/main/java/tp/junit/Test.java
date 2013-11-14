/*
 * Interfaz del composite - componente.
 */
package tp.junit;

public abstract class Test {

    SetUp setUp = null;

    public void setAttribute(SetUp setup) {
        setUp = setup;
    }

    public SetUp getSetUp() {
        return setUp;
    }

    public abstract void run(TestResult result);

    public abstract String classType();

    public abstract String getName();

    public abstract void regularExp(String regex);

    public abstract void haveTag(String tag);
}
