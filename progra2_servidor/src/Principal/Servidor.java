package Principal;

import compartido.Mensaje;
import compartido.Mesa;
import compartido.TipoMensaje;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author rodri
 */

public class Servidor {
    
    private ServerSocket serverSalon;
    private ServerSocket serverCocina;
    private ServerSocket serverSimulacion;
    
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
            this.serverSalon = new ServerSocket(5555);
            this.salon = serverSalon.accept();
            
            this.salidaSalon = new ObjectOutputStream(this.salon.getOutputStream());
            this.entradaSalon = new ObjectInputStream(this.salon.getInputStream()); 
            
            this.conexionSalon.start();
            
            this.serverCocina = new ServerSocket(5566);
            this.cocina = serverCocina.accept();
            
            this.salidaCocina = new ObjectOutputStream(this.cocina.getOutputStream());
            this.entradaCocina = new ObjectInputStream(this.cocina.getInputStream());
            
            this.conexionCocina.start();
            
            System.out.println("Aceptando"); 
            this.serverSimulacion = new ServerSocket(5577);
            this.simulacion = serverSimulacion.accept(); 
            
            System.out.println("Aceptanda la simu"); 
                //this.salidaSimulacion = new ObjectOutputStream(this.simulacion.getOutputStream());
            this.entradaSimulacion = new ObjectInputStream(this.simulacion.getInputStream());
            
            System.out.println("Creada la entrada simu"); 
            this.conexionSimulacion.start();
            
        } catch (Exception e) {
        }
    }

    public void enviarMensajeServerSalon (Mensaje mensaje) {
        if (this.conexionSalon.getCorre() == false){
            JOptionPane.showMessageDialog(null, "El salon esta desconectado", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        try {
            this.salidaSalon.writeObject(mensaje);
            this.salidaSalon.flush();
        } catch (IOException ex) {
            System.out.println("msj -> Salon\n"+ex.getMessage());
        }
    }
    
    public void enviarMensajeServerCocina (Mensaje mensaje) {
        if (this.conexionCocina.getCorre() == false){
            JOptionPane.showMessageDialog(null, "La cocina esta desconectado", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        try {
            this.salidaCocina.writeObject(mensaje);
            this.salidaCocina.flush();
        } catch (IOException ex) {
            System.out.println("msj -> Cocina\n"+ex.getMessage());
        }
    }
    
    public void desconectarSalon () {
        try {
            this.salidaSalon.close();
            this.entradaSalon.close();
            this.serverSalon.close();
            
            this.conexionSalon.setCorre(false);
            
        } catch (IOException ex) { 
            System.out.println(""+ex.getMessage());
        }
    }
    
    public void descconectarCocina () {
        try {
            this.salidaCocina.close();
            this.entradaCocina.close();
            this.serverCocina.close();
            
            this.conexionCocina.setCorre(false);
            
        } catch (IOException ex) { 
            System.out.println(""+ex.getMessage());
        }
    }
    
    public void desconectarSimulacion () {
        try {
                //this.salidaSimulacion.close();
            this.entradaSimulacion.close();
            this.serverSimulacion.close();
            
            this.conexionSimulacion.setCorre(false);
            
        } catch (IOException ex) { 
            System.out.println(""+ex.getMessage());
        }
        
    }
    
    public ServerSocket getServerSalon() {
        return serverSalon;
    }
    
    public ServerSocket getServerCocina () {
        return this.serverCocina;
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
