/**
 * 
 */
package ar.com.almundo.callcenterproject.entity;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import ar.com.almundo.callcenterproject.CallDispatcher;

/**
 * @author Thiago Lima
 *
 */
public class OperadorTest extends TestCase {
	public static Test suite(){
		return new TestSuite( OperadorTest.class );
	}

	public void testOperador(){
		Llamada llamada = new Llamada("llamada test");
		llamada.setDuracion(5);
		CallDispatcher dispatcher = new CallDispatcher();
		Operador operador = new Operador(dispatcher, "operador test");
		try {
			operador.atenderLlamada(llamada);
			Thread.sleep(6000);
			assertTrue(dispatcher.getEmpleadosDisponibles().size()==1);
		} catch (InterruptedException e) {
			e.printStackTrace();
			fail();
		}
		
	}
}
