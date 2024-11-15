package es.etg.psp.museo.impresion;


public class ImpresoraFactory{
	 public static Impresora imprimir(TipoImpresion tipoImpresion){
		 if (tipoImpresion==TipoImpresion.PANTALLA){
			return new ImpresoraPantalla();
		 }
		 else {
			return new ImpresoraPantalla();
		 }
   }
   
}
