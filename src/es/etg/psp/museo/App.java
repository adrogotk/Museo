package es.etg.psp.museo;
import es.etg.psp.museo.controller.*;
import es.etg.psp.museo.impresion.*;

public class App {

    public static void main(String[] args) {
			Museo m=new Museo();
			String data=m.calcularAforo();
			Impresora impresora = ImpresoraFactory.imprimir(TipoImpresion.PANTALLA);
			impresora.imprimir(data);
	}
}

