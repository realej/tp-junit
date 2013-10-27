/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.junit;

import java.util.ArrayList;

public class TestSuite implements Test {
    private ArrayList<Test> tests = new ArrayList<Test>();
    
    @Override
    public void run(){
        for(Test test: tests){
            test.run();
        }       
    }
    
    public void addTest(Test test){ 
        tests.add(test);
    }
    
}
