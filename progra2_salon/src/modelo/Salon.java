package modelo;

import compartido.FabricaHamburguesa;
import compartido.Hamburguesa;
import compartido.Mesa;
import java.util.ArrayList;

/*
 * @author rodri
 */

public class Salon {
    
    private FabricaHamburguesa frabrica;
    private ArrayList<Mesa> mesasOrdenEnviada;
    private ArrayList<Mesa> mesas;

    public Salon() { 
        this.frabrica = new FabricaHamburguesa();
        this.mesasOrdenEnviada = new ArrayList<Mesa>();
        this.mesas = new ArrayList<Mesa>();
        
    }
    
    public void iniciarMesas (int numMesas) {
        if (this.mesas.size() == 0) {
            for (int i = 1; i <= numMesas; i++) {
                Mesa mesaTemporal = new Mesa(i);
                this.mesas.add(mesaTemporal);
            }
        }
    }

    public FabricaHamburguesa getFrabrica() {
        return frabrica;
    } 
    
    public ArrayList<Mesa> getMesasOrdenEnviada() {
        return mesasOrdenEnviada;
    }

    public ArrayList<Mesa> getMesas() {
        return mesas;
    }
    
    public Mesa obtenerMesa (int num) {
        for (int i = 0; i < this.mesas.size(); i++) {
            if (this.mesas.get(i).getNumero() == num)
                return this.mesas.get(i);
        } 
        return null;
    }
    
}
