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
 * Comentario: Clase que almacena los estados en los cuales hay más de una transición posible
 */
public class PilaEjecucion {
	
	private Stack<EstadoAutomata> pilaEjecucion;			// pila donde se irán guardando los estados 
																										// del automata donde hayan 
																										// más de dos transiciones posibles
	
	public PilaEjecucion(){
		pilaEjecucion = new Stack<EstadoAutomata>();
	}

	/**
	 * Método que añade un nuevo estado a la pila
	 * @param estAutomata
	 */
	public void intrEstado(EstadoAutomata estAutomata) {
		getPilaEjecucion().push(estAutomata);
	}
	
	/**
	 * Método que devuelve true si la pila está vacía
	 * @return
	 */
	public boolean pilaVacia(){
		if(getPilaEjecucion().isEmpty())
			return true;
		else
			return false;
	}
	
	/**
	 * Método que devuelve el top de la pila
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
