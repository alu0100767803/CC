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
 * Comentario: Clase que simulara la pila del automata de pila
 */
public class Pila {
	
	private Stack<String> pila;								// pila del autómata
	private ArrayList<String> alfabetoPila;		// alfabeto de la pila del autómata
	private String simboloInicial;						// símbolo inicial de la pila del autómata
	
	public Pila(ArrayList<String> alfabeto,String inicial){
		pila = new Stack<String>();
		alfabetoPila = alfabeto;
		simboloInicial = inicial;
		
		if(perteneceAlfabeto(simboloInicial))
			pila.push(simboloInicial);
		else{
			System.out.println("El simbolo inicial no pertenece al alfabeto");
			System.exit(0);
		}
				
	}
	
	/**
	 * Método que devuleve true si el elemento que se le pasa pertenece al alfabeto de la pila
	 * @param elemento
	 * @return
	 */
	public boolean perteneceAlfabeto(String elemento){
		for(int i = 0; i < getAlfabetoPila().size(); i++){
			if(elemento.equals(getAlfabetoPila().get(i)))
				return true;
		}
		return false;
	}

	public Stack<String> getPila() {
		return pila;
	}
	
	/**
	 * Método que insertara un elemento en la pila si este pertenece al alfabeto de la pila
	 * @param elemento
	 */
	public void insertarElemento(String elemento){
		if(perteneceAlfabeto(elemento))
			getPila().push(elemento);
		else
			salirConError(elemento);
	}
	
	/**
	 * Metodo que saldrá del programa si el elemento no pertenece al alfabeto de la pila
	 * @param elemento
	 */
	public void salirConError(String elemento){
		System.out.println("El elemento " + elemento + ", no pertenece al alfabeto de la pila");
		System.exit(0);
	}
	
	/**
	 * Método que devuelve el elemento del top de la pila
	 * @return
	 */
	public String obtenerTop(){
		if(!getPila().isEmpty())
			return getPila().pop();
		else{
			System.out.println("Error: Pila vacía");
			System.exit(0);
			return "E";
		}
			
	}

	
	/*
	 * ---------------------------------------Getters y Setters-------------------------------------
	 */
	public void setPila(Stack<String> pila) {
		this.pila = pila;
	}

	public ArrayList<String> getAlfabetoPila() {
		return alfabetoPila;
	}

	public void setAlfabetoPila(ArrayList<String> alfabetoPila) {
		this.alfabetoPila = alfabetoPila;
	}

	public String getSimboloInicial() {
		return simboloInicial;
	}

	public void setSimboloInicial(String simboloInicial) {
		this.simboloInicial = simboloInicial;
	}

}
