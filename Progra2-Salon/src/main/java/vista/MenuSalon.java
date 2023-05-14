package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.ScrollPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/*
 * @author rodri
 */

public class MenuSalon extends JFrame{
    private JPanel fondoHamburguesa;
    
    private JTextArea ordenes;
    private JTextArea ordenesCompletadas; 
    private JTextArea ingredientes;
    private JTextArea informacion;
    
    private JScrollPane scrollOrdenes;
    private JScrollPane scrollOrdeComple;
    private JScrollPane scrollIngredientes;
    private JScrollPane scrollInformacion;
    
    private JLabel hamburguesasDisponible;
    private JLabel ingrediente;
    private JLabel numeroMesa;
    private JLabel ordenesPendientes;
    private JLabel ordenesProcesadas;
    private JLabel informacionMostrar;
    
    private JTextField numeroMesaEntrada;
    private JTextField ingredienteEntrada;
    
    private JButton agregarIngrediente;
    private JButton verIngredientes;
    private JButton agregarProducto;
    private JButton enviarOrden;
    private JButton cancelar;
    private JButton facturar;
    private JButton verMesa;
    private JButton listaIngredientes;
    
    private JComboBox hamburguesasPredeterminadas;

    public MenuSalon() {
        super("Salon");
        
        this.fondoHamburguesa = new JPanel();
        
        this.ordenes = new JTextArea();
        this.ordenesCompletadas = new JTextArea();
        this.ingredientes = new JTextArea();
        this.informacion = new JTextArea();
        
        this.scrollOrdenes = new JScrollPane(this.ordenes, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        this.scrollOrdeComple = new JScrollPane(this.ordenesCompletadas, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        this.scrollIngredientes = new JScrollPane(this.ingredientes, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        this.scrollInformacion = new JScrollPane(this.informacion, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        
        this.agregarIngrediente = new JButton("Agregar ingrediente/s");
        this.verIngredientes = new JButton("Ver ingredientes");
        this.agregarProducto = new JButton("Añadir producto");
        this.enviarOrden = new JButton("Enviar orden");
        this.cancelar = new JButton("Cancelar");
        this.facturar = new JButton("Facturar");
        this.verMesa = new JButton("Ver mesa");
        this.listaIngredientes = new JButton("Lista ingredientes");
        
        this.hamburguesasDisponible = new JLabel("Hamburguesas disponibles:");
        this.ingrediente = new JLabel("Ingrediente:");
        this.ordenesPendientes = new JLabel("Ordenes pendientes:");
        this.ordenesProcesadas = new JLabel("Ordenes procesadas:");
        this.numeroMesa = new JLabel("Numero de mesa:");
        this.informacionMostrar = new JLabel("Informacion:");
        
        this.ingredienteEntrada = new JTextField();
        this.numeroMesaEntrada = new JTextField();
        
        this.hamburguesasPredeterminadas = new JComboBox();
        
        this.iniciarComponentes();
        this.ventana();
    }
    
    public void iniciarComponentes () {
        this.fondoHamburguesa.setBackground(Color.LIGHT_GRAY);
        this.fondoHamburguesa.setBounds(20, 200, 500, 300);
        this.fondoHamburguesa.setLayout(null);
        
        this.ordenes.setLineWrap(true);
        this.ordenes.setEditable(false);
        this.ordenesCompletadas.setLineWrap(true); 
        this.ordenesCompletadas.setEditable(false);
        this.ingredientes.setLineWrap(true); 
        this.ingredientes.setEditable(false);
        this.informacion.setLineWrap(true); 
        this.informacion.setEditable(false);
        
        this.scrollOrdenes.setBounds(540, 200, 180, 300);
        this.scrollOrdeComple.setBounds(740, 200, 180, 300);
        this.scrollIngredientes.setBounds(20, 130, 340, 100);
        this.scrollInformacion.setBounds(540, 40, 380, 100);
        
        this.enviarOrden.setBounds(20, 110, 140, 20);
        this.enviarOrden.setFocusable(false);
        this.facturar.setBounds(190, 110, 100, 20);
        this.facturar.setFocusable(false); 
        this.agregarIngrediente.setBounds(20, 90, 160, 20);
        this.agregarIngrediente.setFocusable(false); 
        this.verIngredientes.setBounds(200, 90, 160, 20);
        this.verIngredientes.setFocusable(false);        
        this.verMesa.setBounds(340, 70, 160, 20);
        this.verMesa.setFocusable(false);
        this.listaIngredientes.setBounds(340, 110, 160, 20);
        this.listaIngredientes.setFocusable(false);
         
        this.agregarProducto.setBounds(20, 260, 160, 20);
        this.agregarProducto.setFocusable(false);
        this.cancelar.setBounds(200, 260, 160, 20);
        this.cancelar.setFocusable(false);
        
        this.hamburguesasDisponible.setBounds(20, 20, 200, 20);
        this.hamburguesasDisponible.setFont(new Font("", Font.BOLD, 14)); 
        this.ingrediente.setBounds(20, 50, 120, 20); 
        this.ingrediente.setFont(new Font("", Font.BOLD, 14));
        this.ordenesPendientes.setBounds(540, 160, 160, 20); 
        this.ordenesPendientes.setFont(new Font("", Font.BOLD, 12));
        this.ordenesProcesadas.setBounds(740, 160, 160, 20); 
        this.ordenesProcesadas.setFont(new Font("", Font.BOLD, 12));
        this.numeroMesa.setBounds(20, 40, 160, 20); 
        this.numeroMesa.setFont(new Font("", Font.BOLD, 14));
        this.informacionMostrar.setBounds(340, 40, 160, 20); 
        this.informacionMostrar.setFont(new Font("", Font.BOLD, 14));
        
        this.hamburguesasPredeterminadas.addItem(" ");
        this.hamburguesasPredeterminadas.addItem("Pollo");
        this.hamburguesasPredeterminadas.addItem("Dos carnes");
        this.hamburguesasPredeterminadas.addItem("Doble queso"); 
        this.hamburguesasPredeterminadas.setBounds(380, 20, 100, 20);
        this.hamburguesasPredeterminadas.setFocusable(false);
        
        this.ingredienteEntrada.setBounds(380, 50, 100, 20);
        this.numeroMesaEntrada.setBounds(190, 40, 100, 20);
        
        this.fondoHamburguesa.add(this.hamburguesasDisponible);
        this.fondoHamburguesa.add(this.hamburguesasPredeterminadas);
        this.fondoHamburguesa.add(this.ingrediente);
        this.fondoHamburguesa.add(this.ingredienteEntrada);
        this.fondoHamburguesa.add(this.agregarIngrediente);
        this.fondoHamburguesa.add(this.verIngredientes);
        this.fondoHamburguesa.add(this.agregarProducto);
        this.fondoHamburguesa.add(this.cancelar);
        this.fondoHamburguesa.add(this.scrollIngredientes);
        this.add(this.verMesa);
        this.add(this.listaIngredientes);
        this.add(this.informacionMostrar);
        this.add(this.scrollInformacion); 
        this.add(this.numeroMesaEntrada);
        this.add(this.enviarOrden);
        this.add(this.facturar); 
        this.add(this.ordenesPendientes);
        this.add(this.ordenesProcesadas);
        this.add(this.numeroMesa);
        this.add(this.scrollOrdenes);
        this.add(this.scrollOrdeComple);
        this.add(this.fondoHamburguesa);
    }
    
    public void ventana () {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(Color.LIGHT_GRAY);
        this.setSize(960, 580); 
        this.setResizable(false);
        this.setLayout(null);
        this.setVisible(true);
        
    }

    public JButton getAgregarIngrediente() {
        return agregarIngrediente;
    }

    public JButton getVerIngredientes() {
        return verIngredientes;
    }

    public JButton getAgregarProducto() {
        return agregarProducto;
    }

    public JButton getEnviarOrden() {
        return enviarOrden;
    }

    public JButton getCancelar() {
        return cancelar;
    }

    public JButton getFacturar() {
        return facturar;
    }

    public JButton getVerMesa() {
        return verMesa;
    }

    public JButton getListaIngredientes() {
        return listaIngredientes;
    }

    public JTextArea getOrdenes() {
        return ordenes;
    }

    public JTextArea getOrdenesCompletadas() {
        return ordenesCompletadas;
    }

    public JTextArea getIngredientes() {
        return ingredientes;
    }

    public JTextArea getInformacion() {
        return informacion;
    }

    public JTextField getNumeroMesaEntrada() {
        return numeroMesaEntrada;
    }

    public JTextField getIngredienteEntrada() {
        return ingredienteEntrada;
    }

    public JComboBox getHamburguesasPredeterminadas() {
        return hamburguesasPredeterminadas;
    }
    
    
    
    
}
