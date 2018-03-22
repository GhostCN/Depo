/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hopital_serveur;


import DAO.ConsultationDao;
import DAO.DocumentDao;
import DAO.DossierDao;
import DAO.PatientDao;
import DAO.RendezVousDao;
import DAO.UtilisateurDao;
import Interfaces.Iconsultation;
import Interfaces.Idocument;
import Interfaces.Idossier;
import Interfaces.Ipatient;
import Interfaces.IrendezVous;
import Interfaces.Iuser;
import java.net.URL;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import tools.Notification;

/**
 * FXML Controller class
 *
 * @author Ghost CN
 */
public class ServeurRMIController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
      @FXML
    void Lancer(ActionEvent event) {
         try {
            Registry registry = LocateRegistry.createRegistry(1099);
             Ipatient ipat = new PatientDao();
            Iconsultation icons=new ConsultationDao();
             Iuser ius = new UtilisateurDao();
             IrendezVous irend = new RendezVousDao();
             Idossier idoss = new DossierDao();
             Idocument idoc = new DocumentDao();
           
	    registry.bind("PatientDao", ipat);
            registry.bind("ConsultationDao", icons);
            registry.bind("RendezVousDao", irend);
            registry.bind("DossierDao", idoss);
            registry.bind("DocumentDao", idoc);
            registry.bind("UtilisateurDao", ius);
          
            Notification.NotifSucces("Serveur Rmi", "Tous les clients sont connectés");
        } catch (Exception e) {
           Notification.NotifError("Bad job", "Connexion echoué");
            e.printStackTrace();
        }
        

    }

    
}
