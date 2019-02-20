/**
 * 
 */
package ar.com.almundo.callcenterproject;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import ar.com.almundo.callcenterproject.entity.Director;
import ar.com.almundo.callcenterproject.entity.Llamada;
import ar.com.almundo.callcenterproject.entity.Operador;
import ar.com.almundo.callcenterproject.entity.Supervisor;

/**
 * @author Zuleide
 *
 */
public class CallDispatcherTest extends TestCase {
	final int TIEMPO_MAX_LLAMADA_MILISEC = 10000;
	   /**
	     * @return the suite of tests being tested
	     */
	    public static Test suite(){
	        return new TestSuite( CallDispatcherTest.class );
	    }
	    
	    //Este test dura 15s
	    public void testTresLLamadas(){
	    	try {
	    		System.out.println("-----------TEST 3 LLAMADAS--------------");
		    	CallDispatcher dispatcher = new CallDispatcher();
		    	dispatcher.start();
				dispatcher.addEmpleadoDisponible(new Operador(dispatcher, "Operador 1"));
				Llamada llamada1 = new Llamada(" 1 ");
				llamada1.setDuracion(5);
				Llamada llamada2 = new Llamada(" 2 ");
				llamada2.setDuracion(5);
				Llamada llamada3 = new Llamada(" 3 ");
				llamada3.setDuracion(5);
		    	dispatcher.dispatchCall(llamada1);
				dispatcher.dispatchCall(llamada2);
				dispatcher.dispatchCall(llamada3);

				//Las llamadas de este test duran 5s y como hay 1 solo operador, las llamadas tienen que ser atendidasen 15s.
				Thread.sleep(15000);
				
				//Al finalizar este tiempo, las llamdas deberian haber sido atendidas
				assertTrue(dispatcher.getLLamadas().isEmpty());
				
			} catch (InterruptedException e) {
				e.printStackTrace();
				fail();
			}
	    	
	    }
	    //Este test dura 33s
	    public void testDiezLLamadas(){
			System.out.println("-----------TEST 10 LLAMADAS--------------");
	    	try {
		    	CallDispatcher dispatcher = new CallDispatcher();
		    	dispatcher.start();
				dispatcher.addEmpleadoDisponible(new Director(dispatcher, "Director 1"));
				dispatcher.addEmpleadoDisponible(new Supervisor(dispatcher, "Supervisor 1"));
				dispatcher.addEmpleadoDisponible(new Operador(dispatcher, "Operador 1"));
				
		    	dispatcher.dispatchCall(new Llamada(" 1 "));
				dispatcher.dispatchCall(new Llamada(" 2 "));
				dispatcher.dispatchCall(new Llamada(" 3 "));
				dispatcher.dispatchCall(new Llamada(" 4 "));
				dispatcher.dispatchCall(new Llamada(" 5 "));
				dispatcher.dispatchCall(new Llamada(" 6 "));
				dispatcher.dispatchCall(new Llamada(" 7 "));
				dispatcher.dispatchCall(new Llamada(" 8 "));
				dispatcher.dispatchCall(new Llamada(" 9 "));
				dispatcher.dispatchCall(new Llamada(" 10 "));

				//Espero el tiempo maximo para que todas las llamadas hayan sido atendidas:
				//((cant llamadas * tiempo de duracion max de llamada) / cant empleados)
				Thread.sleep((TIEMPO_MAX_LLAMADA_MILISEC * 10)/3);
				
				//Al finalizar este tiempo, las llamdas deberian haber sido atendidas
				assertTrue(dispatcher.getLLamadas().isEmpty());
				
			} catch (InterruptedException e) {
				e.printStackTrace();
				fail();
			}
	    	
	    }
	    //Este test dura 20s
	   public void testIncomingCalls(){
			System.out.println("-----------TEST INCOMING CALLS--------------");
	    	try {
		    	CallDispatcher dispatcher = new CallDispatcher();
		    	dispatcher.start();
		    	dispatcher.dispatchCall(new Llamada(" 1 "));
				dispatcher.dispatchCall(new Llamada(" 2 "));
				dispatcher.dispatchCall(new Llamada(" 3 "));
				dispatcher.dispatchCall(new Llamada(" 4 "));
				dispatcher.dispatchCall(new Llamada(" 5 "));
				dispatcher.addEmpleadoDisponible(new Operador(dispatcher, "Operador 1"));
				dispatcher.addEmpleadoDisponible(new Operador(dispatcher, "Operador 2"));
				dispatcher.addEmpleadoDisponible(new Operador(dispatcher, "Operador 3"));
				dispatcher.addEmpleadoDisponible(new Supervisor(dispatcher, "Supervisor 1"));
				dispatcher.addEmpleadoDisponible(new Operador(dispatcher, "Operador 4"));
				dispatcher.dispatchCall(new Llamada(" 6 "));
				dispatcher.addEmpleadoDisponible(new Director(dispatcher, "Director 1"));
				dispatcher.dispatchCall(new Llamada(" 7 "));
				dispatcher.dispatchCall(new Llamada(" 8 "));
				dispatcher.addEmpleadoDisponible(new Supervisor(dispatcher, "Supervisor 2"));
				dispatcher.dispatchCall(new Llamada(" 9 "));
				dispatcher.dispatchCall(new Llamada(" 10 "));
				dispatcher.dispatchCall(new Llamada(" 11 "));
				dispatcher.dispatchCall(new Llamada(" 12 "));
				dispatcher.addEmpleadoDisponible(new Director(dispatcher, "Director 2"));
				dispatcher.dispatchCall(new Llamada(" 13 "));
				dispatcher.dispatchCall(new Llamada(" 14 "));
				dispatcher.dispatchCall(new Llamada(" 15 "));
				dispatcher.dispatchCall(new Llamada(" 16 "));

				//Espero el tiempo maximo para que todas las llamadas hayan sido atendidas:
				//((cant llamadas * tiempo de duracion max de llamada) / cant empleados)
				Thread.sleep((TIEMPO_MAX_LLAMADA_MILISEC * 16)/8);
				
				//Al finalizar este tiempo, las llamdas deberian haber sido atendidas
				assertTrue(dispatcher.getLLamadas().isEmpty());

			} catch (InterruptedException e) {
				e.printStackTrace();
				fail();
			}
	    	
	    }
	}
