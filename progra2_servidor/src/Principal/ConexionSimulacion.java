package Principal;

import compartido.Mensaje;
import static compartido.TipoMensaje.ORDEN;
import java.io.IOException;
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
    
    public ConexionSimulacion (Servidor servidor){
        this.servidor = servidor;
        this.corre = true;
    }

    public boolean getCorre() {
        return corre;
    }

    public void setCorre(boolean corre) {
        this.corre = corre;
    }
    
    @Override
    public void run () { 
        System.out.println("ConxSimu"); 
        while (this.corre) { 
            try { 
                sleep(1000);
                
                Mensaje mensaje = (Mensaje) this.servidor.getEntradaSimulacion().readObject();
                
                switch (mensaje.getTipo()) {
                    case ORDEN:
                        System.out.println("Orden conx simu");
                        //System.out.println("\n"+mensaje.getContenido().datosMesa());
                        this.servidor.enviarMensajeServerSalon(mensaje);
                        break;
                            
                    case SALIDA:
                        System.out.println("Salida conx simu");
                        this.servidor.desconectarSimulacion();
                        this.corre = false;
                        break;
                            
                    default:
                        System.out.println("Error conx en simulacion");
                        this.corre = false;
                        break;
                }
                
                
            } catch (InterruptedException ex) {
                System.out.println(""+ex.getMessage());
            } catch (IOException ex) {
                System.out.println(""+ex.getMessage());
            } catch (ClassNotFoundException ex) {
                System.out.println(""+ex.getMessage());
            }
                
        }
    }
}
