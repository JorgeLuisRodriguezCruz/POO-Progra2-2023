package modelo;

import compartido.Mesa;
import java.util.ArrayList;
import java.util.Random;

/*
 * @author rodri
 */

public class Cocina {
    
    private ArrayList<Mesa> ordenesMesas;

    public Cocina() {
        this.ordenesMesas = new ArrayList<Mesa>();
    }
    
    public void agregarOrden (Mesa orden) {
        this.ordenesMesas.add(orden);
    }
    
    public void removerOrden (Mesa orden) {
        this.ordenesMesas.remove(orden);
    }
    
    public Mesa obtenerMesa (int numeroMesa) { 
        for (int i = 0; i < this.ordenesMesas.size(); i++) {
            if (this.ordenesMesas.get(i).getNumero() == numeroMesa)
                return this.ordenesMesas.get(i);
        }
        return null;
    }
    
    public Mesa obtenerMesaAleatoria () {
        if(this.ordenesMesas.size() > 0){
            int numMesa = new Random().nextInt(this.ordenesMesas.size()); 
            return this.ordenesMesas.get(numMesa);
        }
        return null;
    }
    
    public String obtenerOrdenes () {
        String datos = "";
        for (int i = 0; i < this.ordenesMesas.size(); i++) {
            datos = datos + this.ordenesMesas.get(i).datosMesa() + "\n";
        }
        return datos;
    }
    
}
