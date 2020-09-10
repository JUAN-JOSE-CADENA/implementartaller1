/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementartaller1;

import core.Cola;
import dato.Cliente;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 *
 * @author User
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label label;

    Cola<Cliente> colac;
    int max;
    int min;
    int range;

    @FXML
    private void handleButtonAction(ActionEvent event) {

        colac.encolar(new Cliente((int)(Math.random() * range) + min, (int)(Math.random() * range) + min));
        colac.encolar(new Cliente((int)(Math.random() * range) + min, (int)(Math.random() * range) + min));
        colac.encolar(new Cliente((int)(Math.random() * range) + min, (int)(Math.random() * range) + min));
        colac.encolar(new Cliente((int)(Math.random() * range) + min, (int)(Math.random() * range) + min));
        colac.encolar(new Cliente((int)(Math.random() * range) + min, (int)(Math.random() * range) + min));
        
        System.out.println("Contenido de la cola \n" + colac.toString());
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        colac = new Cola<>();

        max = 10;
        min = 1;
        range = max - min + 1;
    }

    @FXML
    private void mostrar(ActionEvent event) {
        
        colac.desencolar();       
        System.out.println("Contenido de la cola \n" + colac.toString());

    }

}
