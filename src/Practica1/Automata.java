/**
 * 
 */
package Practica1;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
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
	private ArrayList<ArrayList<Transicion>> matrizTransiciones;
	
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
			matrizTransiciones = new ArrayList<ArrayList<Transicion>>();
			while(lector.hasNextLine()){
				cad = lector.nextLine();
				ArrayList<String> aux = leerVector(cad);
				anyadirTransicion(aux);
			}
			
			mostrarTransiciones();
		
	}
	
	public void anyadirTransicion(ArrayList<String> aux){
		int nodo = obtenerIndiceNodo(aux.get(0));
		String elemCadena = aux.get(1);
		String elemPila = aux.get(2);
		String nodoDestino = aux.get(3);
		ArrayList<String> intrPila = new ArrayList<String>();
		for(int i = 4; i < aux.size(); i++)
			intrPila.add(aux.get(i));
		
		Transicion transicion = new Transicion(nodoDestino, elemCadena, elemPila, intrPila);
		System.out.println(nodo);
		if(getMatrizTransiciones().isEmpty()){
			ArrayList<Transicion> auxiliar = new ArrayList<Transicion>();
			auxiliar.add(transicion);
			getMatrizTransiciones().add(auxiliar);
		}
		
		else if(nodo >= getMatrizTransiciones().size()){
			ArrayList<Transicion> auxiliar = new ArrayList<Transicion>();
			auxiliar.add(transicion);
			getMatrizTransiciones().add(auxiliar);
		}
		else
			getMatrizTransiciones().get(nodo).add(transicion);
	}
	
	public int obtenerIndiceNodo(String nodo){
		for(int i = 0; i < getNodos().size(); i++)
			if(getNodos().get(i).equals(nodo))
				return i;
		// Poner excepcion por si no existe el nodo
		return -1;
	}
	
	public ArrayList<String> leerVector(String cadena){
		ArrayList<String> aux = new ArrayList<String>();
		StringTokenizer st = new StringTokenizer(cadena, " ");
		while (st.hasMoreTokens()) { 
	 		 aux.add(st.nextToken()); 		
			}
		return aux;
	}
	
	public void mostrarTransiciones(){
		for(int i = 0; i < getMatrizTransiciones().size(); i++){
			for(int j = 0; j < getMatrizTransiciones().get(i).size();j++){
				System.out.print("Desde " + getNodos().get(i));
				System.out.print(" con el simbolo " + getMatrizTransiciones().get(i).get(j).getElemCadena());
				System.out.print(" y el simbolo " + getMatrizTransiciones().get(i).get(j).getElemPila() + " en la pila ");
				System.out.print(" Voy al nodo " + getMatrizTransiciones().get(i).get(j).getNodo());
				System.out.print(" e introduzco en la pila ");
				for(int k = 0; k < getMatrizTransiciones().get(i).get(j).getIntrPila().size(); k++){
					System.out.print(getMatrizTransiciones().get(i).get(j).getIntrPila().get(k) + " ");
				}
				
				System.out.println();
			}
		}
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

	public ArrayList<ArrayList<Transicion>> getMatrizTransiciones() {
		return matrizTransiciones;
	}

	public void setMatrizTransiciones(ArrayList<ArrayList<Transicion>> matrizTransiciones) {
		this.matrizTransiciones = matrizTransiciones;
	}

	
}
