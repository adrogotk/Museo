package es.etg.psp.museo.data;
import es.etg.psp.museo.controller.*;
import java.lang.*;

public class Entrada extends Movimiento implements Runnable{

     public static final String TEXTO_ENTRADA="Ha entrado 1 visitante. Hay un total de %s visitantes";
    private Museo museo;

    public Entrada(Museo museo){
        this.museo=museo;
    }

    public void run(){
	  int n_personas=this.museo.getNPersonas();
      this.museo.setNPersonas(n_personas+1);
      super.imprimir(String.format(TEXTO_ENTRADA, n_personas));
    }
}
