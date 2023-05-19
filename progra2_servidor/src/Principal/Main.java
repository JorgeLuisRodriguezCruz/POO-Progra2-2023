package Principal;

import compartido.TipoMensaje;
import com.sun.java.accessibility.util.TopLevelWindowListener;

/*
 *
 * @author rodri
 */

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Servidor ser = new Servidor();
        /*
        TipoMensaje tipo = TipoMensaje.ORDEN;
        System.out.println("El tipo: "+tipo.toString());
        
        if (tipo == TipoMensaje.ORDEN)
            System.out.println("Son Ecuales");
        
        if (tipo != TipoMensaje.SALIDA)
            System.out.println("Son Deferentes");
        
        switch(tipo){
            case NOTIFICACION:
                break;
            case SALIDA:
                break;
        }
        */
    }
}
