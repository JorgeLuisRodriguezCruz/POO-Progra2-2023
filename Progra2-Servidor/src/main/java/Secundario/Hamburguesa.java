package Secundario;

import java.util.ArrayList;

/*
 * @author rodri
 */

public class Hamburguesa {
    
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
    
    public String toString (){
        String datos = "\tIngredientes: ";
        for (int i = 0; i < this.ingredientes.size(); i++) {
            datos = datos + this.ingredientes.get(i).getNombre() + "_"; 
        }
        datos = datos + "\n\tCosto: " + this.obtenerPrecio();
        return datos;
    }
    
    public ArrayList<Ingrediente> getIngredientes() {
        return ingredientes;
    }
    
}
