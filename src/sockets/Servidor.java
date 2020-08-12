/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockets;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author EduardoQSR
 */
public class Servidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        // TODO code application logic here
        try
        {
            ServerSocket serv = new ServerSocket(5432);//crea el servidor
            Socket clienteN = serv.accept();//pausa hasta nueva entrada y lo asigna a un socket
            System.out.println("Servidor Iniciado");

            ObjectInputStream entrada = new ObjectInputStream(clienteN.getInputStream());
            System.out.println("Llego un nuevo cliente");
            System.out.println("Enviando nuevo mensaje");

            String mens = (String) entrada.readObject();//LEE EL OBJETO
            System.out.println("MENSAJE: " + mens);
            ObjectOutputStream resp = new ObjectOutputStream(clienteN.getOutputStream());//indica una salida
            resp.writeObject("hola cliente");
            System.out.println("Mensaje enviado");
            clienteN.close();
            serv.close();
        }catch (IOException ex)
        {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }catch(ClassNotFoundException ex)
        {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
