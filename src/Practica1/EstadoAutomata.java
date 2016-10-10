/**
 * 
 */
package Practica1;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author Jorge
 *
 */
public class EstadoAutomata {
	
	private String estadoActual;
	private Stack<String> estadoPila;
	private ArrayList<String> estadoCadena;
	private ArrayList<Transicion> transicionesPosibles;
	int nodosAEliminar;
	
	public EstadoAutomata(String estado, Stack<String> estPila, ArrayList<String> estCad, ArrayList<Transicion> tranPosibles){
		
		estadoActual = estado;
		estadoPila = estPila;
		estadoCadena = estCad;
		transicionesPosibles = tranPosibles;
		nodosAEliminar = 1;
		
	}

	//--------------------------------Getters y Setters--------------------------------------------
	
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
