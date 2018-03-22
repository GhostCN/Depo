/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Entities.Utilisateur;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Ghost CN
 */
public interface Iuser extends Remote{
     public Utilisateur GetUser(String log,String passwd) throws RemoteException;
    public int addUser(Utilisateur user) throws RemoteException;
<<<<<<< HEAD
      public List<Utilisateur> ListeU() throws RemoteException;
     public String NumUserAuto() throws RemoteException;
=======
    public List<Utilisateur> ListeU() throws RemoteException;
     public String NumUserAuto() throws RemoteException;
    
>>>>>>> origin/master
}
