/**
 * 
 */
package Practica1;

import java.util.ArrayList;

/**
 * @author Jorge Alonso Hernandez
 * E-mail: alu0100767803@ull.edu.es
 * Fecha: 28/09/16
 * Asignatura: Complejidad Computacional
 * Comentario: Clase que contiene el simulador del autómata de pila
 */
public class Automata {

	private ArrayList<String> nodos;																					// Vector que contiene todos los nodos del autómata de pila
	private String estadoInicial;																							// Variable que contiene el estado inicial del autómata de pila
	private ArrayList<String> estadosAceptacion;															// Vector con los estados de aceptación del autómata de pila
	//private ArrayList<ArrayList<ArrayList<Transicion>>> matrizTransiciones; 	// Matriz con las trancisiones de los nodos
	private Transiciones[][] matrizTransiciones;
	
	public Automata(String inicial, ArrayList<String> nodos, ArrayList<String> aceptacion){
		
		//matrizTransiciones = new Transiciones[n][m];
		this.nodos = nodos;
		estadoInicial = inicial;
		estadosAceptacion = aceptacion;
		
	}

	//--------------------------------------Getters y Setters---------------------------------------

	public ArrayList<String> getNodos() {
		return nodos;
	}


	public void setNodos(ArrayList<String> nodos) {
		this.nodos = nodos;
	}


	public String getEstadoInicial() {
		return estadoInicial;
	}


	public void setEstadoInicial(String estadoInicial) {
		this.estadoInicial = estadoInicial;
	}


	public ArrayList<String> getEstadosAceptacion() {
		return estadosAceptacion;
	}


	public void setEstadosAceptacion(ArrayList<String> estadosAceptacion) {
		this.estadosAceptacion = estadosAceptacion;
	}

	public Transiciones[][] getMatrizTransiciones() {
		return matrizTransiciones;
	}

	public void setMatrizTransiciones(Transiciones[][] matrizTransiciones) {
		this.matrizTransiciones = matrizTransiciones;
	}

	
}
