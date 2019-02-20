/**
 * 
 */
package ar.com.almundo.callcenterproject.entity;

/**
 * @author Thiago Lima
 *
 */
public enum TipoEmpleado {
	OPERADOR(1),
	SUPERVISOR(2),
	DIRECTOR(3);
	private int prioridad;
	
	TipoEmpleado(int prioridad){
		this.prioridad=prioridad;
	}
	
	public int getPrioridad(){
		return prioridad;
	}
}