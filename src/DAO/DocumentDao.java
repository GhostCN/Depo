/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.Document;
import Interfaces.Idocument;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Ghost CN
 */
public class DocumentDao extends UnicastRemoteObject implements Idocument {
   private EntityManager em;
     int ok;
    public DocumentDao() throws RemoteException {
          EntityManagerFactory emf=Persistence.createEntityManagerFactory("Hopital_ServeurPU");
        em=emf.createEntityManager();
    }

    @Override
    public int AddDocument(Document doc) throws RemoteException {
             try 
        {
            em.getTransaction().begin();
            em.persist(doc);
            em.getTransaction().commit();
            em.refresh(doc);
            ok=doc.getId();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return ok;
    }
    
}
