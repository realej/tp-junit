/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testing;

public abstract class NewTest extends TestDecorador {

    long limitTime = 0;

    private double calculateTime(double initTime, long finalTime) {
        return (finalTime - initTime) / 1000000;
    }

    public NewTest(String testName, long limitTime) {
        super(testName);
        this.limitTime = limitTime;
    }

    @Override
    public void test() throws Throwable {
        long initTime = 0, finalTime = 0;
        try {
            initTime = System.nanoTime();
            runTest();
            finalTime = System.nanoTime();
            if (calculateTime(initTime, finalTime) > limitTime) {
                throw new AssertionException();
            }
        } catch (AssertionException e) {
            if (calculateTime(initTime, finalTime) > limitTime) {
                throw new AssertionException();
            }
        }

    }

    abstract public void runTest() throws Throwable;
}
