package testing;

import java.util.ArrayList;
import java.util.Collections;

public abstract class Test extends SuperTest{
	
	protected ArrayList<String> tagList;
	protected boolean isSkiped;
	protected SuperTest suite;
	
	
	public Test(String testName) {
		super(testName);
		this.tagList = new ArrayList<String>();
		isSkiped = false;
	}
	
	public abstract void test() throws Throwable;
	
	public void testSuite() {
		
	}
	
	public ArrayList<SuperTest> getTestList() {
		return null;
	}
	
	public ArrayList<String> getTagList() {
		Collections.sort(tagList);	
		return tagList;
	}
	
	public void setTag(String tag) {
		tagList.add(tag);
	}
	
	public void setSuite(SuperTest suite) {
		this.suite = suite; 
	}
	
	
        @Override
	public String getName() {
		return name;
	}
	
	public boolean isSkiped() {
		return isSkiped;
	}
	
	public void skip() {
		isSkiped = true;
	}
	
	public void unSkip() {
		isSkiped = false;
	}
        public void isStoreTest(){
            Store store = new Store();
            if(!store.isStoreTest(name)){
                System.out.println("Lo marco" + name);
                skip();
            }
        }
	
}
