/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementartaller1;

import core.Cola;
import dato.Cajero;
import dato.Cliente;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ResourceBundle;
import java.util.Timer;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.util.Duration;
import modelo.OperacionesCola;
import static modelo.OperacionesCola.duplicar;

/**
 *
 * @author User
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private TextArea textAreaReporte;

    @FXML
    private TextField textFieldTiempo;

    @FXML
    private WebView webViewCola;
    private WebEngine webEngineCola;

    @FXML
    private WebView webViewCajeros;
    private WebEngine webEngineCajeros;

    private Cola<Cliente> colac;
    private LinkedList<Cajero> cajeros;
    private Timer timer;
    private int tiempoTotal;
    private String htmlCola;
    private String htmlCajeros;
    private int sumaCajero1;
    private int sumaCajero2;
    private int sumaCajero3;
    private int sumaCajero4;
    private int sumaCajero5;
    private int sumaCajero6;

    private Timeline t;

    //@FXML
    //private void handleButtonAction(ActionEvent event) {
    //colac.encolar(new Cliente((int) (Math.random() * range) + min, (int) (Math.random() * range) + min));
    //colac.encolar(new Cliente((int) (Math.random() * range) + min, (int) (Math.random() * range) + min));
    //colac.encolar(new Cliente((int) (Math.random() * range) + min, (int) (Math.random() * range) + min));
    //colac.encolar(new Cliente((int) (Math.random() * range) + min, (int) (Math.random() * range) + min));
    //colac.encolar(new Cliente((int) (Math.random() * range) + min, (int) (Math.random() * range) + min));
    //System.out.println("Contenido de la cola \n" + colac.toString());
    //}
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        colac = new Cola<>();
        cajeros = new LinkedList<>();

        for (int i = 0; i <= 5; i++) {

            cajeros.add(new Cajero());

        }

        System.out.println(cajeros.toString());

        t = new Timeline(new KeyFrame(Duration.millis(1000), new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                hacerQueTodoFuncione();
            }

            private void hacerQueTodoFuncione() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        }));

        t.setCycleCount(Animation.INDEFINITE);

        webEngineCola = webViewCola.getEngine();
        webEngineCajeros = webViewCajeros.getEngine();

        htmlCajeros = "<table border=1 width=100%><tr><th>Cajero 1</th><th>Cajero 2</th><th>Cajero 4</th><th>Cajero 5</th><th>Cajero 6</th></tr></table>";

        sumaCajero1 = 0;
        sumaCajero2 = 0;
        sumaCajero3 = 0;
        sumaCajero4 = 0;
        sumaCajero5 = 0;
        sumaCajero6 = 0;

    }

    @FXML
    private void hadleButtonIniciar(ActionEvent event) {

        t.play();

        //colac.desencolar();
        //System.out.println("Contenido de la cola \n" + colac.toString());
    }

    @FXML
    private void handleButtonTerminar(ActionEvent event) {

        t.stop();

        textFieldTiempo.setText(tiempoTotal + " sengundos");
        textAreaReporte.setText(escribirReporte());

    }

    private void hacerQueFuncione() {

        crearClientes();
        revisarCajerosLibres();
        tiempoTotal++;
        webEngineCola.loadContent(hacerHtmlCola());
        webEngineCajeros.loadContent(hacerHtmlCajeros());

    }

    private void crearClientes() {

        int numClientes = (int) (Math.random() * 2);
        System.out.println("Se crearon" + numClientes + " clientes");

        for (int i = 0; i < numClientes; i++) {

            int edad = (int) (Math.random() * (65 - 18) + 18);
            int tiempoTransaccion = (int) (Math.random() * (60 - 1) + 1);

            Cliente c = new Cliente(edad, tiempoTransaccion);

            colac.encolar(c);
        }
    }

    private void revisarCajerosLibres() {

        System.err.println("Atender cliente");

        for (Iterator<Cajero> itCajero = cajeros.iterator(); itCajero.hasNext();) {

            Cajero cajero = itCajero.next();

            if (cajero.isEstado() && !colac.estaVacia()) {

                Cliente c = colac.desencolar();

                cajero.setEstado(false);
                cajero.setTiempoTransaccion(c.getTiempoTransaccion());
                cajero.setEdadCliente(c.getEdad());
                cajero.setNumClientes(cajero.getNumClientes() + 1);

            } else {

                if (cajero.getTiempoTransaccion() > 0) {

                    cajero.setTiempoTransaccion(cajero.getTiempoTransaccion() - 1);

                    if (cajero == cajeros.get(0)) {

                        sumaCajero1++;
                    } else if (cajero == cajeros.get(1)) {
                        sumaCajero2++;
                    } else if (cajero == cajeros.get(2)) {
                        sumaCajero3++;

                    } else if (cajero == cajeros.get(3)) {
                        sumaCajero4++;

                    } else if (cajero == cajeros.get(4)) {
                        sumaCajero5++;

                    } else if (cajero == cajeros.get(5)) {
                        sumaCajero6++;

                    }

                    System.err.println(sumaCajero1 + " " + sumaCajero2 + " " + sumaCajero3 + " " + sumaCajero4 + " " + sumaCajero5 + " " + sumaCajero6 + " ");

                }

                if (cajero.getTiempoTransaccion() == 0) {

                    cajero.setEstado(true);
                }
            }

        }

        System.err.println(cajeros.toString());
    }

    private String hacerHtmlCola() {

        String html = "<html><table boder=1 width=100%>";
        html += OperacionesCola.generarhtml(colac) + "</table></html>";

        return html;
    }

    private String hacerHtmlCajeros() {

        String html = "<table border=1 width=100%><tr>";
        String estado;
        int contador = 0;

        for (int i = 0; i < 6; i++) {

            if (contador == 0) {

                html += "<th>Cajero</th>";
            }

            if (cajeros.get(i).isEstado()) {

                html += "<th bgcolor=\"green\">" + (i + 1) + "</th>";
            } else {
                html += "<th bgcolor=\"red\">" + (i + 1) + "</th>";
            }

            contador++;

        }

        contador = 0;

        html += "</tr><tr>";

        for (Cajero cajero : cajeros) {

            if (contador == 0) {

                html += "<th>Estado</th>";
            }

            if (cajero.isEstado()) {
                estado = "bgcolor=\"green\">Disponible";
            } else {

                estado = "bgcolor=\red\">No Disponible";
            }

            html += "<td" + estado + "</td>";
            contador++;
        }

        for (Cajero cajero : cajeros) {

            if (contador == 0) {

                html += "<th>Edad</th>";
            }

            if (cajero.isEstado()) {

                html += "<th bgcolor=\"green\">";
            } else {
                html += "<th bgcolor=\"red\">";
            }

            html += cajero.getEdadCliente() + "</td>";
            contador++;

        }

        html += "</tr><tr>";
        contador = 0;

        for (Cajero cajero : cajeros) {

            if (contador == 0) {

                html += "<th>Tiempo de transaccion</th>";
            }

            if (cajero.isEstado()) {

                html += "<th bgcolor=\"green\">";
            } else {
                html += "<th bgcolor=\"red\">";
            }

            html += cajero.getTiempoTransaccion() + "</td>";
            contador++;
        }

        html += "</tr><tr>";
        contador = 0;

        for (Cajero cajero : cajeros) {

            if (contador == 0) {

                html += "<th>Numero de clientes</th>";
            }

            if (cajero.isEstado()) {

                html += "<th bgcolor=\"green\">";
            } else {
                html += "<th bgcolor=\"red\">";
            }

            html += cajero.getNumClientes() + "</td>";
            contador++;

        }

        html += "</tr>";

        html += "</table>";
        return html;
    }

    private String escribirReporte() {
        String reporte;
        int clientesCola = contarClientesCola();
        double promedioCajero1 = 0.0;
        double promedioCajero2 = 0.0;
        double promedioCajero3 = 0.0;
        double promedioCajero4 = 0.0;
        double promedioCajero5 = 0.0;
        double promedioCajero6 = 0.0;

        if (sumaCajero1 != 0) {
            promedioCajero1 = sumaCajero1 / cajeros.get(0).getNumClientes();
        }

        if (sumaCajero1 != 0) {
            promedioCajero2 = sumaCajero2 / cajeros.get(1).getNumClientes();
        }

        if (sumaCajero1 != 0) {
            promedioCajero3 = sumaCajero3 / cajeros.get(2).getNumClientes();
        }

        if (sumaCajero1 != 0) {
            promedioCajero4 = sumaCajero4 / cajeros.get(3).getNumClientes();
        }

        if (sumaCajero1 != 0) {
            promedioCajero5 = sumaCajero5 / cajeros.get(4).getNumClientes();
        }

        if (sumaCajero1 != 0) {
            promedioCajero6 = sumaCajero6 / cajeros.get(5).getNumClientes();
        }

        reporte = "El numero de clientes que quedaron en la fila es de" + clientesCola
                + ".\nEl tiempo promedio de atencion de clientes de las cajas fue de : \n"
                + "Cajero 1: " + promedioCajero1 + ".\nCajero 2: " + promedioCajero2
                + ".\nCajero 3: " + promedioCajero3 + ".\nCajero 4: " + promedioCajero4
                + ".\nCajero 5: " + promedioCajero5 + ".\nCajero 6: " + promedioCajero6;

        return reporte;
    }

    private int contarClientesCola() {
        int contador = 0;
        Cola<Cliente> colaCopia = duplicar(colac);
        
        while(!colaCopia.estaVacia())
        {
            colaCopia.desencolar();
            contador++;
            
        }
        
        return contador;
    }

}
