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
    
    private ObjectOutputStream salidaSalon;
    private ObjectOutputStream salidaCocina;

    public Servidor () { 
        this.conexionSalon = new ConexionSalon(this); 
        this.conexionCocina = new ConexionCocina(this);
        
        //this.conexionSimulacion = new ComunicacionSimulacion(this);
        
        //this.conexionSalon.conectarse();
        this.conectarse();
    }
    
    public void conectarse () {
        try {
            this.server = new ServerSocket(5555);
            this.salon = server.accept();
            
            System.out.println("Fue aceptado");
            
            this.salidaSalon = new ObjectOutputStream(this.salon.getOutputStream());
            this.entradaSalon = new ObjectInputStream(this.salon.getInputStream()); 
            
            System.out.println("Le damos a start");
            this.conexionSalon.start();
            
            this.cocina = server.accept();
            System.out.println("Aceptaaaaamos a la cocina");
             
            this.salidaCocina = new ObjectOutputStream(this.cocina.getOutputStream());
            this.entradaCocina = new ObjectInputStream(this.cocina.getInputStream());
            
            System.out.println("Se sale y se entra a la cocina");
            this.conexionCocina.start();
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

    public ObjectInputStream getEntradaSalon() {
        return entradaSalon;
    }

    public ObjectOutputStream getSalidaSalon() {
        return salidaSalon;
    }
    
    
    
    
}
