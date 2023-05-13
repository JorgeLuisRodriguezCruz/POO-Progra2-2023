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

public class ComunicacionSalon extends Thread {
    private boolean corre;
    private Servidor servidor;
    private ObjectInputStream entrada;
    private ObjectOutputStream salida;
    
    public ComunicacionSalon (Servidor servidor){
        this.corre = true;
        this.servidor = servidor;
        try {
            this.entrada = new ObjectInputStream(this.servidor.getSalon().getInputStream());
            this.salida = new ObjectOutputStream(this.servidor.getSalon().getOutputStream());
        } catch (Exception e) {}
    }
    
    
    @Override
    public void run () {
        
        while (this.corre) {
            Mensaje mensaje;
            try {
                mensaje = (Mensaje)this.entrada.readObject();
                switch(mensaje.getTipo()) {
                    case NOTIFICACION:
                        break;
                    case ORDEN:
                        break;
                }
            } catch (IOException ex) { 
                System.out.println(""+ex.toString());
            } catch (ClassNotFoundException ex) { 
                System.out.println(""+ex.toString());
            }  
            this.corre = false;
        }
    }
    
}
