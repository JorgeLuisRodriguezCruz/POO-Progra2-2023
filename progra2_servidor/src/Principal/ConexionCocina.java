package Principal;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 *
 * @author rodri
 */

public class ConexionCocina extends Thread {
    private boolean corre;
    private Servidor servidor;
    
    public ConexionCocina (Servidor servidor){
        this.corre = true;
        this.servidor = servidor;
    }
    
    @Override
    public void run () {
        
        while (this.corre) {
            try {
                sleep(1000);
                System.out.println("Cocina conex");
                        
                //this.corre = false;
            } catch (InterruptedException ex) { 
            }
        }
    }
    
}
