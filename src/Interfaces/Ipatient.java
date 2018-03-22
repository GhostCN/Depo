/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Entities.Patient;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Ghost CN
 */
public interface Ipatient extends Remote{
    public int AddPatient(Patient pat) throws  RemoteException;
    public String NumPatientAuto() throws RemoteException;
     public List<Patient> ListPatient() throws RemoteException;
    public Patient GetPatient(int num) throws RemoteException;
}
