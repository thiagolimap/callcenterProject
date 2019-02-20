/**
 * 
 */
package ar.com.almundo.callcenterproject;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

import ar.com.almundo.callcenterproject.entity.AbstractEmpleado;
import ar.com.almundo.callcenterproject.entity.Llamada;

/**
 * @author Thiago Lima
 *
 */
public class CallDispatcher extends Thread{

	BlockingQueue<AbstractEmpleado> empleadosDisponibles;

	BlockingQueue<Llamada> llamadas; 

	
	public CallDispatcher(){
		empleadosDisponibles = new PriorityBlockingQueue<AbstractEmpleado>();
		llamadas = new LinkedBlockingQueue<Llamada>();
	}

	
	public void dispatchCall(Llamada llamada) throws InterruptedException{
		
		System.out.println(">>> Entrando llamada " + llamada.getDescripcion());
		
		this.llamadas.put(llamada);
	}

	public void run() {
		Llamada llamada;
		AbstractEmpleado empleado;
		try {
			while(true){
				llamada = llamadas.take();
				
				System.out.println(">>> Esperando a tomar la llamada " + llamada.getDescripcion());
				empleado = empleadosDisponibles.take();
				
				System.out.println(">>> El empleado " + empleado.getNombre() + " va a tomar la llamda " + llamada.getDescripcion()+ "!!!");
				empleado.atenderLlamada(llamada);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addEmpleadoDisponible(AbstractEmpleado empleado){
		this.empleadosDisponibles.add(empleado);
	}
	
	public Queue<Llamada> getLLamadas(){
		return llamadas;
	}
	
	public Queue<AbstractEmpleado> getEmpleadosDisponibles(){
		return empleadosDisponibles;
	}
}
