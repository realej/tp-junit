package com.mycompany.junit;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import aplicacion.TestCalculadora;
import aplicacion.TestRestaCalculadora;
import aplicacion.TestRestaCalculadoraCorrecta;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tp.junit.TestResult;
import tp.junit.TestSuite;

/**
 *
 * @author Carlos
 */
public class TestTp {
    
    public TestTp() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testSuiteRunFalla() {
        TestResult result = new TestResult();
        TestSuite suite = new TestSuite();
        TestRestaCalculadora tRestaCalc = new TestRestaCalculadora();
        suite.addTest(tRestaCalc);
        suite.run(result);
        assertEquals(result.getFailures().size(),1);
    }
    @Test
    public void testSuiteRunCorrecta() {
        TestResult result = new TestResult();
        TestSuite suite = new TestSuite();
        TestRestaCalculadoraCorrecta tRestaCalc = new TestRestaCalculadoraCorrecta();
        suite.addTest(tRestaCalc);
        suite.run(result);
        assertEquals(result.getPasses().size(),1);
    }
    @Test
    public void testAssertTrueCorrecto(){
        boolean fallo = false;
        try{
        tp.junit.Assert.assertTrue(true);
        }catch(Error e){
          fallo = true; 
        }
        assertTrue(!fallo);
    }
    @Test
    public void testAssertTrueFalla(){
        boolean fallo = false;
        try{
        tp.junit.Assert.assertTrue(false);
        }catch(Error e){
            fallo = true;  
        }
        assertTrue(fallo);
    }
    @Test
    public void testAssertFalseCorrecta(){
        boolean fallo = false;
        try{
        tp.junit.Assert.assertFalse(false);
        }catch(Error e){
            fallo=true; 
        }
        assertTrue(!fallo);
    }
    @Test
    public void testAssertFalseFalla(){
        boolean fallo = false;
        try{
        tp.junit.Assert.assertFalse(true);
        }catch(Error e){
            fallo = true;  
        }
        assertTrue(fallo);
    }
    @Test
    public void testAssertEqualsFalla(){
        boolean fallo = false;
        try{
        tp.junit.Assert.assertEquals(1,2);
        }catch(Error e){
            fallo = true;  
        }
        assertTrue(fallo);
    }
    @Test
    public void testAssertEqualsCorrecto(){
        boolean fallo = false;
        try{
        tp.junit.Assert.assertEquals(1,1);
        }catch(Error e){
            fallo = true;  
        }
        assertTrue(!fallo);
    }
    @Test
    public void testFail(){
        boolean fallo = false;
        try{
        tp.junit.Assert.fail();
        }catch(Error e){
            fallo=true;
        }
        assertTrue(fallo);
    }
    @Test
    public void testSuiteAddTest(){
        TestResult result = new TestResult();
        TestSuite suite = new TestSuite();
        TestCalculadora tcalc = new TestCalculadora();
        TestRestaCalculadora tRestaCalc = new TestRestaCalculadora();
        suite.addTest(tcalc);
        suite.addTest(tRestaCalc);
        suite.run(result);
        assertEquals(2,result.getTestCount()); 
    }
    
}