package modelo;

import compartido.Hamburguesa;
import compartido.Mesa;
import controlador.Controlador;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * @author rodri
 */

public class Simulador extends Thread {
    
    private boolean corre;
    private boolean encendido;
    private Controlador controlador;

    public Simulador(Controlador controlador) {
        this.corre = true;
        this.encendido = false;
        this.controlador = controlador;
    } 

    public void apagar (){
        this.encendido = false;
    }
    
    public void encender () {
        this.encendido = true;
    }
    
    public boolean getCorre() {
        return corre;
    }

    public void setCorre(boolean corre) {
        this.corre = corre;
    }
    
    private Hamburguesa obtenerHamburguesaAleatoria () {
        int cantidadIngredientes = new Random().nextInt(5)+1; 
        
        for (int i = 0; i < cantidadIngredientes; i++) {
            this.controlador.getFabrica().agregarIngrediente( this.controlador.getFabrica().obtenerIngredienteAleatorio() );
        }
        return this.controlador.getFabrica().obtenerHamburguesaPersonalizada();
    }
    
    private Mesa obtenerOrdenAleatoria () { 
        int cantidadHamburguesa = new Random().nextInt(5)+1;
        Mesa mesa = new Mesa(00);
        
        for (int i = 0; i < cantidadHamburguesa; i++) {
            mesa.agregarProducto( this.obtenerHamburguesaAleatoria());
        }
        return mesa;
    }
    
    
    @Override
    public void run (){
        System.out.println("simulo porque me gusta"); 
        
        while (this.corre){
            try {
                sleep (3000);
                
                //System.out.println("Esta es la bUmguer:\n");
                
                if (this.encendido)
                    this.controlador.enviarOrden( this.obtenerOrdenAleatoria() );
                    //System.out.println(""+ this.obtenerOrdenAleatoria().datosMesa());
                
            } catch (InterruptedException ex) {
                System.out.println(""+ex.getMessage());
            }
        }
        
    }
    
}
