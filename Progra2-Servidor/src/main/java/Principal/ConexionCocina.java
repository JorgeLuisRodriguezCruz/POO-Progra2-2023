package Principal;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/*
 *
 * @author rodri
 */

public class ConexionCocina extends Thread {
    private boolean corre;
    private Servidor servidor;
    private ObjectInputStream entrada;
    private ObjectOutputStream salida;
    
    public ConexionCocina (Servidor servidor){
        this.servidor = servidor;
        this.corre = true;
        try {
        this.entrada = new ObjectInputStream(this.servidor.getCocina().getInputStream());
        } catch (Exception e) {}
    }
    
    @Override
    public void run () {
        
        while (this.corre) {
            this.corre = false;
        }
    }
    
}
