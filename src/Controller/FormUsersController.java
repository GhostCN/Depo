/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static Controller.ChercherPatientController.num;
import Entities.Utilisateur;
import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import tools.Fabrique;
import tools.Notification;
import tools.Tools;

/**
 * FXML Controller class
 *
 * @author Ghost CN
 */
public class FormUsersController implements Initializable {

    @FXML
    private Pane paneUsers;
    @FXML
    private TabPane tabPaneUsers;
    @FXML
    private Tab tabAffichage;
    @FXML
    private Tab tabConsulter;
    @FXML
    private TextField txtPrenom;
    @FXML
    private TextField txtAdresse;
    @FXML
    private TextField txtNom;
    @FXML
    private ComboBox<String> comboProfil;
     @FXML
    private TableView<Utilisateur> TV;

    @FXML
    private TableColumn<Utilisateur, String> prenomClmn;

    @FXML
    private TableColumn<Utilisateur, String> nomClmn;

    @FXML
    private TableColumn<Utilisateur, String> logClmn;

    @FXML
    private TableColumn<Utilisateur, String> passClmn;

    @FXML
    private TableColumn<Utilisateur, String> telClmn;

    @FXML
    private TableColumn<Utilisateur, String> emailClmn;
    
    @FXML
    private TextField telTxt;

    @FXML
    private TextField emailTxt;

    @FXML
    private TextField logtxt;

    @FXML
    private PasswordField passwdTxt;

    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Fabrique.init();
          prenomClmn.setCellValueFactory(new PropertyValueFactory<>("prenom"));
            nomClmn.setCellValueFactory(new PropertyValueFactory<>("nom"));
              telClmn.setCellValueFactory(new PropertyValueFactory<>("tel"));
              emailClmn.setCellValueFactory(new PropertyValueFactory<>("email"));
              
         ObservableList<String> listProfil=FXCollections.observableArrayList("administrateur","Medecin","Infirmier");
            comboProfil.setItems(listProfil);
    }    

   

    @FXML
    private void ajout(ActionEvent event) throws RemoteException {
        Utilisateur u=new Utilisateur();
        u.setNom(txtNom.getText());
        u.setPrenom(txtPrenom.getText());
        u.setTel(telTxt.getText());
        u.setAdresse(txtAdresse.getText());
        u.setLogin(logtxt.getText());
        u.setPassword(passwdTxt.getText());
        u.setEmail(emailTxt.getText());
        u.setProfil(comboProfil.getValue());
        int x=Fabrique.ius.addUser(u);
        if(x>0)
        {
            Notification.NotifSucces("Bien", "Utilisateur bien inséré");
            
 
        }
        else Notification.NotifError("Bad", "Utilisateur mal inséré");
    }
    
    
    @FXML
    void Affichage(ActionEvent event) {
        LoadTable();

    }
    
    void LoadTable()
    {
        try {
            ObservableList<Utilisateur> ListU=FXCollections.observableArrayList();
            Fabrique.ius.ListeU().stream().forEach(u->ListU.add(u));
            TV.setItems(ListU);
        } catch (RemoteException ex) {
            Logger.getLogger(FormUsersController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
