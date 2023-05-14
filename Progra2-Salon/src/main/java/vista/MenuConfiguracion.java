package vista;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/*
 * @author rodri
 */

public class MenuConfiguracion extends JFrame {
    private JLabel cantidadMesas;
    
    private JTextField cantidaMesasEntrada;
    
    private JButton confimar;

    public MenuConfiguracion() {
        super("Configuracion");
        
        this.cantidadMesas = new JLabel("Cantidad de mesas:");
        
        this.cantidaMesasEntrada = new JTextField();
        
        this.confimar = new JButton("Confimar");
        
        this.iniciarComponentes();
        this.ventana();
    }
    
    public void iniciarComponentes() {
        this.cantidadMesas.setBounds(20, 30, 200, 20);
        this.cantidadMesas.setFont(new Font("", Font.BOLD, 14)); 
        
        this.cantidaMesasEntrada.setBounds(200, 30, 100, 20);
        
        this.confimar.setBounds(70, 70, 160, 20);
        this.confimar.setFocusable(false); 
        
        this.add(this.cantidadMesas);
        this.add(this.cantidaMesasEntrada);
        this.add(this.confimar);
    } 
    
    public void ventana()  { 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(Color.LIGHT_GRAY);
        this.setSize(340, 180); 
        this.setResizable(false);
        this.setLayout(null);
        this.setVisible(true);
    }

    public JTextField getCantidaMesasEntrada() {
        return cantidaMesasEntrada;
    }

    public JButton getConfimar() {
        return confimar;
    }
    
    
}
