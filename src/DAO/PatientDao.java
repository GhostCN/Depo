/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.Patient;
import Entities.Utilisateur;
import Interfaces.Ipatient;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import javafx.collections.ObservableList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Ghost CN
 */
public class PatientDao extends UnicastRemoteObject implements Ipatient  {
     private EntityManager em;
     int ok;
    public PatientDao() throws RemoteException {
         EntityManagerFactory emf=Persistence.createEntityManagerFactory("Hopital_ServeurPU");
        em=emf.createEntityManager();
    }

    @Override
    public int AddPatient(Patient pat) throws RemoteException {
          try 
        {
            em.getTransaction().begin();
            em.persist(pat);
            em.getTransaction().commit();
            em.refresh(pat);
            ok=pat.getId();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return ok;
    
    }

    @Override
    public String NumPatientAuto() throws RemoteException {
        int nb= em.createNamedQuery("Patient.findAll").getResultList().size()+1;
      return "Patient "+nb;
    }

    @Override
    public Patient GetPatient(int num) throws RemoteException {
          Query  query=em.createNamedQuery("Patient.findById");
        query.setParameter("id",num);
         Patient pat=new Patient();
        pat=(Patient)query.getSingleResult();
          if(pat!=null)
        {
            return pat;
        }
        else {
            return null;
        }
    }

    @Override
    public List<Patient> ListPatient() throws RemoteException {
         Query  query=em.createNamedQuery("Patient.findAll");
         List<Patient>ListePat=query.getResultList();
         return ListePat;
         
    }
}
