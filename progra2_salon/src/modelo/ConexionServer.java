package modelo;

import Principal.Servidor;
import compartido.Mensaje;
import compartido.TipoMensaje;
import static compartido.TipoMensaje.ORDEN;
import static compartido.TipoMensaje.SALIDA;
import controlador.Controlador;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
        System.out.println("Conexion con el server");
        int num = 0;
        while (this.corre){
            try {
                sleep(1000);
                System.out.println("aaaa");
                
                Mensaje msj;
                if (num == 4) {
                    msj = new Mensaje(SALIDA, null); 
                    this.corre = false;
                } else
                    msj = new Mensaje(ORDEN, null);
                num++;
                this.controlador.getSalida().writeObject(msj);
                
            } catch (InterruptedException ex) { 
            } catch (IOException ex) { 
            }
            
            /*
            Mensaje mensaje;
            try {
                
                System.out.println("Enviando mensaje");  
                mensaje = (Mensaje) this.entrada.readObject();
                System.out.println("Mensaje enviado");
                mensaje = (Mensaje)this.entrada.readObject();
                switch(mensaje.getTipo()) {
                    case ORDEN:
                        break;
                    case SALIDA:
                        break;
                }
                //this.salida.close();
                //this.entrada.close();
                //this.controlador.getCliente().close();
                
            } catch (IOException ex) { System.out.println(""+ex.toString());
            } catch (ClassNotFoundException ex) { }
            */
            //this.corre = false;
        }
    }
    
    
}
