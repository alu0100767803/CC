/**
 * 
 */
package Practica1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
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
	
	
	public Controlador(String ficheroLeido, String cadena) throws IOException{

		// variables para la lectura del fichero 
		File fichero = new File(ficheroLeido);
		Scanner lector = new Scanner(fichero);
		StringTokenizer st = null;
		String cad ;
		boolean comentario = true;
		String token = null;
		//

		
		//Variables para crear el automata de pila
		ArrayList<String> estados = new ArrayList<String>();
		ArrayList<String> alfabeto = null;
		ArrayList<String> alfabetoPila = null;
		String estadoInicial = null;
		String inicialPila = null;
		ArrayList<String> estadosFinales = null;
		ArrayList<String> vectorCadena = null;
		///
		
		
		// Ignorar los comentarios iniciales
		while(lector.hasNextLine() && comentario){
			cad = lector.nextLine();
			st = new StringTokenizer(cad, " ");
			token = st.nextToken();
			if(token.equals("#"))
				comentario = true;
			else
				comentario = false;
		}
		//////////////// lectura de los componentes del automata
		estados.add(token);
		while(st.hasMoreTokens()){
			token = st.nextToken();
			estados.add(token);
		}
		
		cad = lector.nextLine();
		alfabeto = leerVector(cad);
		cad = lector.nextLine();
		alfabetoPila = leerVector(cad);
		estadoInicial = lector.nextLine();
		inicialPila = lector.nextLine();
		cad = lector.nextLine();
		estadosFinales = leerVector(cad);
		/////////////////////////////////////
		
		
		System.out.println(estados);
		System.out.println(alfabeto);
		System.out.println(alfabetoPila);
		System.out.println(estadoInicial);
		System.out.println(inicialPila);
		System.out.println(estadosFinales);
		
		// inicio de componentes
		vectorCadena = new ArrayList<String>(Arrays.asList(cadena.split("")));
		entradaAutomata = new Entrada(vectorCadena, alfabeto);
		pilaAutomata = new Pila(alfabetoPila, inicialPila);
		automataPila = new Automata(estadoInicial, estados, estadosFinales);
		//////
		System.out.println(vectorCadena);
	}
	
	public ArrayList<String> leerVector(String cadena){
		ArrayList<String> aux = new ArrayList<String>();
		StringTokenizer st = new StringTokenizer(cadena, " ");
		while (st.hasMoreTokens()) { 
	 		 aux.add(st.nextToken()); 		
			}
		return aux;
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
