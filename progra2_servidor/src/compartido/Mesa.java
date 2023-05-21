package compartido;

import java.io.Serializable;
import java.util.ArrayList;

/*
 * @author rodri
 */

public class Mesa implements Serializable {
    
    private int numero;
    private boolean ocupada;
    private ArrayList<Hamburguesa> productos;

    public Mesa (int numero) {
        this.numero = numero;
        this.ocupada = true;
        this.productos = new ArrayList<Hamburguesa> ();
    }
    
    public void agregarProducto (Hamburguesa hamburguesa){
        this.productos.add(hamburguesa);
    }
    
    public int totalPagar () {
        int total = 0;
        for (int i = 0; i < this.productos.size(); i++) {
            total = total + this.productos.get(i).obtenerPrecio();
        }
        return total;
    }
    
    public String obtenerFactura (){
        String factura = "\t-- Mesa #" + this.numero + " --\n";
        for (int i = 0; i < this.productos.size(); i++) {
            factura = factura + "\nHamburguesa: \n" + this.productos.get(i).toString(); 
        }
        factura = factura + "\nTotal a pagar: "+this.totalPagar();
        return factura;
    }
    
    public void liberar () {
        this.ocupada = false;
    }

    public String datosMesa () {
        String datos = "\t-- Mesa #" + this.numero + " --\n";
        for (int i = 0; i < this.productos.size(); i++) {
            System.out.println("aa");
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

    public boolean isOcupada() {
        return ocupada;
    }
    
    public ArrayList<Hamburguesa> getProductos() {
        return productos;
    }

    
}
