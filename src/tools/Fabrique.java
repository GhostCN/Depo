package tools;


import Interfaces.Iconsultation;
import Interfaces.Idocument;
import Interfaces.Idossier;
import Interfaces.Ipatient;
import Interfaces.IrendezVous;
import Interfaces.Iuser;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class Fabrique {
	
public static Iconsultation icons;
public static Iuser ius;
public static Ipatient ipat;
public static Idocument idoc;
public static Idossier idoss;
public static IrendezVous irendez;

	public static void init()
        {
	 try 
         {
             Registry registry = LocateRegistry.getRegistry("localhost", 1099);
             icons = (Iconsultation) registry.lookup("ConsultationDao");
             ius = (Iuser) registry.lookup("UtilisateurDao");
             idoc = (Idocument) registry.lookup("DocumentDao");
             idoss = (Idossier) registry.lookup("DossierDao");
             ipat = (Ipatient) registry.lookup("PatientDao");
             irendez = (IrendezVous) registry.lookup("RendezVousDao");
            
          } catch (Exception e) 
          {
                e.printStackTrace();
            }
	}
}
