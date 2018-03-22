/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entities.Utilisateur;
import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import tools.Fabrique;
import tools.Notification;
import tools.Tools;

/**
 * FXML Controller class
 *
 * @author Ghost CN
 */
public class UserController implements Initializable {
    public static String log;
    public static String pass;
    public static String profile;
    @FXML
    private TextField logTxt;
    @FXML
    private PasswordField passwd;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Fabrique.init();
    }    

    @FXML
    private void Valider(ActionEvent event) throws RemoteException{
    
         if(logTxt.getText().equals("")||passwd.getText().equals(""))
        {
            Notification.NotifError("Chaine vide", "Faut renseigner tous les champs");
        }
        Utilisateur user=null;
       log=logTxt.getText();
       pass=passwd.getText();
       
             user =Fabrique.ius.GetUser(log,pass);
       
      
        if (user != null) {
              profile=user.getProfil();
            Notification.NotifSucces("Bien", "Bienvenu " + user.getPrenom());
            if (profile.equalsIgnoreCase("infirmier")) {
                try
                {
                    String url="/Views/espaceInfirmier.fxml";
                    Tools.myLoadPage(event, url);
                } catch (IOException ex) {
                    Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            
            if (profile.equalsIgnoreCase("medecin")) {
                 try
                {
                    String url="/Views/pageMedecin.fxml";
                    Tools.myLoadPage(event, url);
                } catch (IOException ex) {
                    Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            
            if (profile.equalsIgnoreCase("admin")) {
                 try
                {
                    String url="/Views/FormUsers.fxml";
                    Tools.myLoadPage(event, url);
                } catch (IOException ex) {
                    Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            
           
        }
        else {
            Notification.NotifError("Echec", "Login ou mot de passe incorrect");
        }


    }
    
}
