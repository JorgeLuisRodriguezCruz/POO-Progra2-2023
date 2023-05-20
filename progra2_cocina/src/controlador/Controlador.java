package controlador;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import modelo.ConexionServer;

/*
 * @author rodri
 */

public class Controlador {
    
    private Socket cliente;
    
    private ConexionServer conexion;
    
    private ObjectInputStream entrada;
    private ObjectOutputStream salida;

    public Controlador() {
        this.conexion = new ConexionServer(this);
        
        this.conectarse();
    }
    
    public void conectarse () {
        try {
            this.cliente = new Socket("127.0.0.1", 5555);
            
            System.out.println("Nos conectamos panas");
            
            this.salida =  new ObjectOutputStream(this.cliente.getOutputStream()); 
            this.entrada = new ObjectInputStream(this.cliente.getInputStream());
            
            System.out.println("Tenemos salida y entrada");
            
            this.conexion.start();
        } catch (Exception e){ }
    }
    
}
