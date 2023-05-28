package compartido;

import java.util.ArrayList;
import java.util.Random;

/*
 * @author rodri
 */

public class FabricaHamburguesa {
    
    private Hamburguesa hamburguesaAuxiliar;

    public FabricaHamburguesa() {
        this.hamburguesaAuxiliar = new Hamburguesa();
    }
    
    public void agregarIngrediente (Ingrediente ingrediente){
        this.hamburguesaAuxiliar.agregarIngrediente(ingrediente); 
    }
    
    public void agregarIngredientes (ArrayList<Ingrediente> ingredientes){
        for (int i = 0; i < ingredientes.size(); i++) {
            this.agregarIngrediente(ingredientes.get(i));
        }
    }
    
    public Hamburguesa obtenerHamburguesaPersonalizada () {
        Hamburguesa resultado = this.hamburguesaAuxiliar;
        this.hamburguesaAuxiliar = new Hamburguesa();
        return resultado;
    }
    
    public Hamburguesa obtenerHamburguesaPollo() {
        Hamburguesa hamburguesa = new Hamburguesa(); 
        hamburguesa.agregarIngrediente(Ingrediente.SALSA_DE_TOMATE);
        hamburguesa.agregarIngrediente(Ingrediente.MAYONESA);
        hamburguesa.agregarIngrediente(Ingrediente.TOCINO);
        hamburguesa.agregarIngrediente(Ingrediente.TOMATE);
        hamburguesa.agregarIngrediente(Ingrediente.POLLO);
        return hamburguesa;
    }
     
    public Hamburguesa obtenerHamburguesaDosCarnes() {
        Hamburguesa hamburguesa = new Hamburguesa(); 
        hamburguesa.agregarIngrediente(Ingrediente.SALSA_DE_TOMATE);
        hamburguesa.agregarIngrediente(Ingrediente.CARNE_DE_CERDO);
        hamburguesa.agregarIngrediente(Ingrediente.CARNE_DE_RES);
        hamburguesa.agregarIngrediente(Ingrediente.CEBOLLA);
        hamburguesa.agregarIngrediente(Ingrediente.TOMATE);
        return hamburguesa;
    }
     
    public Hamburguesa obtenerHamburguesaDobleQueso() {
        Hamburguesa hamburguesa = new Hamburguesa(); 
        hamburguesa.agregarIngrediente(Ingrediente.QUESO_AMARILLO);
        hamburguesa.agregarIngrediente(Ingrediente.QUESO_BLANCO);
        hamburguesa.agregarIngrediente(Ingrediente.TOCINO);
        hamburguesa.agregarIngrediente(Ingrediente.HUEVO);
        hamburguesa.agregarIngrediente(Ingrediente.HUEVO);
        return hamburguesa;
    }

    public String listaDeIngredientes () {
        String ingredientes = "";
        
        ingredientes = ingredientes + "Ingrediente: "+ Ingrediente.POLLO.getNombre() +" - Precio: "+ Ingrediente.POLLO.getPrecio() +"\n";
        ingredientes = ingredientes + "Ingrediente: "+ Ingrediente.HUEVO.getNombre() +" - Precio: "+ Ingrediente.HUEVO.getPrecio() +"\n";
        ingredientes = ingredientes + "Ingrediente: "+ Ingrediente.TOCINO.getNombre() +" - Precio: "+ Ingrediente.TOCINO.getPrecio() +"\n";
        ingredientes = ingredientes + "Ingrediente: "+ Ingrediente.TOMATE.getNombre() +" - Precio: "+ Ingrediente.TOMATE.getPrecio() +"\n";
        ingredientes = ingredientes + "Ingrediente: "+ Ingrediente.CEBOLLA.getNombre() +" - Precio: "+ Ingrediente.CEBOLLA.getPrecio() +"\n";
        ingredientes = ingredientes + "Ingrediente: "+ Ingrediente.MOSTAZA.getNombre() +" - Precio: "+ Ingrediente.MOSTAZA.getPrecio() +"\n";
        ingredientes = ingredientes + "Ingrediente: "+ Ingrediente.LECHUGA.getNombre() +" - Precio: "+ Ingrediente.LECHUGA.getPrecio() +"\n";
        ingredientes = ingredientes + "Ingrediente: "+ Ingrediente.MAYONESA.getNombre() +" - Precio: "+ Ingrediente.MAYONESA.getPrecio() +"\n";
        ingredientes = ingredientes + "Ingrediente: "+ Ingrediente.PEPINILLOS.getNombre() +" - Precio: "+ Ingrediente.PEPINILLOS.getPrecio() +"\n";
        ingredientes = ingredientes + "Ingrediente: "+ Ingrediente.CHAMPIÑONES.getNombre() +" - Precio: "+ Ingrediente.CHAMPIÑONES.getPrecio() +"\n";
        ingredientes = ingredientes + "Ingrediente: "+ Ingrediente.CARNE_DE_RES.getNombre() +" - Precio: "+ Ingrediente.CARNE_DE_RES.getPrecio() +"\n";
        ingredientes = ingredientes + "Ingrediente: "+ Ingrediente.QUESO_BLANCO.getNombre() +" - Precio: "+ Ingrediente.QUESO_BLANCO.getPrecio() +"\n";
        ingredientes = ingredientes + "Ingrediente: "+ Ingrediente.CARNE_DE_CERDO.getNombre() +" - Precio: "+ Ingrediente.CARNE_DE_CERDO.getPrecio() +"\n";
        ingredientes = ingredientes + "Ingrediente: "+ Ingrediente.QUESO_AMARILLO.getNombre() +" - Precio: "+ Ingrediente.QUESO_AMARILLO.getPrecio() +"\n";
        ingredientes = ingredientes + "Ingrediente: "+ Ingrediente.SALSA_DE_TOMATE.getNombre() +" - Precio: "+ Ingrediente.SALSA_DE_TOMATE.getPrecio();
        
        return ingredientes;
    }
    
    public Ingrediente obtenerIngrediente (String ingrediente){
        ingrediente = ingrediente.toUpperCase();
        
        if (ingrediente.equals(Ingrediente.POLLO.getNombre()))
            return Ingrediente.POLLO; 
        if (ingrediente.equals( Ingrediente.HUEVO.getNombre() ))
            return Ingrediente.HUEVO;
        if (ingrediente.equals( Ingrediente.TOCINO.getNombre() ))
            return Ingrediente.TOCINO;
        if (ingrediente.equals( Ingrediente.TOMATE.getNombre() ))
            return Ingrediente.TOMATE;
        if (ingrediente.equals( Ingrediente.CEBOLLA.getNombre() ))
            return Ingrediente.CEBOLLA;
        if (ingrediente.equals( Ingrediente.MOSTAZA.getNombre() ))
            return Ingrediente.MOSTAZA;
        if (ingrediente.equals( Ingrediente.LECHUGA.getNombre() ))
            return Ingrediente.LECHUGA;
        if (ingrediente.equals( Ingrediente.MAYONESA.getNombre() ))
            return Ingrediente.MAYONESA;
        if (ingrediente.equals( Ingrediente.PEPINILLOS.getNombre() ))
            return Ingrediente.PEPINILLOS;
        if (ingrediente.equals( Ingrediente.CHAMPIÑONES.getNombre() ))
            return Ingrediente.CHAMPIÑONES;
        if (ingrediente.equals( Ingrediente.CARNE_DE_RES.getNombre() ))
            return Ingrediente.CARNE_DE_RES;
        if (ingrediente.equals( Ingrediente.QUESO_BLANCO.getNombre() ))
            return Ingrediente.QUESO_BLANCO;
        if (ingrediente.equals( Ingrediente.CARNE_DE_CERDO.getNombre() ))
            return Ingrediente.CARNE_DE_CERDO;
        if (ingrediente.equals( Ingrediente.QUESO_AMARILLO.getNombre() ))
            return Ingrediente.QUESO_AMARILLO;
        if (ingrediente.equals( Ingrediente.SALSA_DE_TOMATE.getNombre() ))
            return Ingrediente.SALSA_DE_TOMATE;
            
        return null;
    }
    
    public Ingrediente obtenerIngredienteAleatorio () {
        int num = new Random ().nextInt(15)+1;
        
        switch (num){
            case 1:
                return Ingrediente.POLLO;
            case 2:
                return Ingrediente.HUEVO; 
            case 3:
                return Ingrediente.TOCINO;
            case 4:
                return Ingrediente.TOMATE; 
            case 5:
                return Ingrediente.CEBOLLA; 
            case 6:
                return Ingrediente.MOSTAZA; 
            case 7:
                return Ingrediente.LECHUGA; 
            case 8:
                return Ingrediente.MAYONESA; 
            case 9:
                return Ingrediente.PEPINILLOS; 
            case 10:
                return Ingrediente.CHAMPIÑONES; 
            case 11:
                return Ingrediente.CARNE_DE_RES; 
            case 12:
                return Ingrediente.QUESO_BLANCO; 
            case 13:
                return Ingrediente.CARNE_DE_CERDO; 
            case 14:
                return Ingrediente.QUESO_AMARILLO; 
            case 15:
                return Ingrediente.SALSA_DE_TOMATE; 
        } 
        return null;
    }
    
    public Hamburguesa obtenerHamburguesaAux () {
        return this.hamburguesaAuxiliar;
    }
}
