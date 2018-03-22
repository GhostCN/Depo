/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.Utilisateur;
import Interfaces.Iuser;
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
public class UtilisateurDao extends UnicastRemoteObject implements Iuser{
    private EntityManager em;
    public UtilisateurDao() throws RemoteException {
         EntityManagerFactory emf=Persistence.createEntityManagerFactory("Hopital_ServeurPU");
        em=emf.createEntityManager();
    }

    @Override
    public Utilisateur GetUser(String log, String passwd) throws RemoteException {
          Query  query=em.createNamedQuery("Utilisateur.findByGoodUser",Utilisateur.class);
        query.setParameter("login",log);
        query.setParameter("password",passwd);
         Utilisateur user=new Utilisateur();
        user=(Utilisateur)query.getSingleResult();
          if(user!=null)
        {
            return user;
        }
        else {
            return null;
        }

      
    }

    @Override
    public int addUser(Utilisateur user) throws RemoteException {
           int ok=0;
      try 
        {
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
            ok=1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return ok;
    }

    @Override
    public List<Utilisateur> ListeU() throws RemoteException {
      List<Utilisateur> liste=new ArrayList<>();
       Query query=em.createNamedQuery("Utilisateur.findAll");
       liste=query.getResultList();
       return liste;
    }

    @Override
    public String NumUserAuto() throws RemoteException {
        int nb= em.createNamedQuery("Utilisateur.findAll").getResultList().size()+1;
      return "User "+nb;
    }
     
    
    
}
