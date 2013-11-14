    package aplicacion;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

public class Calculadora {
    
    public Calculadora() {}
        
    public int suma(int n1, int n2){
        int op;
        op = n1 + n2;
        return op;
    }
 
    public int resta (int n1, int n2){ 
        int op;
        op = n1 - n2;
        return op;
    }
    
    public int multiplica(int n1, int n2){
        int op;
        op = n1 * n2;
        return op;
    }
}