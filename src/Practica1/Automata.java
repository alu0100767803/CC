/**
 * 
 */
package Practica1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

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
	
	private Entrada entradaAutomata;
	private Pila pilaAutomata;
	
	public Automata(String ficheroLeido, String cadena) throws FileNotFoundException{	
		
	// variables para la lectura del fichero 
			File fichero = new File(ficheroLeido);
			Scanner lector = new Scanner(fichero);
			StringTokenizer st = null;
			String cad ;
			boolean comentario = true;
			String token = null;
			//

			
			//Variables para crear el automata de pila
			ArrayList<String> alfabeto = null;
			ArrayList<String> alfabetoPila = null;
			String inicialPila = null;
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
			nodos = new ArrayList<String>();
			nodos.add(token);
			while(st.hasMoreTokens()){
				token = st.nextToken();
				nodos.add(token);
			}
			
			cad = lector.nextLine();
			alfabeto = leerVector(cad);
			cad = lector.nextLine();
			alfabetoPila = leerVector(cad);
			estadoInicial = lector.nextLine();
			inicialPila = lector.nextLine();
			cad = lector.nextLine();
			estadosAceptacion = leerVector(cad);
			/////////////////////////////////////
			
			
			System.out.println(nodos);
			System.out.println(alfabeto);
			System.out.println(alfabetoPila);
			System.out.println(estadoInicial);
			System.out.println(inicialPila);
			System.out.println(estadosAceptacion);
			
			// inicio de componentes
			vectorCadena = new ArrayList<String>(Arrays.asList(cadena.split("")));
			entradaAutomata = new Entrada(vectorCadena, alfabeto);
			pilaAutomata = new Pila(alfabetoPila, inicialPila);
			//////
			System.out.println(vectorCadena);
			
			// Creación de las transiciones
			
			int n;
			int m;
		
	}
	
	public ArrayList<String> leerVector(String cadena){
		ArrayList<String> aux = new ArrayList<String>();
		StringTokenizer st = new StringTokenizer(cadena, " ");
		while (st.hasMoreTokens()) { 
	 		 aux.add(st.nextToken()); 		
			}
		return aux;
	}
	
	public int getFila(String estado){
		for(int i = 0; i < matrizTransiciones[0].length; i++){
			if(getNodos().get(i).equals(estado))
				return i;
		}
		
		System.out.println("No existe el estado: \"" + estado + "\"" );
		System.exit(0);
		// Aqui pedir otra maquina
		return 0;
		
	}
	
	/*public int getColumna(String simbolo){
		for(int i = 0; i < matrizTransiciones.length; i++){
			if(getEntradaAutomata().getAlfabetoEntrada().get(i).equals(simbolo))
				return i;
		}
		
		System.out.println("No existe transicion con el simbolo: \"" + simbolo + "\"" );
		System.exit(0);
		// Aqui mandar a pedir otra cadena
		return 0;
	}*/

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
