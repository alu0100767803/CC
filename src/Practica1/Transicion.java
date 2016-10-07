/**
 * 
 */
package Practica1;

/**
 * @author Jorge
 *
 */
public class Transicion {
	
	private int nodo;					// Nodo destino de la transicion
	private String elemPila;	// Elemento de la pila con el que se produce la transicion
	
	public Transicion(int nodo, String elemento){
		this.nodo = nodo;
		elemPila = elemento;	
	}

	//---------------------------------------Getter y Setters---------------------------------------
	
	public int getNodo() {
		return nodo;
	}

	public void setNodo(int nodo) {
		this.nodo = nodo;
	}

	public String getElemPila() {
		return elemPila;
	}

	public void setElemPila(String elemPila) {
		this.elemPila = elemPila;
	}
}
