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
	
	private final String VACIO = ".";					// Simbolo que representa el no consumir elemento de la pila
	
	private Stack<String> pila;								// pila del aut�mata
	private ArrayList<String> alfabetoPila;		// alfabeto de la pila del aut�mata
	private String simboloInicial;						// s�mbolo inicial de la pila del aut�mata
	
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
	 * M�todo que devuleve true si el elemento que se le pasa pertenece al alfabeto de la pila
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
	
	/**
	 * M�todo que insertara un elemento en la pila si este pertenece al alfabeto de la pila
	 * @param elemento
	 */
	public void insertarElemento(String elemento){
		if(perteneceAlfabeto(elemento))
			getPila().push(elemento);
		else
			salirConError(elemento);
	}
	
	/**
	 * M�todo que elimina el �ltimo elemento de la pila
	 */
	public void eliminarElemento(){
		getPila().pop();
	}
	
	/**
	 * Metodo que saldr� del programa si el elemento no pertenece al alfabeto de la pila
	 * @param elemento
	 */
	public void salirConError(String elemento){
		System.out.println("El elemento " + elemento + ", no pertenece al alfabeto de la pila");
		System.exit(0);
	}
	
	/**
	 * M�todo que devuelve el elemento del top de la pila
	 * @return
	 */
	public String obtenerTop(){
		if(!getPila().isEmpty())
			return getPila().get(getPila().size() - 1);
		else{
			System.out.println("Error: Pila vac�a");
			System.exit(0);
			return "E";
		}
			
	}
	
	/**
	 * M�todo para reiniciar la pila para una determinada cadena
	 */
	public void iniciarPila(){
		Stack<String> aux = new Stack<String>();
		aux.push(getSimboloInicial());
		setPila(aux);
	}

	/*
	 * ---------------------------------------Getters y Setters-------------------------------------
	 */
	
	public Stack<String> getPila() {
		return pila;
	}
	
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

	public String getVACIO() {
		return VACIO;
	}

}
