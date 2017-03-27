/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ahorcado.servidor;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import server.Servidor;

/**
 *
 * @author j4v13
 */
public class AhorcadoServidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            new Servidor();
        } catch (IOException ex) {
            Logger.getLogger(AhorcadoServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
