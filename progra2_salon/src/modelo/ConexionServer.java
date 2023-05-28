package modelo;

import compartido.Mensaje;
import static compartido.TipoMensaje.ORDEN;
import static compartido.TipoMensaje.SALIDA;
import controlador.Controlador;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * @author rodri
 */

public class ConexionServer extends Thread {
    
    private boolean corre;
    private Controlador controlador; 

    public ConexionServer(Controlador controlador) {
        this.corre = true;
        this.controlador = controlador; 
    }
    
    @Override
    public void run () {
        
        while (this.corre){
            try {
                sleep(1000);
                //System.out.println("Salon");
                
                Mensaje mensaje = (Mensaje) this.controlador.getEntrada().readObject();
                
                switch(mensaje.getTipo()) {
                    case ORDEN:
                        System.out.println("Mensaje de orden"); 
                        this.controlador.agregarOrden( mensaje.getContenido() );
                        break;
                        
                    case NOTIFICACION:
                        this.controlador.completarOrdenMesaPendiente(mensaje.getContenido().getNumero());
                        break;
                        
                    case SALIDA:
                        this.corre = false;
                        break;
                    default:
                        System.out.println("Mensaje desconocido"); 
                        break;         
                }
                /*
                Mensaje msj;
                if (num == 40) {
                    msj = new Mensaje(SALIDA, null); 
                    this.corre = false;
                } else
                    msj = new Mensaje(ORDEN, null);
                num++;
                this.controlador.getSalida().writeObject(msj);*/
                
                
            } catch (InterruptedException ex) { 
            } catch (IOException ex) { 
            } catch (ClassNotFoundException ex) {
            }
        }
    }

    public void setCorre(boolean corre) {
        this.corre = corre;
    }
    
}
