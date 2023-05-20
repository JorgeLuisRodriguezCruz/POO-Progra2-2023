package Principal;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 *
 * @author rodri
 */

public class ConexionSimulacion extends Thread {
    private boolean corre;
    private Servidor servidor;
    private ObjectInputStream entrada;
    private ObjectOutputStream salida;
    
    public ConexionSimulacion (Servidor servidor){
        this.servidor = servidor;
        this.corre = true;
    }
    
    @Override
    public void run () { 
        
        while (this.corre) { 
            try { 
                sleep(1000);
                System.out.println("ConxSimu"); 
                this.corre = false; 
            } catch (InterruptedException ex) {
                System.out.println(""+ex.getMessage());
            }
                
        }
    }
}
