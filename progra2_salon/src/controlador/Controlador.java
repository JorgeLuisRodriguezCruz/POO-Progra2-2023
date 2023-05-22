package controlador;

import compartido.Hamburguesa;
import compartido.Ingrediente;
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
        
        this.conexion = new ConexionServer(this);
        
        this.escuchar();
        
        this.conectarse(); 
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
            //this.menuSalon.getVerIngredientes().addActionListener(this);
        this.menuSalon.getVerMesa().addActionListener(this);
    }
    
    public boolean comprobarNumero (String strNum){
        try {
            int num = Integer.parseInt(strNum);
            if (num <= 0)
                num = 1/0;
        } catch (Exception e) {
            return false;
        } 
        return true;
    }
    
    public boolean comprobarNumeroMesa () {
        if (this.comprobarNumero( this.menuSalon.getNumeroMesaEntrada().getText() )){
            int numero = Integer.parseInt(this.menuSalon.getNumeroMesaEntrada().getText() );
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un numero de mesa valido", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
    }
    
    private void enviarMensaje (Mesa mesa){
        Mensaje mensaje = new Mensaje(TipoMensaje.ORDEN, mesa);
        try {
            this.salida.writeObject(mensaje);
            this.salida.flush();
        } catch (IOException ex) {
            System.out.println(""+ex.getMessage());
        }
    }
    
    public void actualizarPendientes () {
        this.menuSalon.getOrdenes().setText(this.salon.obtenerPendientes());
    }
    
    public void completarOrdenMesaPendiente (int num) {
        Mesa mesa = this.salon.obtenerMesaPendiente(num);
        mesa.setAtendida(true);
        this.actualizarPendientes();
        String texto = this.menuSalon.getOrdenesCompletadas().getText() + mesa.datosMesa();
        this.menuSalon.getOrdenesCompletadas().setText(texto);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) { 
        if (e.getSource() == this.configuracion.getConfimar()) {
            if (this.comprobarNumero(this.configuracion.getCantidaMesasEntrada().getText() )){
                this.configuracion.setVisible(false);
                int num = Integer.parseInt( this.configuracion.getCantidaMesasEntrada().getText() );
                this.salon.iniciarMesas(num);
                this.menuSalon.setVisible(true);
            } else 
                JOptionPane.showMessageDialog(null, "Debe introducir un numero entero mayor que 0", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        if (e.getSource() == this.menuSalon.getListaIngredientes()) {
            this.menuSalon.getInformacion().setText( this.salon.getFrabrica().listaDeIngredientes() );
            return;
        }
        if (e.getSource() == this.menuSalon.getVerMesa()) {
            if (this.comprobarNumeroMesa()){
                int num = Integer.parseInt( this.menuSalon.getNumeroMesaEntrada().getText() );
                Mesa mesaTemporal = this.salon.obtenerMesa(num);
                if (mesaTemporal != null)
                    this.menuSalon.getInformacion().setText(mesaTemporal.datosMesa());
                else {
                    mesaTemporal = this.salon.obtenerMesaPendiente(num);
                    if (mesaTemporal != null)
                        this.menuSalon.getInformacion().setText(mesaTemporal.datosMesa());
                    else 
                        JOptionPane.showMessageDialog(null, "La mesa no esta disponible", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            return;
        }
        if (e.getSource() == this.menuSalon.getAgregarIngrediente()) {
            String ingredienteEntrada = this.menuSalon.getIngredienteEntrada().getText();
            if (ingredienteEntrada.equals("") == false){
                Ingrediente ingrediente = this.salon.getFrabrica().obtenerIngrediente(ingredienteEntrada);
                if (ingrediente != null)
                    this.salon.getFrabrica().agregarIngrediente(ingrediente);
                else
                    JOptionPane.showMessageDialog(null, "Ingrediente invalido, debe elegir entre los disponibles en la lista de ingredientes", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            } else {
                switch (this.menuSalon.getHamburguesasPredeterminadas().getSelectedIndex()){
                    case 1:
                        this.salon.getFrabrica().agregarIngredientes( this.salon.getFrabrica().obtenerHamburguesaPollo().getIngredientes() );
                        break;
                    case 2:
                        this.salon.getFrabrica().agregarIngredientes( this.salon.getFrabrica().obtenerHamburguesaDosCarnes().getIngredientes() );
                        break;
                    case 3:
                        this.salon.getFrabrica().agregarIngredientes( this.salon.getFrabrica().obtenerHamburguesaDobleQueso().getIngredientes() );
                        break;
                }
            } 
            this.menuSalon.getHamburguesasPredeterminadas().setSelectedIndex(0);
            this.menuSalon.getIngredienteEntrada().setText("");
            this.menuSalon.getIngredientes().setText( this.salon.getFrabrica().obtenerHamburguesaAux().ingredientesFormatoDos());
            return;
        }
        /*if (e.getSource() == this.menuSalon.getVerIngredientes()) {
            this.menuSalon.getIngredientes().setText( this.salon.getFrabrica().obtenerHamburguesaAux().ingredientesFormatoDos());
            return;
        }*/
        if (e.getSource() == this.menuSalon.getCancelar()) {
            this.salon.getFrabrica().obtenerHamburguesaPersonalizada();
            this.menuSalon.getIngredientes().setText("Ingredientes:");
            return;
        }
        if (e.getSource() == this.menuSalon.getAgregarProducto()) {
            if (this.comprobarNumeroMesa()) {
                int numeroMesa = Integer.parseInt(this.menuSalon.getNumeroMesaEntrada().getText() );
                Hamburguesa producto = this.salon.getFrabrica().obtenerHamburguesaPersonalizada();
                if (producto.vacia() == false) {
                    Mesa mesa = this.salon.obtenerMesa(numeroMesa);
                    if (mesa != null)
                        mesa.agregarProducto(producto);
                    else
                        JOptionPane.showMessageDialog(null, "La mesa no esta disponible", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                }
            } 
            this.menuSalon.getIngredientes().setText( this.salon.getFrabrica().obtenerHamburguesaAux().ingredientesFormatoDos());
            return;
        }
        if (e.getSource() == this.menuSalon.getEnviarOrden()) {
            if (this.comprobarNumeroMesa()){
                int numeroMesa = Integer.parseInt(this.menuSalon.getNumeroMesaEntrada().getText() );
                Mesa mesa = this.salon.obtenerMesa(numeroMesa);
                if (mesa != null) {
                    if (mesa.mesaVacia()){
                        JOptionPane.showMessageDialog(null, "Debe agregar almenos un producto para enviar una orden", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }
                    this.salon.getMesas().remove(mesa);
                    this.salon.getMesasOrdenEnviada().add(mesa);
                    //Llamar intrucciones que envien mensaje al server y actualice los pedidos pendientes
                    this.enviarMensaje(mesa);
                    this.actualizarPendientes();
                } else
                    JOptionPane.showMessageDialog(null, "La mesa no esta disponible", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            }
            return;
        }
        if (e.getSource() == this.menuSalon.getFacturar()) {
            if (this.comprobarNumeroMesa()) {
                int numeroMesa = Integer.parseInt(this.menuSalon.getNumeroMesaEntrada().getText() );
                Mesa mesa = this.salon.obtenerMesaPendiente(numeroMesa);
                if (mesa != null) {
                    if (mesa.getAtendida()){
                        this.menuSalon.getInformacion().setText( mesa.obtenerFactura()  );
                        this.salon.getMesasOrdenEnviada().remove(mesa);
                        mesa.vaciar();
                        mesa.setAtendida(false);
                        this.salon.getMesas().add(mesa);
                    } else
                        JOptionPane.showMessageDialog(null, "El pedido de la mesa aun no se ha completado", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                } else
                    JOptionPane.showMessageDialog(null, "La mesa no ha enviado su orden", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            }
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
