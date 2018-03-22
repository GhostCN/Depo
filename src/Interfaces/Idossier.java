/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Entities.Dossier;
import Entities.RendezVous;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Ghost CN
 */
public interface Idossier extends Remote {
    public String NumDossier() throws RemoteException;
    public Dossier SearchDossier(String num) throws RemoteException;
     public List<RendezVous> SearchRdv(String num) throws RemoteException;
    public int AddDossier(Dossier d) throws RemoteException;
    
}
