/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.Dossier;
import Entities.RendezVous;
import Interfaces.Idossier;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Ghost CN
 */
public class DossierDao extends UnicastRemoteObject implements Idossier{
       private EntityManager em;
     int ok;

    public DossierDao() throws RemoteException {
          EntityManagerFactory emf=Persistence.createEntityManagerFactory("Hopital_ServeurPU");
        em=emf.createEntityManager();
    }

    @Override
    public String NumDossier() throws RemoteException {
        int nb= em.createNamedQuery("Dossier.findAll").getResultList().size()+1;
      return "Dossier"+nb;
    }

    @Override
    public Dossier SearchDossier(String num) throws RemoteException {
        Dossier dos=new Dossier();
         dos=(Dossier) em.createNamedQuery("Dossier.findByNumD").setParameter("numD", num).getSingleResult();
      
         if(dos!=null)
        {
            return dos;
        }
        else {
            return null;
        }
    }

    @Override
    public int AddDossier(Dossier d) throws RemoteException {
        
          try 
        {
            em.getTransaction().begin();
            em.persist(d);
            em.getTransaction().commit();
            em.refresh(d);
            ok=d.getId();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return ok;
    }

    @Override
    public List<RendezVous> SearchRdv(String num) throws RemoteException {
       List<RendezVous> ListeRV=new ArrayList<>();
       Dossier dos=new Dossier();
         dos=(Dossier) em.createNamedQuery("Dossier.findByNumD").setParameter("numD", num).getSingleResult();
      
         if(dos!=null)
        {
            return ListeRV=dos.getRendezVousList();
        }
        else {
            return null;
        }
    }
    
}
