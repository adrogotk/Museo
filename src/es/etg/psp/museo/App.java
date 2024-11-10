package es.etg.psp.museo;

public class App {

    public static void main(String[] args) {
			Museo m=new Museo;
			String data=m.calcularAforo();
			Impresora impresora = ImpresoraFactory.imprimir(TipoImpresion.PANTALLA);
			impresora.imprimir(data);
	}
}

