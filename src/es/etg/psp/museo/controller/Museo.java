package es.etg.psp.museo.controller;
import java.lang.*;

public class Museo {
	public static final int N_ENTRADAS=10;
	public static final int N_SALIDAS=15;
	public static final int AFORO_INICIAL=100;
	 public static final String TEXTO_FINAL="Aforo final: %s visitantes";
	private int n_personas;
	private int n_ejecuciones;
	public Museo(){
		this.n_personas=AFORO_INICIAL;
		this.n_ejecuciones=0;
	}
		
	
	public String calcularAforo() throws InterruptedException{
		Sensor sensor_entrada=new Sensor(TipoSensor.ENTRADA,this);
		Sensor sensor_salida=new Sensor (TipoSensor.SALIDA, this);
		sensor_entrada.start();
		sensor_salida.start();
		sensor_entrada.join();
		sensor_salida.join();
		String data=String.format(TEXTO_FINAL,this.n_personas);
        return data;
            
	}
	public synchronized int getNPersonas () {
		int n_personas=this.n_personas;
		return n_personas;
	}
	public synchronized void setNPersonas(int n_personas) {
		this.n_personas=n_personas;
	}
	public synchronized int getNEjecuciones () {
		int n_ejecuciones=this.n_ejecuciones;
		return n_ejecuciones;
	}
	public synchronized void setNEjecuciones(int n_ejecuciones) {
		this.n_ejecuciones=n_ejecuciones;
	}
}
