/**
 * 
 */
package ar.com.almundo.callcenterproject.entity;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * @author Thiago Lima
 *
 */
public class LlamadaTest extends TestCase {
	public static Test suite(){
		return new TestSuite( LlamadaTest.class );
	}
	public void testLlamada(){
		Llamada llamada	= new Llamada("llamada test");
		assertTrue(llamada.getDuracion()>=Llamada.MIN_DURACION);
		assertTrue(llamada.getDuracion()<=Llamada.MAX_DURACION);
	}
}
