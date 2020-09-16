/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dato;

import core.Base;

/**
 *
 * @author User
 */
public class Cliente extends Base {

    private int edad;
    private int tiempoEspera;

    public Cliente() {
    }

    public Cliente(int edad, int tiempoEspera) {
        this.edad = edad;
        this.tiempoEspera = tiempoEspera;
    }

    /**
     * Get the value of tiempoEspera
     *
     * @return the value of tiempoEspera
     */
    public int getTiempoEspera() {
        return tiempoEspera;
    }

    /**
     * Set the value of tiempoEspera
     *
     * @param tiempoEspera new value of tiempoEspera
     */
    public void setTiempoEspera(int tiempoEspera) {
        this.tiempoEspera = tiempoEspera;
    }

    /**
     * Get the value of edad
     *
     * @return the value of edad
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Set the value of edad
     *
     * @param edad new value of edad
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public Base copy() {
        return new Cliente(edad, tiempoEspera);
    }

    @Override
    public String toString() {
        return "Cliente{" + "edad=" + edad + ", tiempoEspera=" + tiempoEspera + '}' + "\n";
    }

    public int getTiempoTransaccion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    

}
