/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.RendezVous;
import Entities.Utilisateur;
import Interfaces.IrendezVous;
import java.rmi.RemoteException;
import java.rmi.server.RemoteObject;
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
public class RendezVousDao extends UnicastRemoteObject implements IrendezVous{
   private EntityManager em;
     int ok;
    public RendezVousDao() throws RemoteException {
            EntityManagerFactory emf=Persistence.createEntityManagerFactory("Hopital_ServeurPU");
        em=emf.createEntityManager();
    }

    @Override
    public int AddRv(RendezVous rv) throws RemoteException {
          try 
        {
            em.getTransaction().begin();
            em.persist(rv);
            em.getTransaction().commit();
            em.refresh(rv);
            ok=rv.getId();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return ok;
    }

    @Override
    public List<RendezVous> ListeRV() throws RemoteException {
       List<RendezVous> liste=new ArrayList<>();
       Query query=em.createNamedQuery("RendezVous.findAll");
       liste=query.getResultList();
       return liste;
    }

    @Override
    public String NumRvAuto() throws RemoteException {
        int nb= em.createNamedQuery("RendezVous.findAll").getResultList().size()+1;
      return "RendezVous "+nb;
    }
    
}
