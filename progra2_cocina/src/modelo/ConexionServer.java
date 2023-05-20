package modelo;

import controlador.Controlador;
import java.util.logging.Level;
import java.util.logging.Logger;

/* 
 * @author rodri
 */

public class ConexionServer extends Thread {
    
    private boolean corre;
    private Controlador controlador;

    public ConexionServer (Controlador controlador) {
        this.corre = true;
        this.controlador = controlador;
    }
    
    @Override
    public void run () {
        
        System.out.println("Conexion con el server"); 
        
        while (this.corre){
            try {
                sleep(1000);
                System.out.println("pOOOq"); 
            } catch (InterruptedException ex) { 
            }
        }
    }
    
}
