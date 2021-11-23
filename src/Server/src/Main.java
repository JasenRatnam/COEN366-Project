//socket with UDP
import Handler.Server;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Main class of the Handler.Server
 * starts a server thread
 */
public class Main {

    /**
     * Main method
     * run server in a thread
     */
    public static void main(String[] args){
         Server server = new Server();
         Thread serverThread = new Thread(server);
         serverThread.start();

    }
}