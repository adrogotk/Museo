package es.etg.psp.museo.data;
import es.etg.psp.museo.impresion.*;

public abstract class Movimiento {
   public void imprimir(String data){
      Impresora impresora = ImpresoraFactory.imprimir(TipoImpresion.PANTALLA);
      impresora.imprimir(data);
   }
}
