/**
 * 
 */
package Practica1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * @author Jorge Alonso Hernandez
 * E-mail: alu0100767803@ull.edu.es
 * Fecha: 28/09/16
 * Asignatura: Complejidad Computacional
 * Comentario: Clase que simulara el automata de pila
 */
public class Controlador {
	
	private Automata automataPila;					// Contiene la simulacion del automata de pila
	private Entrada entradaAutomata;				// Contiene el alfabeto de entrada y la cadena a analizar
	private Pila pilaAutomata;							// Contiene la pila del automata y el alfabeto de la pila 
	
	
	public Controlador(String fichero, String cadena) throws IOException{

	}

	/*private ArrayList<String> leerVector(String linea) {
		ArrayList<String> aux = new ArrayList<String>();
		StringTokenizer st = new StringTokenizer(linea, " ");
		while (st.hasMoreTokens()) { 
 		 aux.add(st.nextToken()); 		
		}
		return aux;
	}
	
	private String leerCaracter(String linea){
		String aux;
		StringTokenizer st = new StringTokenizer(linea, " ");
		aux = st.nextToken();
		if(st.hasMoreTokens()){
			System.out.println("Error, mas de un estado inicial");
			System.exit(0);
		}
		
		return aux;
	}*/


	//------------------------------------------------Getters y Setters-----------------------------

	public Automata getAutomataPila() {
		return automataPila;
	}


	public void setAutomataPila(Automata automataPila) {
		this.automataPila = automataPila;
	}


	public Entrada getEntradaAutomata() {
		return entradaAutomata;
	}


	public void setEntradaAutomata(Entrada entradaAutomata) {
		this.entradaAutomata = entradaAutomata;
	}


	public Pila getPilaAutomata() {
		return pilaAutomata;
	}


	public void setPilaAutomata(Pila pilaAutomata) {
		this.pilaAutomata = pilaAutomata;
	}
	
	
}
