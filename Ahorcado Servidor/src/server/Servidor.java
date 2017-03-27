/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Ahorcado;

/**
 *
 * @author j4v13
 */
public class Servidor {

    public Servidor() throws IOException {
          ServerSocket server = new ServerSocket(3000); 
        while(true) {           
            Socket cliente = server.accept();
            ClienteHilo ch = new ClienteHilo(cliente);
            ch.start();
        }
    }        
    
}

class ClienteHilo extends Thread {
    
    ObjectInputStream reader;
    ObjectOutputStream writer;
    Socket cliente;
    
    public ClienteHilo(Socket cliente) throws IOException {
        this.cliente = cliente;
        reader = new ObjectInputStream(cliente.getInputStream());
        writer = new ObjectOutputStream(cliente.getOutputStream());
    }   

    @Override
    public void run() {         
        try {         
            Ahorcado ahorcado = new Ahorcado();

            writer.writeObject(ahorcado.toString());
            writer.writeObject("Perdiste");
            writer.writeObject(5);
            
            do{                
                String s = (String)reader.readObject();
                System.out.println(s);
                writer.writeObject(ahorcado.intenta(s.charAt(0)));
                if(ahorcado.isLogrado()) 
                    writer.writeObject("Logrado");
                else
                    writer.writeObject("Perdiste");
                writer.writeObject(ahorcado.getIntentos());                
            }while(ahorcado.getIntentos()!=0 && !ahorcado.isLogrado());

            reader.close();
            writer.close();
            cliente.close();
            
        } catch (IOException ex) {
            Logger.getLogger(ClienteHilo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteHilo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}