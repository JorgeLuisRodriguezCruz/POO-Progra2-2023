package modelo;

import compartido.Mensaje;
import controlador.Controlador;
import java.io.IOException; 

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
        
        while (this.corre){
            try {
                sleep(1000);
                //System.out.println("pOOOq");
                
                Mensaje mensaje = (Mensaje) this.controlador.getEntrada().readObject();
                
                switch(mensaje.getTipo()) {
                    case ORDEN:
                        System.out.println("Mensaje de orden"); 
                        this.controlador.agregarOrden(mensaje.getContenido());
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
            } catch (IOException ex) { 
            } catch (ClassNotFoundException ex) { 
            }
        }
    }
    
}
