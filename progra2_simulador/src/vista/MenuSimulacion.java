package vista;

import controlador.Controlador;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/*
 * @author rodri
 */

public class MenuSimulacion extends JFrame implements WindowListener {

    private JButton encender;
    private JButton apager;
    
    private Controlador controlador;
    
    public MenuSimulacion(Controlador controlador) {
        super ("Menu Simulacion");
        
        this.controlador = controlador;
        
        this.encender = new JButton("Encender");
        this.apager = new JButton("Apagar");
        
        this.iniciarComponentes();
        this.iniciarVentana();
        this.addWindowListener(this);
    }
    
    private void iniciarComponentes () {
        
        this.encender.setBounds(30, 50, 90, 20);
        this.encender.setFocusable(false);
        this.encender.setBackground(new Color(153, 255, 153));
        this.apager.setBounds(210, 50, 90, 20);
        this.apager.setFocusable(false);
        this.apager.setBackground(new Color(255, 153, 153));
        
        this.add(this.encender);
        this.add(this.apager);
    }
    
    private void iniciarVentana () {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(Color.LIGHT_GRAY);
        this.setSize(340, 180); 
        this.setResizable(false);
        this.setLayout(null);
        this.setVisible(true);
        
    }

    public JButton getEncender() {
        return encender;
    }

    public JButton getApager() {
        return apager;
    }
    
    @Override
    public void windowOpened(WindowEvent e) {    }

    @Override
    public void windowClosing(WindowEvent e) {
        this.controlador.desconectarse();
    }

    @Override
    public void windowClosed(WindowEvent e) {    }

    @Override
    public void windowIconified(WindowEvent e) {    }

    @Override
    public void windowDeiconified(WindowEvent e) {    }

    @Override
    public void windowActivated(WindowEvent e) {    }

    @Override
    public void windowDeactivated(WindowEvent e) {    }
    
    
}
