/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockets;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author EduardoQSR
 */
public class Cliente {
    public static void main(String[] args)
    {
        try
        {
            Socket cli= new Socket("192.168.0.109", 5432);
            ObjectOutputStream mens = new ObjectOutputStream(cli.getOutputStream());
            mens.writeObject("Soy el cliente 1");

            ObjectInputStream entrada = new ObjectInputStream(cli.getInputStream());
            String mens2 = (String) entrada.readObject();
            System.out.println("MENSAJE SERVIDOR: " + mens2);
            cli.close();
            System.out.println("CLIENTE 1 SALIENDO");
            System.out.println("CONEXIÓN CERRADA");
        }catch (IOException ex)
        {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }catch(ClassNotFoundException ex)
        {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
