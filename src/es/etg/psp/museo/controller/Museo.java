package es.etg.psp.museo.controller;
import es.etg.psp.museo.data.Entrada;
import es.etg.psp.museo.data.Salida;
import es.etg.psp.museo.impresion.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Museo {
	public static final int N_ENTRADAS=10;
	public static final int N_SALIDAS=15;
	public static final int AFORO_INICIAL=100;
	public static final String TEXTO_FINAL="Aforo final: %s visitantes";
	private int n_personas;
	private int n_ejecuciones;
	private ReadWriteLock lock=new ReentrantReadWriteLock();
	private Lock r=lock.readLock();
	private Lock w=lock.writeLock();
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
	public synchronized void detectarEntrada() throws InterruptedException{
		this.w.lock();
		try {
			this.setNPersonas(this.n_personas+1);
			this.imprimir(String.format(Entrada.TEXTO_ENTRADA, this.n_personas));
		} finally {
			this.w.unlock();
		}
	}
	public synchronized void detectarSalida() throws InterruptedException{
		this.w.lock();
		try {

		    this.setNPersonas(this.n_personas-1);
			this.imprimir(String.format(Salida.TEXTO_SALIDA, this.n_personas));

		} finally {
			this.w.unlock();
		}
	}
	public synchronized int getNPersonas () throws InterruptedException {
		return this.n_personas;
	}
	public synchronized void setNPersonas(int n_personas){
	this.n_personas=n_personas;
	}
	public synchronized int getNEjecuciones () {
		return this.n_ejecuciones;
	}
	public synchronized void setNEjecuciones() {
		this.n_ejecuciones++;
	}
	public synchronized void imprimir(String data) throws InterruptedException{
        Impresora impresora = ImpresoraFactory.imprimir(TipoImpresion.PANTALLA);
        impresora.imprimir(data);
                //this.n_ejecuciones--;
	 }
}
