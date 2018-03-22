/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Entities.Consultation;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Ghost CN
 */
public interface Iconsultation  extends Remote{
<<<<<<< HEAD
      public int AddConsultation(Consultation cons) throws RemoteException;
=======
    public int AddConsultation(Consultation cons) throws RemoteException;
>>>>>>> origin/master
    public List<Consultation>GetListConsultation(String num)throws RemoteException;
    
}
