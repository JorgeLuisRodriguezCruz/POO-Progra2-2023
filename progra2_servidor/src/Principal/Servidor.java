package Principal;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
    
    private ObjectInputStream entradaSalon; 
    private ObjectInputStream entradaCocina;
    private ObjectInputStream entradaSimulacion;
    
    private ObjectOutputStream salidaSalon;
    private ObjectOutputStream salidaCocina;
    private ObjectOutputStream salidaSimulacion;

    public Servidor () { 
        this.conexionSalon = new ConexionSalon(this); 
        this.conexionCocina = new ConexionCocina(this); 
        this.conexionSimulacion = new ConexionSimulacion(this);
         
        this.conectarse();
    }
    
    public void conectarse () {
        try {
            this.server = new ServerSocket(5555);
            this.salon = server.accept();
            
            this.salidaSalon = new ObjectOutputStream(this.salon.getOutputStream());
            this.entradaSalon = new ObjectInputStream(this.salon.getInputStream()); 
            
            this.conexionSalon.start();
            
            this.cocina = server.accept();
            
            this.salidaCocina = new ObjectOutputStream(this.cocina.getOutputStream());
            this.entradaCocina = new ObjectInputStream(this.cocina.getInputStream());
            
            this.conexionCocina.start();
            
            this.simulacion = server.accept(); 
            
            this.salidaSimulacion = new ObjectOutputStream(this.simulacion.getOutputStream());
            this.entradaSimulacion = new ObjectInputStream(this.simulacion.getInputStream());
            
            this.conexionSimulacion.start();
            
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

    public ObjectInputStream getEntradaSalon() {
        return entradaSalon;
    }

    public ObjectOutputStream getSalidaSalon() {
        return salidaSalon;
    }

    public ObjectInputStream getEntradaCocina() {
        return entradaCocina;
    }

    public ObjectOutputStream getSalidaCocina() {
        return salidaCocina;
    }

    public ObjectInputStream getEntradaSimulacion() {
        return entradaSimulacion;
    }

    public ObjectOutputStream getSalidaSimulacion() {
        return salidaSimulacion;
    }
     
}
