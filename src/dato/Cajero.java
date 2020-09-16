/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dato;

/**
 *
 * @author SEBASTIAN
 */
public class Cajero {

    private boolean estado;
    private int tiempoTransaccion;
    private int edadCliente;
    private int numClientes;

    public Cajero(boolean estado, int tiempoTransaccion, int edadCliente, int numClientes) {
        this.estado = estado;
        this.tiempoTransaccion = tiempoTransaccion;
        this.edadCliente = edadCliente;
        this.numClientes = numClientes;
    }

    public Cajero() {

        this.estado = true;
        this.tiempoTransaccion = 0;
        this.edadCliente = 0;
        this.numClientes = 0;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getTiempoTransaccion() {
        return tiempoTransaccion;
    }

    public void setTiempoTransaccion(int tiempoTransaccion) {
        this.tiempoTransaccion = tiempoTransaccion;
    }

    public int getEdadCliente() {
        return edadCliente;
    }

    public void setEdadCliente(int edadCliente) {
        this.edadCliente = edadCliente;
    }

    public int getNumClientes() {
        return numClientes;
    }

    public void setNumClientes(int numClientes) {
        this.numClientes = numClientes;
    }
    
    

}
