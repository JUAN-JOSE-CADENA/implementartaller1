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
import javafx.util.Duration;

/**
 *
 * @author User
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private TextAres textAreaReporte;

    @FXML
    private TextFields textFieldsTiempo;

    @FXML
    private Webview webViewCola;
    private WebEngine webEngineCola;

    @FXML
    private Webview webViewCajeros;
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

        int numClientes = (int) (Math.ramdom() * 2);
        System.out.println("Se crearon" + numClientes + " clientes");

        for (int i = 0; i < numClientes; i++) {

            Cliente c = FactoryCliente.create();

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
                    } 
                    else if (cajero == cajeros.get(1)) 
                    {
                        sumaCajero2++;
                    } 
                    else if (cajero == cajeros.get(2)) 
                    {
                        sumaCajero3++;

                    }
                    else if (cajero == cajeros.get(3)) 
                    {
                        sumaCajero4++;

                    }
                    else if (cajero == cajeros.get(4)) 
                    {
                        sumaCajero5++;

                    }
                    else if (cajero == cajeros.get(5)) 
                    {
                        sumaCajero6++;

                    }
                    
                    System.err.println(sumaCajero1 + " " + sumaCajero2 + " " + sumaCajero3 + " " + sumaCajero4 + " " + sumaCajero5 + " " + sumaCajero6 + " ");

                }
                
                if(cajero.getTiempoTransaccion() == 0)
                {
                    
                    cajero.setEstado(true);
                }
            }

        }
    }

}
