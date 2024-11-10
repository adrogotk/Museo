package es.etg.psp.museo.impresion;


public abstract class Impresora {
   public String imprimir(String data){
      ImpresoraPantalla impresora=new ImpresoraPantalla();
      return impresora.imprimir(data);
   }
}
