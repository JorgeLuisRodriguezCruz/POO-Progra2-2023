package controlador;

import compartido.FabricaHamburguesa;
import compartido.Mensaje;
import compartido.Mesa;
import compartido.TipoMensaje;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Simulador;
import vista.MenuSimulacion;

/*
 * @author rodri
 */

public class Controlador implements ActionListener { 
    
    private MenuSimulacion menuSimulacion;
    
    private FabricaHamburguesa fabrica;
    
    private Simulador simulador;
    
    private Socket cliente;
    
    private ObjectOutputStream salida;

    public Controlador() {
        this.menuSimulacion = new MenuSimulacion(this);
        this.fabrica = new FabricaHamburguesa();
        this.simulador = new Simulador(this);
        
        this.escuchar();
        this.conectarse();
    }
    
    private void escuchar () {
        this.menuSimulacion.getApager().addActionListener(this);
        this.menuSimulacion.getEncender().addActionListener(this);
        
            //this.simulador.start();
    }
    
    private void conectarse () {
        
        try {
            this.cliente = new Socket("127.0.0.1", 5577);
            
            this.salida =  new ObjectOutputStream(this.cliente.getOutputStream());
            
            this.simulador.start();
            
        } catch (Exception e){ }
    }
    
    public void desconectarse () { 
        Mensaje mensaje = new Mensaje(TipoMensaje.SALIDA, null);
        
        try {
            this.simulador.setCorre(false);
            this.salida.writeObject(mensaje);
            this.salida.flush();
            
            this.salida.close(); 
            this.cliente.close();
            
        } catch (IOException ex) {
            System.out.println("sim desconec -- "+ex.getMessage());
        }
    }
    
    public void enviarOrden (Mesa mesa) {
        Mensaje mensaje = new Mensaje(TipoMensaje.ORDEN, mesa);
        
        try {
            this.salida.writeObject(mensaje);
            this.salida.flush();
            
        } catch (IOException ex) {
            System.out.println("enviando orden -- "+ex.getMessage());
        }
    }
    
    private void apagar () {
        this.simulador.apagar();
    }

    private void encender () {
        this.simulador.encender();
    }

    public FabricaHamburguesa getFabrica() {
        return fabrica;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) { 
        if (e.getSource() == menuSimulacion.getApager()){
            this.apagar();
            return;
        }
        if (e.getSource() == menuSimulacion.getEncender()){
            this.encender();
            return;
        }
    }
    
    
    
    
}
