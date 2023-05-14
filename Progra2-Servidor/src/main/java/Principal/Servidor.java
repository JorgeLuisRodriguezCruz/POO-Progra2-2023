package Principal;

import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author rodri
 */

public class Servidor {
    private ServerSocket server;
    private Socket salon;
    private Socket cocina;
    private Socket simulacion;
    private ConexionSalon conexionSalon;
    private ConexionCocina conexionCocina;
    private ConexionSimulacion conexionSimulacion;

    public Servidor () { 
        this.conectarse();
        
        this.conexionSalon = new ConexionSalon(this);
        //this.conexionCocina = new ComunicacionCocina(this);
        //this.conexionSimulacion = new ComunicacionSimulacion(this);
        
        this.conexionSalon.start();
    }
    
    public void conectarse () {
        try {
            this.server = new ServerSocket(5555);
            this.salon = server.accept();
            //this.cocina = server.accept();
            //this.simulacion = server.accept(); 
            
        } catch (Exception e) {
        }
    }
    
    public ServerSocket getServer() {
        return server;
    }
    
    public Socket getSalon() {
        return salon;
    }

    public Socket getCocina() {
        return cocina;
    }

    public Socket getSimulacion() {
        return simulacion;
    }

    public void setSimulacion(Socket simulacion) {
        this.simulacion = simulacion;
    }
    
    
}
