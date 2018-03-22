/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import tools.Tools2;

/**
 * FXML Controller class
 *
 * @author Ghost CN
 */
public class PageMedecinController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
      @FXML
    void RechercherDossier(ActionEvent event) {
        
        try {
            String url = "/Views/chercherPatient.fxml";
            Tools2.myLoadPage(event, url, 2);
        } catch (IOException ex) {
            Logger.getLogger(PageMedecinController.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

}
