package es.etg.psp.museo.data;
import es.etg.psp.museo.impresion.*;

public abstract class Movimiento {
   public synchronized void imprimir(String data, int n_ejecuciones){
      Impresora impresora = ImpresoraFactory.imprimir(TipoImpresion.PANTALLA);
      impresora.imprimir(data);
      //notify();
   }
}
