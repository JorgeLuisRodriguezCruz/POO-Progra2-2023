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
            
            this.salida =  new ObjectOutputStream(this.cliente.getOutputStream()); 
            this.entrada = new ObjectInputStream(this.cliente.getInputStream());
            
            this.conexion.start();
        } catch (Exception e){ }
    }

    public ObjectInputStream getEntrada() {
        return entrada;
    }

    public ObjectOutputStream getSalida() {
        return salida;
    }
    
    
    
}
