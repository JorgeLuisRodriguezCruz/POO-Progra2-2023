package compartido;

import compartido.Ingrediente;
import java.io.Serializable;
import java.util.ArrayList;

/*
 * @author rodri
 */

public class Hamburguesa implements Serializable {
    
    private ArrayList<Ingrediente> ingredientes;

    public Hamburguesa() {
        this.ingredientes = new ArrayList<Ingrediente>(); 
    }
    
    public int obtenerPrecio () {
        
        int total = 0;
        if (this.ingredientes.size() != 0) { 
            for (int i = 0; i < this.ingredientes.size(); i++) {
                total = total + this.ingredientes.get(i).getPrecio(); 
            }
        }
        return total;
    }
    
    public void agregarIngrediente (Ingrediente ingrediente) {
        this.ingredientes.add(ingrediente);
    }

    public void sacarIngrediente (Ingrediente ingrediente) {
        
        for (int i = 0; i < this.ingredientes.size(); i++) {     
            if (this.ingredientes.get(i) == ingrediente){
                this.ingredientes.remove(i);
                return;
            } 
        }
    }
    
    public String ingredientes () {
        String datos = "Ingredientes: ";
        for (int i = 0; i < this.ingredientes.size(); i++) {
            datos = datos + this.ingredientes.get(i).getNombre().toUpperCase() + " - "; 
        } 
        return datos;
    }
    
    public String ingredientesDatos () {
        String datos = "";
        for (int i = 0; i < this.ingredientes.size(); i++) {
            datos = datos +"  "+ this.ingredientes.get(i).getNombre().toUpperCase() + "\n"; 
        } 
        return datos;
    }
    
    public String ingredientesFormatoDos () {
        String datos = "Ingredientes: \n";
        for (int i = 0; i < this.ingredientes.size(); i++) {
            datos = datos +"\t"+ this.ingredientes.get(i).getNombre().toUpperCase() + "\n"; 
        } 
        return datos;
    }
    
    public String preciosIngredientes (){
        String datos = "";
        for (int i = 0; i < this.ingredientes.size(); i++) {
            datos = datos + "  "+ this.ingredientes.get(i).getNombre() + "\n"; 
        }
        datos = datos + "  Costo: " + this.obtenerPrecio() + "\n";
        return datos;
    }
    
    public boolean vacia (){
        if (this.ingredientes.size() == 0)
            return true;
        return false;
    }
    
    public ArrayList<Ingrediente> getIngredientes() {
        return ingredientes;
    }
    
}
