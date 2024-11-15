package es.etg.psp.museo.controller;
import es.etg.psp.museo.data.*;
import java.lang.*;

public class Sensor extends Thread {
	private TipoSensor tipoSensor;
	private Museo museo;
	public Sensor(TipoSensor tipoSensor, Museo museo){
		this.tipoSensor=tipoSensor;
		this.museo=museo;
	}
	public void run(){
		if (this.tipoSensor==TipoSensor.ENTRADA){
			for(int i=1; i<=Museo.N_ENTRADAS; i++){
            Thread e=new Thread(new Entrada(this.museo));
			e.start();
			try {
			e.join();
			} catch (InterruptedException ex) {
			System.out.println(ex);
			}
        }
		}
		else {
			for(int i=1; i<=Museo.N_SALIDAS; i++){
			Thread s=new Thread(new Salida(this.museo));
			s.start();
			try {
			s.join();
			} catch (InterruptedException ex) {
				System.out.println(ex);
			}
		}
		}
	}
}
