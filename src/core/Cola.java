/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.util.LinkedList;

/**
 *
 * @author User
 */
public class Cola <T extends Base> {
    
    private LinkedList<T> elements;

    public Cola() {
        
        elements = new LinkedList<>();
    }
    
    public void encolar(T elem){
        
        elements.addLast(elem); 
    }
    
    public T desencolar (){
        
         return elements.removeFirst();
    }
    
    public boolean estaVacia(){
        
        return elements.isEmpty();
    }
    
    
    
}
