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
 * Comentario: Clase que contiene el simulador del aut�mata de pila
 */
public class Automata {

	private ArrayList<String> nodos;																					// Vector que contiene todos los nodos del aut�mata de pila
	private String estadoInicial;																							// Variable que contiene el estado inicial del aut�mata de pila
	private ArrayList<String> estadosAceptacion;															// Vector con los estados de aceptaci�n del aut�mata de pila
	//private ArrayList<ArrayList<ArrayList<Transicion>>> matrizTransiciones; 	// Matriz con las trancisiones de los nodos
	private ArrayList<ArrayList<Transicion>> matrizTransiciones;
	
	private Entrada entradaAutomata;
	private Pila pilaAutomata;
	
	public Automata(String ficheroLeido, String cadena) throws FileNotFoundException{	
		
		lecturaFichero(ficheroLeido, cadena);
		
	}
	
	/**
	 * M�todo que lee el fichero e inicializa los componentes
	 * @param ficheroLeido
	 * @param cadena
	 * @throws FileNotFoundException
	 */
	public void lecturaFichero(String ficheroLeido, String cadena) throws FileNotFoundException{
		// variables para la lectura del fichero 
		File fichero = new File(ficheroLeido);
		Scanner lector = new Scanner(fichero);
		StringTokenizer st = null;
		String cad ;
		boolean comentario = true;
		String token = null;
		//
		
		// Variables para crear componentes del automata de pila
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
		//
		
		// lectura de los componentes del automata
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
		//
		
		
		// inicio de componentes
		vectorCadena = new ArrayList<String>(Arrays.asList(cadena.split("")));
		entradaAutomata = new Entrada(vectorCadena, alfabeto);
		pilaAutomata = new Pila(alfabetoPila, inicialPila);
		//
		
		// lectura de las transiciones
		matrizTransiciones = new ArrayList<ArrayList<Transicion>>();
		while(lector.hasNextLine()){
			cad = lector.nextLine();
			ArrayList<String> aux = leerVector(cad);
			anyadirTransicion(aux);
		}
		
		mostrarTransiciones();
	}
	
	/**
	 * M�todo que a�ade una transicion al nodo que pertenece
	 * @param aux
	 */
	public void anyadirTransicion(ArrayList<String> aux){
		int nodo = obtenerIndiceNodo(aux.get(0));
		String elemCadena = aux.get(1);
		String elemPila = aux.get(2);
		String nodoDestino = aux.get(3);
		ArrayList<String> intrPila = new ArrayList<String>();
		for(int i = 4; i < aux.size(); i++)
			intrPila.add(aux.get(i));
		
		Transicion transicion = new Transicion(nodoDestino, elemCadena, elemPila, intrPila);
		
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
	
	/**
	 * M�todo que devuelve el indice del nodo 
	 * @param nodo
	 * @return
	 */
	public int obtenerIndiceNodo(String nodo){
		for(int i = 0; i < getNodos().size(); i++)
			if(getNodos().get(i).equals(nodo))
				return i;
		// Poner excepcion por si no existe el nodo
		return -1;
	}
	
	/**
	 * M�todo que lee una fila por fichero y devuelve un vector de String de la cadena
	 * @param cadena
	 * @return
	 */
	public ArrayList<String> leerVector(String cadena){
		ArrayList<String> aux = new ArrayList<String>();
		StringTokenizer st = new StringTokenizer(cadena, " ");
		while (st.hasMoreTokens()) { 
	 		 aux.add(st.nextToken()); 		
			}
		return aux;
	}
	
	/**
	 * M�todo que muestra por pantalla todas las transiciones del aut�mata
	 */
	public void mostrarTransiciones(){
		mostrarElementosAutomata();
		for(int i = 0; i < getMatrizTransiciones().size(); i++){
			for(int j = 0; j < getMatrizTransiciones().get(i).size();j++){
				System.out.print("Desde " + getNodos().get(i));
				System.out.print(" con el simbolo " + obtenerTransicion(i, j).getElemCadena());
				System.out.print(" y el simbolo " + obtenerTransicion(i, j).getElemPila() + " en la pila ");
				System.out.print(" Voy al nodo " + obtenerTransicion(i, j).getNodo());
				System.out.print(" e introduzco en la pila ");
				for(int k = 0; k < obtenerTransicion(i, j).getIntrPila().size(); k++){
					System.out.print(obtenerTransicion(i, j).getIntrPila().get(k) + " ");
				}
				
				System.out.println();
			}
		}
	}
	
	/**
	 * M�todo que muestra los elementos del aut�mata
	 */
	public void mostrarElementosAutomata(){
		System.out.println("Cadena de entrada: " + getEntradaAutomata().getCadena());
		System.out.println("Estados del automata: " + getNodos());
		System.out.println("Alfabeto de la entrada: " + getEntradaAutomata().getAlfabetoEntrada());
		System.out.println("Alfabeto de la pila: " + getPilaAutomata().getAlfabetoPila());
		System.out.println("Estado inicial :" + getEstadoInicial());
		System.out.println("Simbolo inicial de la pila: " + getPilaAutomata().getSimboloInicial());
		System.out.println("Estados de aceptaci�n: " + getEstadosAceptacion());
	}
	
	/**
	 * M�todo que devuelve una transicion
	 * @param i
	 * @param j
	 * @return
	 */
	public Transicion obtenerTransicion(int i, int j){
		return getMatrizTransiciones().get(i).get(j);
	}
	
	/**
	 * M�todo que va a ejecutar el aut�mata y comprueba la cadena de entrada
	 */
	public void ejecutar(){
		
		PilaEjecucion pilaEjecucion = new PilaEjecucion();
		
		String estadoActual = getEstadoInicial();
		ArrayList<Transicion> transicionesPosibles = null;
		EstadoAutomata estAutomata;
		
		boolean bucle = true;
		
		/////bucle
		while(bucle){
				transicionesPosibles = buscarTransiciones(estadoActual, obtenerElemCadena(), obtenerTopPila());
				System.out.print(" Estado: " + estadoActual);
				System.out.print(" Elem cad: " + obtenerElemCadena());
				System.out.print(" Elem pila: " + obtenerTopPila());
				System.out.println();
				//System.out.println("numero de transiciones posibles: " + transicionesPosibles.size());
				if(transicionesPosibles.isEmpty()){
					if(pilaEjecucion.pilaVacia()){
						if(getEntradaAutomata().getCadena().isEmpty()  && isAceptacion(estadoActual)){
							getEntradaAutomata().setCadenaAceptada(true);
							bucle = false;
							System.out.println("Entro1");
						}
						else{
							getEntradaAutomata().setCadenaAceptada(false);
							bucle = false;
							System.out.println("Entro2");
						}
					}
					
				}
				else if(transicionesPosibles.size() > 1){
				estAutomata = new EstadoAutomata(estadoActual, getPilaAutomata().getPila(), getEntradaAutomata().getCadena(), transicionesPosibles);
				pilaEjecucion.intrEstado(estAutomata);
				
				//transitar
				estadoActual = transicionesPosibles.get(0).getNodo();
				if(!getEntradaAutomata().getCadena().get(0).equals(getEntradaAutomata().getVACIO()))
					getEntradaAutomata().elimElem();
				if(!getPilaAutomata().obtenerTop().equals(getPilaAutomata().getVACIO()))
					getPilaAutomata().eliminalElemento();
				for(int i = transicionesPosibles.get(0).getIntrPila().size() - 1; i >= 0; i--){
					if(!transicionesPosibles.get(0).getIntrPila().get(i).equals(getPilaAutomata().getVACIO()))
						getPilaAutomata().insertarElemento(transicionesPosibles.get(0).getIntrPila().get(i));
				}
				//
			}
			
			else if(transicionesPosibles.size() == 1){
				estadoActual = transicionesPosibles.get(0).getNodo();
				if(!getEntradaAutomata().getCadena().get(0).equals(getEntradaAutomata().getVACIO()))
					getEntradaAutomata().elimElem();
				if(!getPilaAutomata().obtenerTop().equals(getPilaAutomata().getVACIO()))
					getPilaAutomata().eliminalElemento();
				for(int i = transicionesPosibles.get(0).getIntrPila().size() - 1; i >= 0; i--){
					if(!transicionesPosibles.get(0).getIntrPila().get(i).equals(getPilaAutomata().getVACIO()))
						getPilaAutomata().insertarElemento(transicionesPosibles.get(0).getIntrPila().get(i));
				}
			}
			
			else{
				EstadoAutomata aux = pilaEjecucion.obtenerTop();
				estadoActual = aux.getEstadoActual();
				getPilaAutomata().setPila(aux.getEstadoPila());
				//nodosAEliminar = aux.getNodosAEliminar();
				
			}
			//
		}
		
		if(getEntradaAutomata().isCadenaAceptada())
			System.out.println("Cadena aceptada");
		else
			System.out.println("Cadena rechazada");
		
	}
	
	public boolean isAceptacion(String nodo){
		for(int i = 0; i < getEstadosAceptacion().size(); i++)
			if(nodo.equals(getEstadosAceptacion().get(i)))
				return true;
		return false;
	}
	
	public String obtenerTopPila(){
		return getPilaAutomata().obtenerTop();
	}
	
	public String obtenerElemCadena(){
		if(getEntradaAutomata().getCadena().isEmpty())
			return "";
		else
			return getEntradaAutomata().getCadena().get(0);
	}
	
	public ArrayList<Transicion> buscarTransiciones(String estado, String elemCad, String elemPila){
		ArrayList<Transicion> aux = new ArrayList<Transicion>();
		if(elemCad.isEmpty()){
			return aux;
		}
		else{
			Transicion transicion = null;
			int nodo = obtenerIndiceNodo(estado);
			for(int i = 0; i < getMatrizTransiciones().get(nodo).size(); i++){
				if(getMatrizTransiciones().get(nodo).get(i).getElemCadena().equals(elemCad) 
						&& getMatrizTransiciones().get(nodo).get(i).getElemPila().equals(elemPila)){
					transicion = getMatrizTransiciones().get(nodo).get(i); 
					aux.add(transicion);
				}
			}
		}
		/*for(int i = 0; i < elim; i++)
			if(aux.size() > 0)
				aux.remove(0);*/
		return aux;
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
