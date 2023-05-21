package compartido;

import java.io.Serializable;
import java.util.ArrayList;

/*
 * @author rodri
 */

public class Mesa implements Serializable {
    
    private int numero;
    private boolean atendida;
    private ArrayList<Hamburguesa> productos;

    public Mesa (int numero) {
        this.numero = numero;
        this.atendida = false;
        this.productos = new ArrayList<Hamburguesa> ();
    }
    
    public void agregarProducto (Hamburguesa hamburguesa){
        this.productos.add(hamburguesa);
    }
    
    public void vaciar () {
        this.productos.removeAll(productos);
    }
    
    public int totalPagar () {
        int total = 0;
        for (int i = 0; i < this.productos.size(); i++) {
            total = total + this.productos.get(i).obtenerPrecio();
        }
        return total;
    }
    
    public String obtenerFactura (){
        String factura = "\t-- FACTURA MESA #" + this.numero + " --\n";
        for (int i = 0; i < this.productos.size(); i++) {
            factura = factura + "\nHamburguesa: \n" + this.productos.get(i).preciosIngredientes(); 
        }
        factura = factura + "\nTotal a pagar: "+this.totalPagar();
        return factura;
    }
    
    public String datosMesa () {
        String datos = "-- Mesa #" + this.numero + " --\n";
        for (int i = 0; i < this.productos.size(); i++) { 
            datos = datos + "\nHamburguesa: \n" + this.productos.get(i).ingredientes(); 
        }
        if (this.productos.size() == 0) {
            datos = datos + "\nSin productos agregados.";
        }
        return datos;
    }

    public int getNumero() {
        return numero;
    }

    public boolean getAtendida() {
        return atendida;
    } 
    
    public ArrayList<Hamburguesa> getProductos() {
        return productos;
    }

    public void setAtendida(boolean atendida) {
        this.atendida = atendida;
    } 
    
}
