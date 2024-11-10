package es.etg.psp.museo.data;

public class Salida  extends Movimiento implements Runnable{

    public static final String TEXTO_SALIDA="Ha salido 1 visitante. Hay un total de %s visitantes";
    private Museo museo;

    public Salida(Museo museo){
        this.museo=museo;
    }

    public void run(){
      this.museo.n_personas--;
      super.imprimir(String.format(TEXTO_SALIDA, this.museo.n_personas);
    }
}
