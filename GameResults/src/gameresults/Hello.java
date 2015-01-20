/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package gameresults;

import java.rmi.*;
import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 *
 * @author Σταύρος
 */
public interface Hello extends Remote {
    public String sayHello() throws RemoteException;
    
}
