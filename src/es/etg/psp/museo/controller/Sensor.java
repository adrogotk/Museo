package es.etg.psp.museo.controller;

public class Sensor extends Thread {
	private TipoSensor tipoSensor;
	private Museo museo;
	public Sensor(TipoSensor tipoSensor, Museo museo){
		this.tipoSensor=tipoSensor;
		this.museo=museo;
	}
	public void run(){
		if (this.tipoSensor==TipoSensor.ENTRADA){
			for(int i=1; i<=MUSEO.N_ENTRADAS; i++){
            Entrada e=new Entrada(this.museo);
			e.start();
			e.join();
        }
		}
		else {
			for(int i=1; i<=MUSEO.N_SALIDAS; i++){
			Salida s=new Salida(this.museo);
			s.start();
			s.join();
		}
		}
	}
}
