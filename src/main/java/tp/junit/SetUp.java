/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tp.junit;

import java.util.ArrayList;

public abstract class SetUp {
    ArrayList<Object> atributos;
    
    public SetUp(){
        atributos = new ArrayList<Object>();
    }
    
    public void agregarAtributo(Object atributo){
        atributos.add(atributo);       
    }
    
    public Object ObtenerAtributo(int posicion){
        return atributos.get(posicion);
    }
    
    public abstract void agregarAtributos();
}
