/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entities.Consultation;
import Entities.Document;
import Entities.Patient;
import Entities.Utilisateur;
import cours.services.LoadView;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;
import tools.Fabrique;
import tools.Notification;

/**
 * FXML Controller class
 *
 * @author Ghost CN
 */
public class DossierclientController implements Initializable {

    @FXML
    private TextField prescritTxt;
    @FXML
    private TextField commentaireTxt;
    @FXML
    private ComboBox<String> comboTypeDoc;
    @FXML
    private Label labPhoto;
    
    @FXML
    private TableView<Patient> TVPatient;

    @FXML
    private TableColumn<Patient, String> numPat;

    @FXML
    private TableColumn<Patient, String> prenomPat;

    @FXML
    private TableColumn<Patient, String> nomPat;

    @FXML
    private TableColumn<Patient, String> telPat;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Fabrique.init();
         numPat.setCellValueFactory(new PropertyValueFactory<>("numP"));
         prenomPat.setCellValueFactory(new PropertyValueFactory<>("prenom"));
         nomPat.setCellValueFactory(new PropertyValueFactory<>("nom"));
         telPat.setCellValueFactory(new PropertyValueFactory<>("Tel"));
         Charger();
        //initDefaultImage();
		handleGetImage();
	//	fichier=new File("src/cours/photos/default.png");
    }    

    @FXML
    private void enregistrerConsultation(ActionEvent event) {
        try {
            Consultation cons=new Consultation();
            cons.setCommentaire(commentaireTxt.getText());
            cons.setPrescription(prescritTxt.getText());
            cons.setUtilisateur(Fabrique.ius.GetUser(UserController.log, UserController.pass));
            cons.setDossier(Fabrique.idoss.SearchDossier(ChercherPatientController.num));
            int x=Fabrique.icons.AddConsultation(cons);
            if(x>0)
            {
                Notification.NotifSucces("Succes", "Consultation bien insérée");
            }
            else Notification.NotifError("Bad", "Consultation echoué");
        } catch (RemoteException ex) {
            Logger.getLogger(DossierclientController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    File fichier=null;
    /*
	private void initDefaultImage()
	{
		BufferedImage bimg=null;
		try {
			
			fichier= new File("src/cours/photos/default.png");
			BufferedImage bmg=ImageIO.read(fichier);
			Image image=SwingFXUtils.toFXImage(bmg, null);
			ImageView imageView=new ImageView(new Image("/cours/photos/default.png"));
			imageView.setFitWidth(100);
			imageView.setFitHeight(160);
			labPhoto.setGraphic(imageView);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();;
		}
	}
       */
        private void handleGetImage()
	{
		labPhoto.addEventHandler(MouseEvent.MOUSE_CLICKED, (event)->{
			try {
				FileChooser chooser=new FileChooser();
				chooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("PNG", "*.png"),
						                             new FileChooser.ExtensionFilter("JPG", "*.jpg"),
						                             new FileChooser.ExtensionFilter("JPEG", "*.jpeg")
								);
				fichier =chooser.showOpenDialog(LoadView.getStage());
				if(fichier!=null)
				{
					BufferedImage bmg=ImageIO.read(fichier);
					Image image =SwingFXUtils.toFXImage(bmg, null);
					ImageView imageView=new ImageView(image);
					imageView.setFitWidth(100);
					imageView.setFitHeight(160);
					labPhoto.setGraphic(imageView);
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		});
	}

    @FXML
    private void ajouter(ActionEvent event) throws FileNotFoundException {
        try 
        {
            Document doc=new Document();
            doc.setDossier(Fabrique.idoss.SearchDossier(ChercherPatientController.num));
            doc.setLibelle(comboTypeDoc.getValue());
            FileInputStream fis=new FileInputStream(fichier);
         //   doc.setStockage(fis.available());
         
        } catch (RemoteException ex) {
            Logger.getLogger(DossierclientController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void Charger()
    {
         try {
            ObservableList<Patient> ListPat=FXCollections.observableArrayList();
            Fabrique.ipat.ListPatient().stream().forEach(u->ListPat.add(u));
            TVPatient.setItems(ListPat);
        } catch (RemoteException ex) {
            Logger.getLogger(FormUsersController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
        
    
}
