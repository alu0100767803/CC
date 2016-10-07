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

	private ArrayList<String> nodos;							// Vector que contiene todos los nodos del autómata de pila
	private String estadoInicial;									// Variable que contiene el estado inicial del autómata de pila
	private String[] estadosAceptacion;						// Vector con los estados de aceptación del autómata de pila
	private Transicion[][] matrizTransiciones; 		// Matriz con las trancisiones de los nodos
	
	
	public Automata(){
		
	}
}
