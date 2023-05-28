package Principal;

import compartido.Mensaje;
import static compartido.TipoMensaje.SALIDA;
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
                        //System.out.println("Mensaje de orden"); //System.out.println("\n"+mensaje.getContenido().datosMesa());
                        this.servidor.enviarMensajeServerCocina(mensaje);
                        break;
                        
                    case SALIDA:
                        this.servidor.desconectarSalon();
                        this.corre = false;
                        
                        break;
                    default:
                        System.out.println("Mensaje desconocido"); 
                        break;         
                }
                
            } catch (IOException ex) { 
                System.out.println("aa --- "+ex.toString()+"\n");
            } catch (ClassNotFoundException ex) { 
                System.out.println("sss"+ex.toString());
            } catch (InterruptedException ex) {System.out.println("EYEYEY"); }
        }
    }

    public boolean getCorre() {
        return corre;
    }

    public void setCorre(boolean corre) {
        this.corre = corre;
    }
    
}
