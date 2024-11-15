package es.etg.psp.museo.data;
import es.etg.psp.museo.controller.*;
import java.lang.*;

public class Salida  extends Movimiento implements Runnable{

    public static final String TEXTO_SALIDA="Ha salido 1 visitante. Hay un total de %s visitantes";
    private Museo museo;

    public Salida(Museo museo){
        this.museo=museo;
    }

    public void run(){
        int n_personas=0;
        int n_ejecuciones;
            n_personas=this.museo.getNPersonas();
            n_personas--;
            this.museo.setNPersonas(n_personas);
            n_ejecuciones=this.museo.getNEjecuciones();
                super.imprimir(String.format(TEXTO_SALIDA, n_personas), n_ejecuciones);
                this.museo.setNEjecuciones(n_ejecuciones+1);
    }
}
