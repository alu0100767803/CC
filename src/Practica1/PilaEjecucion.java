/**
 * 
 */
package Practica1;

import java.util.Stack;

/**
 * @author Jorge
 *
 */
public class PilaEjecucion {
	
	private Stack<EstadoAutomata> pilaEjecucion;
	
	public PilaEjecucion(){
		pilaEjecucion = new Stack<EstadoAutomata>();
	}

	public void intrEstado(EstadoAutomata estAutomata) {
		getPilaEjecucion().push(estAutomata);
		
	}
	
	public boolean pilaVacia(){
		if(getPilaEjecucion().isEmpty())
			return true;
		else
			return false;
	}
	
	public EstadoAutomata obtenerTop(){
		EstadoAutomata aux = getPilaEjecucion().get(getPilaEjecucion().size() - 1);
		getPilaEjecucion().pop();
		return aux;
	}
	//-------------------------Getters y Setters---------------------------------------------------
	
	public Stack<EstadoAutomata> getPilaEjecucion() {
		return pilaEjecucion;
	}

	public void setPilaEjecucion(Stack<EstadoAutomata> pilaEjecucion) {
		this.pilaEjecucion = pilaEjecucion;
	}

}
