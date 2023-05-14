package Principal;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/*
 *
 * @author rodri
 */

public class ConexionSimulacion extends Thread {
    private boolean corre;
    private Servidor servidor;
    private ObjectInputStream entrada;
    private ObjectOutputStream salida;
    
    public ConexionSimulacion (Servidor servidor){
        this.servidor = servidor;
        this.corre = true;
    }
        
    private void conectarse () {
        try {
            Socket simulacion = this.servidor.getServer().accept();
            this.servidor.setSimulacion(simulacion);
            this.entrada = new ObjectInputStream(this.servidor.getSalon().getInputStream());
        } catch (Exception e) {}
    }
    
    @Override
    public void run () {
        this.conectarse();
        
        while (this.corre) {
            
            this.corre = false;
        }
    }
    
}
