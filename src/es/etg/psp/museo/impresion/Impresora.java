package es.etg.psp.museo.impresion;


public abstract class Impresora {
   public void imprimir(String data){
      ImpresoraPantalla impresora=new ImpresoraPantalla();
      impresora.imprimir(data);
   }
}
