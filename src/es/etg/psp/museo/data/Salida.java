package es.etg.psp.museo.data;
import es.etg.psp.museo.controller.*;

public class Salida extends Movimiento implements Runnable{

    public static final String TEXTO_SALIDA="Ha salido 1 visitante. Hay un total de %s visitantes";
    private Museo museo;

    public Salida(Museo museo){
        this.museo=museo;
    }

    public void run(){
        int n_personas=0;
        for(int i=1; i<=this.museo.N_SALIDAS; i++){
            try {
                this.museo.detectarSalida();
            } catch (InterruptedException ex) {
                System.exit(1);
            } 
        }
    }
}
