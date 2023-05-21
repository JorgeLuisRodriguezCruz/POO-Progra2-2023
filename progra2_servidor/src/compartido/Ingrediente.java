package compartido;

import java.io.Serializable;

/*
 * @author rodri
 */

public enum Ingrediente implements Serializable{
    
    POLLO ("Pollo",14),
    HUEVO ("Huevo",14),
    TOCINO ("Tocino",14),
    TOMATE ("Tomate",14),
    CEBOLLA ("Cebolla",14),
    MOSTAZA ("Mostaza",14),
    LECHUGA (".Lechuga",14),
    MAYONESA ("Mayonesa",14),
    PEPINILLOS ("Pepinillos",14),
    CHAMPIÑONES ("Champiñones",14),
    CARNE_DE_RES ("Carne de res",14),
    QUESO_BLANCO ("Queso blanco",14),
    CARNE_DE_CERDO ("Carne de cerdo",14),
    QUESO_AMARILLO ("Queso amarillo",14),
    SALSA_DE_TOMATE ("Salsa de tomate",14);
    
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
