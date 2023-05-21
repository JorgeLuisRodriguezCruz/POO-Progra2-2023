package compartido;

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
    
    public Hamburguesa obtenerHamburguesa () {
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
    
}
