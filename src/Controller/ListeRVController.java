/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entities.RendezVous;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sun.net.www.MimeTable;
import tools.Fabrique;

/**
 * FXML Controller class
 *
 * @author Ghost CN
 */
public class ListeRVController implements Initializable {
 @FXML
    private TableView<RendezVous> RVTable;

    @FXML
    private TableColumn<RendezVous, String> numRvClmn;

    @FXML
    private TableColumn<RendezVous, String> dateRvClmn;

    @FXML
    private TableColumn<RendezVous, String> dossClmn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Fabrique.init();
          numRvClmn.setCellValueFactory(new PropertyValueFactory<>("numRv"));
           dateRvClmn.setCellValueFactory(new PropertyValueFactory<>("dateRv"));
            dossClmn.setCellValueFactory(new PropertyValueFactory<>("dossier"));
            LoadTable();
    
    }    
    void LoadTable()
    {
        try {
            ObservableList<RendezVous> ListU=FXCollections.observableArrayList();
            Fabrique.irendez.ListeRV().stream().forEach(rv->ListU.add(rv));
            RVTable.setItems(ListU);
        } catch (RemoteException ex) {
            Logger.getLogger(FormUsersController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
