/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.Consultation;
import Interfaces.Iconsultation;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Ghost CN
 */
public class ConsultationDao extends UnicastRemoteObject implements Iconsultation{
     private EntityManager em;
     int ok;

    public ConsultationDao() throws RemoteException {
       EntityManagerFactory emf=Persistence.createEntityManagerFactory("Hopital_ServeurPU");
        em=emf.createEntityManager();
    }

    @Override
    public int AddConsultation(Consultation cons) throws RemoteException {
            try 
        {
            em.getTransaction().begin();
            em.persist(cons);
            em.getTransaction().commit();
            em.refresh(cons);
            ok=cons.getId();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return ok;
    }

    @Override
    public List<Consultation> GetListConsultation(String dos) throws RemoteException {
       Query q=em.createNamedQuery("Consultation.findByNumDossier").setParameter("dossier",dos);
       List<Consultation>ListeCons=q.getResultList();
       return ListeCons;
    }
    
    
    
}
