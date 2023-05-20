package Principal;

import compartido.Mensaje;
import static compartido.TipoMensaje.ORDEN;
import static compartido.TipoMensaje.SALIDA;
import java.io.IOException;
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
                
            } catch (InterruptedException ex) { 
            } catch (ClassNotFoundException ex) {
            } catch (IOException ex) {  
            }
        }
    }
    
}
