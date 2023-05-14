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
    private JScrollPane scrollOrdenes;
    private JScrollPane scrollOrdeComple;
    
    private JLabel hamburguesasDisponible;
    private JLabel ingrediente;
    private JLabel numeroMesa;
    private JLabel ordenesPendientes;
    private JLabel ordenesProcesadas;
    
    private JTextField numeroMesaEntrada;
    private JTextField ingredienteEntrada;
    
    private JButton agregarIngrediente;
    private JButton verIngredientes;
    private JButton agregarProducto;
    private JButton enviarOrden;
    private JButton cancelar;
    private JButton facturar;
    private JButton verMesa;
    
    private JComboBox hamburguesasPredeterminadas;

    public MenuSalon() {
        super("Menu salon");
        
        this.fondoHamburguesa = new JPanel();
        this.ordenes = new JTextArea();
        this.ordenesCompletadas = new JTextArea();
        this.scrollOrdenes = new JScrollPane(this.ordenes, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        this.scrollOrdeComple = new JScrollPane(this.ordenesCompletadas, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        
        this.agregarIngrediente = new JButton("Agregar ingrediente");
        this.verIngredientes = new JButton("Ingredientes");
        this.agregarProducto = new JButton("Añadir producto");
        this.enviarOrden = new JButton("Enviar orden");
        this.cancelar = new JButton("Cancelar");
        this.facturar = new JButton("Facturar");
        this.verMesa = new JButton("Ver mesa");
        
        this.hamburguesasDisponible = new JLabel("Hamburguesas disponibles:");
        this.ingrediente = new JLabel("Ingrediente:");
        this.ordenesPendientes = new JLabel("Ordenes pendientes:");
        this.ordenesProcesadas = new JLabel("Ordenes procesadas:");
        this.numeroMesa = new JLabel("Numero de mesa:");
        
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
        this.ordenesCompletadas.setLineWrap(true); 
        this.scrollOrdenes.setBounds(540, 200, 180, 400);
        this.scrollOrdeComple.setBounds(740, 200, 180, 400);
        
        this.enviarOrden.setBounds(20, 160, 140, 20);
        this.enviarOrden.setFocusable(false);
        this.facturar.setBounds(190, 160, 100, 20);
        this.facturar.setFocusable(false); 
        this.agregarIngrediente.setBounds(20, 90, 160, 20);
        this.agregarIngrediente.setFocusable(false); 
        this.verIngredientes.setBounds(200, 90, 160, 20);
        this.verIngredientes.setFocusable(false);
         
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
        this.setSize(1080, 720); 
        this.setResizable(false);
        this.setLayout(null);
        this.setVisible(true);
        
    }
    
    
}
