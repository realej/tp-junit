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
    
    public ArrayList<Object> getArrayList(){
        return atributos;
    }
    
    public void tearDown(){
        if (atributos != null){
        atributos.clear();
        agregarAtributos();
        }
    }
    
    public abstract void agregarAtributos();
}
