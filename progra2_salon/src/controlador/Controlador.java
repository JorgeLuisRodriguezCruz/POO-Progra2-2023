package controlador;

import compartido.Mesa;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import javax.swing.JOptionPane;
import modelo.ConexionServer;
import modelo.Salon;
import vista.MenuConfiguracion;
import vista.MenuSalon;

/*
 * @author rodri
 */

public class Controlador implements ActionListener {
    
    private MenuSalon menuSalon; 
    private MenuConfiguracion configuracion;
    
    private Salon salon;
    
    private Socket cliente;
    
    private ConexionServer conexion;
    
    private ObjectInputStream entrada;
    private ObjectOutputStream salida; 

    public Controlador() {
        this.configuracion = new MenuConfiguracion();
        this.menuSalon = new MenuSalon();
        
        this.salon = new Salon();
        
        //this.conexion = new ConexionServer(this);
        
        this.escuchar();
        
        //this.conectarse(); 
    }
    
    private void conectarse (){
        
        try {
            this.cliente = new Socket("127.0.0.1", 5555);
            
            this.salida =  new ObjectOutputStream(this.cliente.getOutputStream()); 
            this.entrada = new ObjectInputStream(this.cliente.getInputStream());
            
            this.conexion.start();
        } catch (Exception e){ }
    }
    
    private void escuchar (){
        this.configuracion.getConfimar().addActionListener(this);
        
        this.menuSalon.getAgregarProducto().addActionListener(this);
        this.menuSalon.getAgregarIngrediente().addActionListener(this);
        this.menuSalon.getCancelar().addActionListener(this);
        this.menuSalon.getEnviarOrden().addActionListener(this);
        this.menuSalon.getFacturar().addActionListener(this);
        this.menuSalon.getListaIngredientes().addActionListener(this);
        this.menuSalon.getVerIngredientes().addActionListener(this);
        this.menuSalon.getVerMesa().addActionListener(this);
    }
    
    public boolean comprobarNumeroMesas (String strNum){
        try {
            int num = Integer.parseInt(strNum);
            if (num <= 0)
                num = 1/0;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Debe introducir un numero entero mayor que 0", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            return false;
        } 
        return true;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) { 
        if (e.getSource() == this.configuracion.getConfimar()) {
            if (this.comprobarNumeroMesas(this.configuracion.getCantidaMesasEntrada().getText() )){
                this.configuracion.setVisible(false);
                int num = Integer.parseInt( this.configuracion.getCantidaMesasEntrada().getText() );
                this.salon.iniciarMesas(num);
                this.menuSalon.setVisible(true);
            }
            return;
        }
        if (e.getSource() == this.menuSalon.getListaIngredientes()) {
            this.menuSalon.getInformacion().setText( this.salon.getFrabrica().listaDeIngredientes() );
            return;
        }
        if (e.getSource() == this.menuSalon.getVerMesa()) {
            if (this.comprobarNumeroMesas( this.menuSalon.getNumeroMesaEntrada().getText() )){
                int num = Integer.parseInt( this.menuSalon.getNumeroMesaEntrada().getText() );
                Mesa mesaTemporal = this.salon.obtenerMesa(num);
                if (mesaTemporal != null)
                    this.menuSalon.getInformacion().setText(mesaTemporal.datosMesa());
            }
            return;
        }
        if (e.getSource() == null) {
            return;
        }
        if (e.getSource() == null) {
            return;
        }
        if (e.getSource() == null) {
            return;
        }
        if (e.getSource() == null) {
            return;
        }
        if (e.getSource() == null) {
            return;
        }
        if (e.getSource() == null) {
            return;
        }
    }
    
    public Socket getCliente() {
        return cliente;
    }

    public ObjectInputStream getEntrada() {
        return entrada;
    }

    public ObjectOutputStream getSalida() {
        return salida;
    }

    
}
