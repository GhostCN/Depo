/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Entities.Document;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Ghost CN
 */
public interface Idocument extends Remote {
    public int AddDocument(Document doc) throws RemoteException;
    
}
