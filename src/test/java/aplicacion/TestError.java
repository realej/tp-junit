package aplicacion;

import tp.junit.TestCase;

public class TestError extends TestCase{

    @Override
    public void runTest() {
        throw new Error();
    }
    
}
