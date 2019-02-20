/**
 * 
 */
package ar.com.almundo.callcenterproject.entity;

import ar.com.almundo.callcenterproject.CallDispatcher;

/**
 * @author Thiago Lima
 *
 */
public class Supervisor extends AbstractEmpleado {
	public Supervisor(CallDispatcher dispatcher, String nombre){
		super(dispatcher, nombre);
		super.tipoEmpleado = TipoEmpleado.SUPERVISOR;
	}

	@Override
	void addEmpleadoDisponible(CallDispatcher dispatcher) {
		dispatcher.addEmpleadoDisponible(new Supervisor(dispatcher, nombre));
	}

}
