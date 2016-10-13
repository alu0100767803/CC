/**
 * 
 */
package Practica1;

import java.util.Stack;

/**
 * @author Jorge Alonso Hernandez
 * E-mail: alu0100767803@ull.edu.es
 * Fecha: 28/09/16
 * Asignatura: Complejidad Computacional
 * Comentario: Clase que almacena los estados en los cuales hay m�s de una transici�n posible
 */
public class PilaEjecucion {
	
	private Stack<EstadoAutomata> pilaEjecucion;			// pila donde se ir�n guardando los estados 
																										// del automata donde hayan 
																										// m�s de dos transiciones posibles
	
	public PilaEjecucion(){
		pilaEjecucion = new Stack<EstadoAutomata>();
	}

	/**
	 * M�todo que a�ade un nuevo estado a la pila
	 * @param estAutomata
	 */
	public void intrEstado(EstadoAutomata estAutomata) {
		getPilaEjecucion().push(estAutomata);
	}
	
	/**
	 * M�todo que devuelve true si la pila est� vac�a
	 * @return
	 */
	public boolean pilaVacia(){
		if(getPilaEjecucion().isEmpty())
			return true;
		else
			return false;
	}
	
	/**
	 * M�todo que devuelve el top de la pila
	 * @return
	 */
	public EstadoAutomata obtenerTop(){
			EstadoAutomata aux = getPilaEjecucion().get(getPilaEjecucion().size() - 1);
			getPilaEjecucion().pop();
		return aux;
	}
	
	/*
	 * -------------------------Getters y Setters---------------------------------------------------
	 */
	
	public Stack<EstadoAutomata> getPilaEjecucion() {
		return pilaEjecucion;
	}

	public void setPilaEjecucion(Stack<EstadoAutomata> pilaEjecucion) {
		this.pilaEjecucion = pilaEjecucion;
	}

}
