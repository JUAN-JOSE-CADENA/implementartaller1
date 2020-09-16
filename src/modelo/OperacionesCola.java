/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import core.Base;
import core.Cola;
import dato.Cliente;

/**
 *
 * @author dacastro
 */
public class OperacionesCola<T extends Base> {

    public static <T extends Base> Cola<T> duplicar(Cola<T> colaOriginal) {
        Cola<T> colaAux = new Cola<>();
        Cola<T> coladuplicada = new Cola<>();

        while (!colaOriginal.estaVacia()) {
            colaAux.encolar(colaOriginal.desencolar());
        }
        while (!colaAux.estaVacia()) {
            T e = colaAux.desencolar();
            T c = (T) e.copy();

            colaOriginal.encolar(e);
            coladuplicada.encolar(c);
        }

        return coladuplicada;

    }
    
    public static <T extends Base> Cola<T> invertir(Cola<T> pilaOriginal) {
        Cola<T>  pilainvertida=new Cola<>();
        Cola<T> pilad=duplicar(pilaOriginal);
        
        while (!pilad.estaVacia()) {            
             pilainvertida.encolar(pilad.desencolar());
        }
        
        return pilainvertida;
                
    }

    public static String generarhtml(Cola<Cliente> colac) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
