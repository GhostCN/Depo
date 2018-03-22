/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Entities.RendezVous;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Ghost CN
 */
public interface IrendezVous extends Remote{
<<<<<<< HEAD
       public int AddRv(RendezVous rv) throws RemoteException;
      public List<RendezVous> ListeRV() throws RemoteException;
        public String NumRvAuto() throws RemoteException;
=======
      public int AddRv(RendezVous rv) throws RemoteException;
      public List<RendezVous> ListeRV() throws RemoteException;
      public String NumRvAuto() throws RemoteException;
    
>>>>>>> origin/master
}
