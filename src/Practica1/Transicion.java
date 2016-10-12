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
 * Comentario: Clase que alberga una transicion de un determinado estado
 */
public class Transicion {
	
	private String nodo;								// Nodo destino de la transicion
	private String elemCadena;					// Elemento de la cadena con el que se transita
	private String elemPila;						// Elemento de la pila con el que se produce la transicion
	private ArrayList<String> intrPila;	//Elementos que son introducidos en la pila
	
	public Transicion(String nodo, String elemCadena, String elemPila, ArrayList<String> intrPila){
		this.nodo = nodo;
		this.elemCadena = elemCadena;
		this.elemPila = elemPila;
		this.intrPila = intrPila;
	}

	/*
	 * ---------------------------------------Getters y Setters-------------------------------------
	 */

	public String getElemPila() {
		return elemPila;
	}

	public String getNodo() {
		return nodo;
	}

	public void setNodo(String nodo) {
		this.nodo = nodo;
	}

	public void setElemPila(String elemPila) {
		this.elemPila = elemPila;
	}

	public String getElemCadena() {
		return elemCadena;
	}

	public void setElemCadena(String elemCadena) {
		this.elemCadena = elemCadena;
	}

	public ArrayList<String> getIntrPila() {
		return intrPila;
	}

	public void setIntrPila(ArrayList<String> intrPila) {
		this.intrPila = intrPila;
	}
	
}
