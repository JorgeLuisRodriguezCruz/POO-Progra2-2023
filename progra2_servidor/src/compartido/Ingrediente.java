package compartido;

import java.io.Serializable;

/*
 * @author rodri
 */

public enum Ingrediente implements Serializable{
    
    POLLO ("Pollo",90),
    HUEVO ("Huevo",40),
    TOCINO ("Tocino",50),
    TOMATE ("Tomate",22),
    CEBOLLA ("Cebolla",22),
    MOSTAZA ("Mostaza",10),
    LECHUGA ("Lechuga",20),
    MAYONESA ("Mayonesa",10),
    PEPINILLOS ("Pepinillos",16),
    CHAMPIÑONES ("Champiñones",18),
    CARNE_DE_RES ("Carne de res",140),
    QUESO_BLANCO ("Queso blanco",30),
    CARNE_DE_CERDO ("Carne de cerdo",120),
    QUESO_AMARILLO ("Queso amarillo",30),
    SALSA_DE_TOMATE ("Salsa de tomate",10);
    
    private String nombre;
    private int precio;

    private Ingrediente(String nombre, int precio) {
        this.precio = precio;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre.toUpperCase();
    }

    public int getPrecio() {
        return precio;
    }
    
}
