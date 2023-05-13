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
    private ComunicacionSalon comunicionSalon;
    private ComunicacionCocina comunicionCocina;
    private ComunicacionSimulacion comunicionSimulacion;

    public Servidor () {
        this.comunicionSalon = new ComunicacionSalon(this);
        this.comunicionCocina = new ComunicacionCocina(this);
        this.comunicionSimulacion = new ComunicacionSimulacion(this);
        
        this.iniciar();
    }
    
    public void iniciar () {
        try {
            this.server = new ServerSocket(5555);
            this.salon = server.accept();
            //this.cocina = server.accept();
            //this.simulacion = server.accept();
            this.comunicionSalon = new ComunicacionSalon(this);
            //this.comunicionCocina = new ComunicacionCocina(this);
            //this.comunicionSimulacion = new ComunicacionSimulacion(this);
            
            this.comunicionSalon.start();
            
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
