package es.etg.psp.museo.data;

public class Entrada extends Movimiento implements Runnable{

     public static final String TEXTO_ENTRADA="Ha entrado 1 visitante. Hay un total de %s visitantes";
    private Museo museo;

    public Entrada(Museo museo){
        this.museo=museo;
    }

    public void run(){
      this.museo.n_personas++;
      super.imprimir(String.format(TEXTO_ENTRADA, this.museo.n_personas);
    }
}
