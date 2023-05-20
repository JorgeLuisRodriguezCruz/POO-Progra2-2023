package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/*
 * @author rodri
 */

public class MenuCocina extends JFrame {
     
    private JLabel numeroMesa;
    private JLabel pendientes;
    
    private JTextField numeroMesaEntrada;
    
    private JButton completar;
    private JButton completarAleartorio; 
    
    private JTextArea ordenesSalida;
    private JScrollPane scrollOrdenesSalida;

    public MenuCocina() {
        super ("Menu cocina");
        
        this.numeroMesa = new JLabel("Numero de mesa:");
        this.pendientes = new JLabel("Ordenes pendientes");
        
        this.numeroMesaEntrada = new JTextField();
        
        this.completar = new JButton("Completar");
        this.completarAleartorio = new JButton("Completar aleatorio");
        
        this.ordenesSalida = new JTextArea();
        
        this.scrollOrdenesSalida = new JScrollPane(this.ordenesSalida, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        
        this.iniciarComponentes();
        this.iniciarVentana();
    }
    
    private void iniciarComponentes () {
        int distanciaBaseX = 20, distanciaBaseY = 20;
        
        this.numeroMesa.setBounds(distanciaBaseX, distanciaBaseY, 140, 20);
        this.numeroMesa.setFont(new Font("", Font.BOLD, 14));
        this.pendientes.setBounds(distanciaBaseX, distanciaBaseY + 100, 160, 20);
        this.pendientes.setFont(new Font("", Font.BOLD, 14));
        
        this.numeroMesaEntrada.setBounds(distanciaBaseX + 160, distanciaBaseY, 100, 20);
        
        this.completar.setBounds(distanciaBaseX, distanciaBaseY + 40, 100, 20);
        this.completar.setFocusable(false);
        this.completarAleartorio.setBounds(distanciaBaseX + 120, distanciaBaseY + 40, 160, 20);
        this.completarAleartorio.setFocusable(false);
        
        this.ordenesSalida.setLineWrap(true);
        
        this.scrollOrdenesSalida.setBounds(distanciaBaseX, distanciaBaseY + 140, 440, 150);
        
        this.add(this.numeroMesa);
        this.add(this.pendientes);
        this.add(this.numeroMesaEntrada);
        this.add(this.completar);
        this.add(this.completarAleartorio);
        this.add(this.scrollOrdenesSalida);
         
    }
    
    private void iniciarVentana () {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(Color.LIGHT_GRAY);
        this.setSize(500, 400); 
        this.setResizable(false);
        this.setLayout(null);
        this.setVisible(true);
    }

    public JTextField getNumeroMesaEntrada() {
        return numeroMesaEntrada;
    }

    public JButton getCompletar() {
        return completar;
    }

    public JButton getCompletarAleartorio() {
        return completarAleartorio;
    }

    public JTextArea getOrdenesSalida() {
        return ordenesSalida;
    }
    
    
}
