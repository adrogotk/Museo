package es.etg.psp.museo.controller;

public class Museo {
	public static final int N_ENTRADAS=10
	public static final int N_SALIDAS=15
	public static final int AFORO_INICIAL=100;
	 public static final String TEXTO_FINAL="Aforo final: %s visitantes";
	private int n_personas;
	public Museo(){
		this.n_personas=AFORO_INICIAL;
	}
		
	
	public String calcularAforo(){
		Sensor sensor_entrada=new Sensor(TipoSensor.ENTRADA,this);
		Sensor sensor_salida=new Sensor (TipoSensor.SALIDA, this);
		sensor_entrada.start();
		sensor_salida.start();
		sensor_entrada.join();
		sensor_salida.join();
		String data=String.format(TEXTO_FINAL,this.n_personas);
        return data;
            
	}
}
