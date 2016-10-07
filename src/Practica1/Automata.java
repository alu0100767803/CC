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
 * Comentario: Clase que contiene el simulador del aut�mata de pila
 */
public class Automata {

	private ArrayList<String> nodos;							// Vector que contiene todos los nodos del aut�mata de pila
	private String estadoInicial;									// Variable que contiene el estado inicial del aut�mata de pila
	private String[] estadosAceptacion;						// Vector con los estados de aceptaci�n del aut�mata de pila
	private Transicion[][] matrizTransiciones; 		// Matriz con las trancisiones de los nodos
	
	
	public Automata(){
		
	}
}
