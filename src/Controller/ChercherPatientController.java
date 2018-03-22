/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entities.Dossier;
import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import tools.Fabrique;
import tools.Notification;
import tools.Tools;

/**
 * FXML Controller class
 *
 * @author Ghost CN
 */
public class ChercherPatientController implements Initializable {

    /**
     * Initializes the controller class.
     */
     @FXML
    private TextField NumTxt;
    public static String num;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Fabrique.init();
    }    
   
    @FXML
    void OpenDossier(ActionEvent event) {
  
        if(NumTxt.getText().equalsIgnoreCase(""))
        {
            Notification.NotifError("Erreur", "Veuiller saisir un numero de dossier");
        }
        else{
            
            try {
               
               if(Fabrique.idoss.SearchDossier(NumTxt.getText())!=null)
               {
                    try
                {
                    num=NumTxt.getText();
                    String url="/Views/Dossierclient.fxml";
                    Tools.myLoadPage(event, url);
                } catch (IOException ex) {
                    Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
                }
               }
                 else   Notification.NotifError("Erreur", "Veuiller saisir un numero de dossier");
            } catch (RemoteException ex) {
                Logger.getLogger(ChercherPatientController.class.getName()).log(Level.SEVERE, null, ex);
            }
          
        }

    }
    
}
