package compartido;

import Secundario.TipoMensaje;

/*
 * @author rodri
 */

public class Mensaje {
    
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
