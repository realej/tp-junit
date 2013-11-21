package testing;

public abstract class TestDecorador extends Test {
    
    public TestDecorador(String testName) {
		super(testName);
	}
    
    
    @Override
    public abstract void test() throws Throwable;
}

