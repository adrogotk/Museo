package es.etg.psp.museo.controller;
import es.etg.psp.museo.data.*;

public class Sensor extends Thread {
	private TipoSensor tipoSensor;
	private Museo museo;
	public Sensor(TipoSensor tipoSensor, Museo museo){
		this.tipoSensor=tipoSensor;
		this.museo=museo;
	}
        @Override
	public void run(){
		Thread hiloEntrada=null;
		Thread hiloSalida=null;
		int n_iteraciones;
		try {
			if (this.tipoSensor==TipoSensor.ENTRADA){
		    	hiloEntrada=new Thread(new Entrada(this.museo));
				hiloEntrada.start();
				n_iteraciones=Museo.N_ENTRADAS;
            	hiloEntrada.join();
            
			}
			else{
				hiloSalida=new Thread(new Salida(this.museo));
				n_iteraciones=Museo.N_SALIDAS;
				hiloSalida.start();
				hiloSalida.join();
		}
		}
		catch (InterruptedException ex) {
		}
    
	}
}
