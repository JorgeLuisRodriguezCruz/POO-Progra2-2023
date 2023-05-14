package compartido;

import Secundario.TipoMensaje;
import java.io.Serializable;

/*
 * @author rodri
 */

public class Mensaje implements Serializable {
    
    private TipoMensaje tipo;
    private Mesa contenido;

    public Mensaje(TipoMensaje tipo, Mesa contenido) {
        this.tipo = tipo;
        this.contenido = contenido;
    }

    public TipoMensaje getTipo() {
        return tipo;
    }

    public Mesa getContenido() {
        return contenido;
    } 
    
}
