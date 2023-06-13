package controlador;

import compartido.Mensaje;
import compartido.Mesa;
import compartido.TipoMensaje;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Cocina;
import modelo.ConexionServer;
import vista.MenuCocina;

/*
 * @author rodri
 */

public class Controlador implements ActionListener {
    
    private MenuCocina menuCocina;
    
    private Cocina cocina;
    
    private Socket cliente;
    
    private ConexionServer conexion;
    
    private ObjectInputStream entrada;
    private ObjectOutputStream salida;

    public Controlador() {
        this.menuCocina = new MenuCocina(this);
        this.cocina = new Cocina();
        this.conexion = new ConexionServer(this);
        
        this.escuchar();
        
        this.conectarse();
    }
    
    public void conectarse () {
        try {
            this.cliente = new Socket("127.0.0.1", 5566);
            
            this.salida =  new ObjectOutputStream(this.cliente.getOutputStream()); 
            this.entrada = new ObjectInputStream(this.cliente.getInputStream());
            
            this.conexion.start();
        } catch (Exception e){ }
    }

    public void desconectar () {
        Mensaje mensaje = new Mensaje(TipoMensaje.SALIDA, null);
        
        try {
            this.conexion.setCorre(false);
            this.salida.writeObject(mensaje);
            this.salida.flush();
            
            this.salida.close();
            this.entrada.close();
            this.cliente.close();
            
        } catch (IOException ex) {
            System.out.println(""+ex.getMessage());
        }
        
    }
    
    public void enviarMensaje (Mesa mesa) {
        Mensaje mensaje = new Mensaje(TipoMensaje.NOTIFICACION, mesa); 
        try {
            this.salida.writeObject(mensaje);
            this.salida.flush(); 
        } catch (IOException ex) {
            System.out.println(""+ex.getMessage());
        } 
    }
    
    public void actualizarOrdenes () {
        this.menuCocina.getOrdenesSalida().setText( this.cocina.obtenerOrdenes() );
    }
    
    public void agregarOrden (Mesa mesa) {
        JOptionPane.showMessageDialog(null, "Se ha agrega la orden de mesa #"+mesa.getNumero(), "Notificacion", JOptionPane.INFORMATION_MESSAGE);
        this.cocina.agregarOrden(mesa);
        this.actualizarOrdenes();
    }
    
    private void escuchar () {
        this.menuCocina.getCompletar().addActionListener(this);
        this.menuCocina.getCompletarAleartorio().addActionListener(this);
    }
    
    private boolean comprobarNumMesaEntrada () {
        String numMesa = this.menuCocina.getNumeroMesaEntrada().getText();
        try {
            int num = Integer.parseInt(numMesa);
            if (num <= 0)
                num = 1/0;
        } catch (Exception e) {
            return false;
        } 
        return true;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.menuCocina.getCompletar()){
            if(this.comprobarNumMesaEntrada()){
                int numMesa = Integer.parseInt( this.menuCocina.getNumeroMesaEntrada().getText() );
                //System.out.println("Entrada num = "+ numMesa);
                Mesa mesa = this.cocina.obtenerMesa(numMesa);
                if (mesa != null){
                    this.cocina.removerOrden(mesa);
                    this.actualizarOrdenes();
                    this.enviarMensaje(mesa);
                } else
                    JOptionPane.showMessageDialog(null, "No se ha encontrado la orden", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            } else 
                JOptionPane.showMessageDialog(null, "Debe introducir el numero de la mesa de una orden", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        if (e.getSource() == this.menuCocina.getCompletarAleartorio()){
            Mesa mesa = this.cocina.obtenerMesaAleatoria();
            if (mesa != null){
                this.cocina.removerOrden(mesa);
                this.actualizarOrdenes();
                this.enviarMensaje(mesa);
                
            } else
                JOptionPane.showMessageDialog(null, "No se ha encontrado ninguna orden", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            
            return;
        }
        
    }
    
    public ObjectInputStream getEntrada() {
        return entrada;
    }

    public ObjectOutputStream getSalida() {
        return salida;
    }

   
    
}
