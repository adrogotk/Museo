package es.etg.psp.museo.data;


public abstract class Movimiento {
   public String imprimir(string data){
      Impresora impresora = ImpresoraFactory.imprimir(TipoImpresion.PANTALLA);
      impresora.imprimir(data);
   }
}
