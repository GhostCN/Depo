/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entities.Dossier;
import Entities.Patient;
import Entities.RendezVous;
import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import tools.Fabrique;
import tools.Notification;
import tools.Tools;

/**
 * FXML Controller class
 *
 * @author Ghost CN
 */
public class EspaceInfirmierController implements Initializable {

    String numP="";
      @FXML
    private TextField numDossTxt;
    @FXML
    private TextField prenomTxt;
    @FXML
    private TextField addTxt;
    @FXML
    private TextField nomTxt;
    @FXML
    private TextField villetxt;
    @FXML
    private TextField teltxt;
    @FXML
    private TextField emailtxt;
    @FXML
    private TextField telResponstxt;
    @FXML
    private TextField NomResponsTxt;
    @FXML
    private TextField matTxt;
    @FXML
    private ComboBox<String> sexCmbx;
    @FXML
    private TextField agetxt;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            Fabrique.init();
            ObservableList<String> listSex=FXCollections.observableArrayList("Masculin","Feminin");
            sexCmbx.setItems(listSex);
            numP = Fabrique.ipat.NumPatientAuto();
            matTxt.setText(numP);
        } catch (RemoteException ex) {
            Logger.getLogger(EspaceInfirmierController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
     @FXML
    void CheckRdv(ActionEvent event) throws RemoteException {
        if(numDossTxt.getText().equalsIgnoreCase(""))
        {
            Notification.NotifError("Erreur", "Veuillez saisir un numero de dossier");
        }
        else{
            List<RendezVous> ListRV=Fabrique.idoss.SearchRdv(numDossTxt.getText());
               try
                {
                    String url="/Views/pageMedecin.fxml";
                    Tools.myLoadPage(event, url);
                } catch (IOException ex) {
                    Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
                }
            
        }
            
            

    }
    
    
    @FXML
    void Deconnexion(ActionEvent event) {

    }

    @FXML
    private void Enregistrer(ActionEvent event) throws RemoteException{
        Patient p=new Patient();
        
        p.setNumP(numP);
        p.setNom(nomTxt.getText());
        p.setPrenom(prenomTxt.getText());
        p.setTel(teltxt.getText());
        p.setAge(Integer.parseInt(agetxt.getText()));
        p.setVille(villetxt.getText());
        p.setEmail(emailtxt.getText());
        p.setTelParent(telResponstxt.getText());
        p.setNomParent(NomResponsTxt.getText());
      int x= Fabrique.ipat.AddPatient(p);
       
       if(x>0)
       {
           Notification.NotifSucces("Suuces", "Patient bien inséré");
           matTxt.setText("");
           nomTxt.setText("");
           prenomTxt.setText("");
           agetxt.setText("");
           villetxt.setText("");
           emailtxt.setText("");
           telResponstxt.setText("");
           NomResponsTxt.setText("");
           Dossier dos=new Dossier();
           dos.setNumD(Fabrique.idoss.NumDossier());
           dos.setUser(Fabrique.ius.GetUser(UserController.log, UserController.pass));
           dos.setPatient(Fabrique.ipat.GetPatient(x));
           int k=Fabrique.idoss.AddDossier(dos);
           if(k>0)
           {
                Notification.NotifSucces("Suuces", "Dossier bien inséré");
               
           }
           else{
                Notification.NotifError("Echec", "Insertion bien échouée");
           }
               
               
               
       }
           
       else
       {
           Notification.NotifError("Echec", "Insertion bien échouée");
       }
        
        
    }
    
}
