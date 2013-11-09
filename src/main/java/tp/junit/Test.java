/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * Interfaz del composite - componente.
 */
package tp.junit;


public abstract class Test extends Assert {

    SetUp setUp = null;

    public void setAtributos(SetUp setup) {
        setUp = setup;
    }
    /*
     * Metodo para correr el Test
     */

    public SetUp getSetUp(){
        return setUp;
    }
    public abstract void run(TestResult result);

    public abstract String classType();
    
    public abstract String getName();
    
    public abstract void regularExp(String regex);
    
    public abstract void haveTag(String tag);
}
