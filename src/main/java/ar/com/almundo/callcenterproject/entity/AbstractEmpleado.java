/**
 * 
 */
package ar.com.almundo.callcenterproject.entity;

import ar.com.almundo.callcenterproject.CallDispatcher;

/**
 * @author Thiago Lima
 *
 */
public abstract class AbstractEmpleado extends Thread implements Comparable<AbstractEmpleado>{
	
	//Datos del empeado
	protected TipoEmpleado tipoEmpleado;
	protected String nombre;
	
	//Llamada que esta atendiendo
	private Llamada llamadaAtendida;
	
	//Referencia al Dispatcher
	private CallDispatcher dispatcher;
	
	public AbstractEmpleado(CallDispatcher dispatcher, String nombre){
		this.dispatcher = dispatcher;
		this.nombre = nombre;
	}
	
	public int getPrioridad(){
		return this.tipoEmpleado.getPrioridad();
	}
	
	public int compareTo(AbstractEmpleado e2) {
		if (this.getPrioridad() < e2.getPrioridad()){
			return -1;
		}
		if (this.getPrioridad() > e2.getPrioridad()){
			return 1;
		}
		return 0;	
	}

	public void atenderLlamada(Llamada llamada) throws InterruptedException {
		this.llamadaAtendida = llamada;
		this.start();
	}

	//Cuando se ejecuta el hilo, significa que esta atendiendo la llamada. El hilo que en espera (sleep) la duracion de la llamada.
	public void run() {
        try {
		Thread.sleep(1000 * llamadaAtendida.getDuracion());
        System.out.println("Llamada " + llamadaAtendida.getDescripcion() + " finalizada. Duracion :" + llamadaAtendida.getDuracion());
        this.addEmpleadoDisponible(dispatcher);
        System.out.println("Empleado " + this.getNombre() + " disponible");
		} catch (InterruptedException e) {
			System.out.println("Error atendiendo llamada " + llamadaAtendida.getDescripcion());
			e.printStackTrace();
		} 
	}

	//Este metodo tiene que ser implementado por los hijos porque tiene que agregar a la cola una nueva instancia de empleado
	
	abstract void addEmpleadoDisponible(CallDispatcher dispatcher);

	public String getNombre() {
		return nombre;
	}

}
