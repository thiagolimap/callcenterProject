/**
 * 
 */
package ar.com.almundo.callcenterproject.entity;

import ar.com.almundo.callcenterproject.CallDispatcher;

/**
 * @author Thiago Lima
 *
 */
public class Operador extends AbstractEmpleado {
	public Operador (CallDispatcher dispatcher, String nombre){
		super(dispatcher, nombre);
		super.tipoEmpleado = TipoEmpleado.OPERADOR;
	}

	@Override
	void addEmpleadoDisponible(CallDispatcher dispatcher) {
		dispatcher.addEmpleadoDisponible(new Operador(dispatcher, nombre));
	}

}
