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
    
    public String obtenerFactura (){
        String factura = "\t-- Mesa #" + this.numero + " --\n\n";
        for (int i = 0; i < this.productos.size(); i++) {
            factura = factura + this.productos.get(i).toString(); 
        }
        return factura;
    }
    
    public void liberar () {
        this.ocupada = false;
    }
}
