package compartido;

/*
 * @author rodri
 */

public class FabricaHamburguesa {

    public FabricaHamburguesa() {
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
        return null;
    }
     
    public Hamburguesa obtenerHamburguesaDobleQueso() {
        Hamburguesa hamburguesa = new Hamburguesa(); 
        hamburguesa.agregarIngrediente(Ingrediente.QUESO_AMARILLO);
        hamburguesa.agregarIngrediente(Ingrediente.QUESO_BLANCO);
        hamburguesa.agregarIngrediente(Ingrediente.TOCINO);
        hamburguesa.agregarIngrediente(Ingrediente.HUEVO);
        hamburguesa.agregarIngrediente(Ingrediente.HUEVO);
        return null;
    }
}
