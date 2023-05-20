package Principal;

import compartido.Mensaje;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 *
 * @author rodri
 */

public class ConexionSalon extends Thread {
    private boolean corre;
    private Servidor servidor; 
    
    public ConexionSalon (Servidor servidor){
        this.corre = true;
        this.servidor = servidor; 
    }
    
    @Override
    public void run () {
        
        while (this.corre) {
            try {
                sleep(1000); 
                
                Mensaje mensaje = (Mensaje) this.servidor.getEntradaSalon().readObject();
                
                switch(mensaje.getTipo()) {
                    case ORDEN:
                        System.out.println("Mensaje de orden"); 
                        break;
                    case SALIDA:
                        System.out.println("Nos llega una salida"); 
                        this.corre = false;
                        break;
                    default:
                        System.out.println("Mensaje desconocido"); 
                        break;         
                }
                
            } catch (IOException ex) { 
                System.out.println(""+ex.toString());
            } catch (ClassNotFoundException ex) { 
                System.out.println(""+ex.toString());
            } catch (InterruptedException ex) { }
        }
    }
    
}
