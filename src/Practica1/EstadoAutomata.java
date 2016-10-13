/**
 * 
 */
package Practica1;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author Jorge Alonso Hernandez
 * E-mail: alu0100767803@ull.edu.es
 * Fecha: 28/09/16
 * Asignatura: Complejidad Computacional
 * Comentario: Clase que alberga el estado de la ejecución del automata en un determinado momento
 */
public class EstadoAutomata {
	
	private String estadoActual;													// estado en el que se encuentra el automata
	private Stack<String> estadoPila;											// estado de la pila del automata
	private ArrayList<String> estadoCadena;								// estado de la cadena de entrada en el momento
	private ArrayList<Transicion> transicionesPosibles;		// transiciones posibles del estado en el que se encuentra
	int nodosAEliminar;																		// nodos que se han comprobado de las transiciones posibles
	
	public EstadoAutomata(String estado, Stack<String> estPila, ArrayList<String> estCad, ArrayList<Transicion> tranPosibles){
		
		estadoActual = estado;
		estadoPila = estPila;
		estadoCadena = estCad;
		transicionesPosibles = tranPosibles;
		nodosAEliminar = 0;
	}
	

	/*
	 * --------------------------------Getters y Setters--------------------------------------------
	 */
	
	public String getEstadoActual() {
		return estadoActual;
	}

	public void setEstadoActual(String estadoActual) {
		this.estadoActual = estadoActual;
	}

	public Stack<String> getEstadoPila() {
		return estadoPila;
	}

	public void setEstadoPila(Stack<String> estadoPila) {
		this.estadoPila = estadoPila;
	}

	public ArrayList<String> getEstadoCadena() {
		return estadoCadena;
	}

	public void setEstadoCadena(ArrayList<String> estadoCadena) {
		this.estadoCadena = estadoCadena;
	}

	public ArrayList<Transicion> getTransicionesPosibles() {
		return transicionesPosibles;
	}

	public void setTransicionesPosibles(ArrayList<Transicion> transicionesPosibles) {
		this.transicionesPosibles = transicionesPosibles;
	}

	public int getNodosAEliminar() {
		return nodosAEliminar;
	}

	public void setNodosAEliminar(int nodosAEliminar) {
		this.nodosAEliminar = nodosAEliminar;
	}

	
}
