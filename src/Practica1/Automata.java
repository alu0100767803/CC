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

	private ArrayList<String> nodos;															// Vector que contiene todos los nodos del autómata de pila
	private String estadoInicial;																	// Variable que contiene el estado inicial del autómata de pila
	private ArrayList<String> estadosAceptacion;									// Vector con los estados de aceptación del autómata de pila
	private ArrayList<ArrayList<Transicion>> matrizTransiciones;	// Matriz con las trancisiones de los nodos	
	private Entrada entradaAutomata;															// Variable que contiene todos los elementos de la cadena de entrada
	private Pila pilaAutomata;																		// Variable que contiene todos los elementos de la pila del automata									
	
	public Automata(String ficheroLeido, ArrayList<String> cadena) throws FileNotFoundException{	
		
		lecturaFichero(ficheroLeido, cadena);
		
	}
	
	/**
	 * Método que lee el fichero e inicializa los componentes
	 * @param ficheroLeido
	 * @param cadena
	 * @throws FileNotFoundException
	 */
	public void lecturaFichero(String ficheroLeido, ArrayList<String> cadena) throws FileNotFoundException{
		// variables para la lectura del fichero 
		File fichero = new File(ficheroLeido);
		Scanner lector = new Scanner(fichero);
		StringTokenizer st = null;
		String cad ;
		boolean comentario = true;
		String token = null;
		
		// Variables para crear componentes del automata de pila
		ArrayList<String> alfabeto = null;
		ArrayList<String> alfabetoPila = null;
		String inicialPila = null;
		ArrayList<String> vectorCadena = cadena;
			
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
		
		// lectura de los componentes del automata
		setNodos(new ArrayList<String>());
		getNodos().add(token);
		while(st.hasMoreTokens()){
			token = st.nextToken();
			getNodos().add(token);
		}
		
		cad = lector.nextLine();
		alfabeto = leerVector(cad);
		cad = lector.nextLine();
		alfabetoPila = leerVector(cad);
		setEstadoInicial(lector.nextLine());
		inicialPila = lector.nextLine();
		cad = lector.nextLine();
		setEstadosAceptacion(leerVector(cad));	
		
		// inicio de componentes
		setEntradaAutomata(new Entrada(vectorCadena, alfabeto));
		setPilaAutomata(new Pila(alfabetoPila, inicialPila));
		
		// lectura de las transiciones
		setMatrizTransiciones(new ArrayList<ArrayList<Transicion>>());
		while(lector.hasNextLine()){
			cad = lector.nextLine();
			ArrayList<String> aux = leerVector(cad);
			anyadirTransicion(aux);
		}
		
		System.out.println("Numero de nodos en getMatrices: " + getMatrizTransiciones().size());
		mostrarTransiciones();
	}
	
	/**
	 * Método que añade una transicion al nodo que pertenece
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
	 * Método que devuelve el indice del nodo 
	 * @param nodo
	 * @return
	 */
	public int obtenerIndiceNodo(String nodo){
		for(int i = 0; i < getNodos().size(); i++)
			if(getNodos().get(i).equals(nodo))
				return i;
		System.out.println("No existe transicion");
		System.exit(0);
		return -1;
	}
	
	/**
	 * Método que lee una fila por fichero y devuelve un vector de String de la cadena
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
	 * Método que muestra por pantalla todas las transiciones del autómata
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
	 * Método que muestra los elementos del autómata
	 */
	public void mostrarElementosAutomata(){
		System.out.println("Cadena de entrada: " + getEntradaAutomata().getCadena());
		System.out.println("Estados del automata: " + getNodos());
		System.out.println("Alfabeto de la entrada: " + getEntradaAutomata().getAlfabetoEntrada());
		System.out.println("Alfabeto de la pila: " + getPilaAutomata().getAlfabetoPila());
		System.out.println("Estado inicial :" + getEstadoInicial());
		System.out.println("Simbolo inicial de la pila: " + getPilaAutomata().getSimboloInicial());
		System.out.println("Estados de aceptación: " + getEstadosAceptacion());
	}
	
	/**
	 * Método que devuelve una transicion
	 * @param i
	 * @param j
	 * @return
	 */
	public Transicion obtenerTransicion(int i, int j){
		return getMatrizTransiciones().get(i).get(j);
	}
	
	/**
	 * Método que va a ejecutar el autómata y comprueba la cadena de entrada
	 */
	public void ejecutar(){
		
		PilaEjecucion pilaEjecucion = new PilaEjecucion();
		
		String estadoActual = getEstadoInicial();
		ArrayList<Transicion> transicionesPosibles = null;
		EstadoAutomata estAutomata;
		int nodosAEliminar = 0;	
		boolean bucle = true;
		
		while(bucle){
				transicionesPosibles = buscarTransiciones(estadoActual, obtenerElemCadena(), obtenerTopPila(), nodosAEliminar);
				System.out.print(" Estado: " + estadoActual);
				System.out.print(" Elem cad: " + obtenerElemCadena());
				System.out.print(" Elem pila: " + obtenerTopPila());
				System.out.print(" Transiciones posibles: " + transicionesPosibles.size());
				System.out.println();
				
				if(transicionesPosibles.isEmpty()){
						if(getEntradaAutomata().getCadena().isEmpty()  && isAceptacion(estadoActual)){
							getEntradaAutomata().setCadenaAceptada(true);
							bucle = false;
								System.out.println("Cadena aceptada");
								
						}
						else if(getEntradaAutomata().getCadena().isEmpty() && !isAceptacion(estadoActual)){
							getEntradaAutomata().setCadenaAceptada(false);
							bucle = false;
							System.out.println("Cadena rechazada");
						}
						else{
							if(!pilaEjecucion.pilaVacia()){
								System.out.println("Fallo aqui");
								EstadoAutomata aux = pilaEjecucion.obtenerTop();
								estadoActual = aux.getEstadoActual();
								getPilaAutomata().setPila(aux.getEstadoPila());
								nodosAEliminar = aux.getNodosAEliminar();
							}
							else{
								getEntradaAutomata().setCadenaAceptada(false);
								bucle = false;
								System.out.println("Cadena rechazada");
							}
							
						}
					
				}
				
				else if(transicionesPosibles.size() > 1){
					estAutomata = new EstadoAutomata(estadoActual, getPilaAutomata().getPila(), getEntradaAutomata().getCadena(), transicionesPosibles);
					estAutomata.setNodosAEliminar(nodosAEliminar + 1);
					pilaEjecucion.intrEstado(estAutomata);
					System.out.println("Estoy trabado aqui");
					estadoActual = transicionesPosibles.get(0).getNodo();
					if(!getEntradaAutomata().getCadena().isEmpty())
						getEntradaAutomata().elimElem();
					if(!getPilaAutomata().getAlfabetoPila().isEmpty())
						getPilaAutomata().eliminalElemento();
					for(int i = transicionesPosibles.get(0).getIntrPila().size() - 1; i >= 0; i--){
						if(!transicionesPosibles.get(0).getIntrPila().get(i).equals(getPilaAutomata().getVACIO()))
							getPilaAutomata().insertarElemento(transicionesPosibles.get(0).getIntrPila().get(i));
					}
			}
			
			else if(transicionesPosibles.size() == 1){
				estadoActual = transicionesPosibles.get(0).getNodo();
				if(!getEntradaAutomata().getCadena().isEmpty())
					getEntradaAutomata().elimElem();
				if(!getPilaAutomata().getAlfabetoPila().isEmpty())
					getPilaAutomata().eliminalElemento();
				for(int i = transicionesPosibles.get(0).getIntrPila().size() - 1; i >= 0; i--){
					if(!transicionesPosibles.get(0).getIntrPila().get(i).equals(getPilaAutomata().getVACIO()))
						getPilaAutomata().insertarElemento(transicionesPosibles.get(0).getIntrPila().get(i));
				}
				nodosAEliminar = 0;
			}
		}
		
	}
	
	/**
	 * Método que devuelve si el estado es un estado de aceptacion
	 * @param nodo
	 * @return
	 */
	public boolean isAceptacion(String nodo){
		for(int i = 0; i < getEstadosAceptacion().size(); i++)
			if(nodo.equals(getEstadosAceptacion().get(i)))
				return true;
		return false;
	}
	
	/**
	 * Método que devuelve el top de la pila del automata
	 * @return
	 */
	public String obtenerTopPila(){
		return getPilaAutomata().obtenerTop();
	}
	
	/**
	 * Método que devuelve el primer elemento de la cadena de entrada
	 * @return
	 */
	public String obtenerElemCadena(){
		if(getEntradaAutomata().getCadena().isEmpty())
			return "";
		else
			return getEntradaAutomata().getCadena().get(0);
	}
	
	/**
	 * Método que devuelve las transiciones posibles de ese nodo con el elemento de la cadena y de la pil actual
	 * @param estado
	 * @param elemCad
	 * @param elemPila
	 * @param eliminar
	 * @return
	 */
	public ArrayList<Transicion> buscarTransiciones(String estado, String elemCad, String elemPila, int eliminar){
		ArrayList<Transicion> aux = new ArrayList<Transicion>();
		Transicion transicion = null;
		int nodo = obtenerIndiceNodo(estado);
		
		if(getMatrizTransiciones().size() > nodo){
			if(elemCad.isEmpty()){
				//System.out.println("Entro");
				for(int i = 0; i < getMatrizTransiciones().get(nodo).size(); i++){
					if(getMatrizTransiciones().get(nodo).get(i).getElemCadena().equals(getEntradaAutomata().getVACIO()) 
							&& (getMatrizTransiciones().get(nodo).get(i).getElemPila().equals(elemPila)) 
								|| getMatrizTransiciones().get(nodo).get(i).getElemPila().equals(getPilaAutomata().getVACIO())){
						transicion = getMatrizTransiciones().get(nodo).get(i);
							//System.out.println("Entro cadena vacia");
							aux.add(transicion);
					}
					//System.out.println("Aux: " + aux.size());
				}
			}
			else{
				
				for(int i = 0; i < getMatrizTransiciones().get(nodo).size(); i++){
					if(getMatrizTransiciones().get(nodo).get(i).getElemCadena().equals(elemCad) 
							&& (getMatrizTransiciones().get(nodo).get(i).getElemPila().equals(elemPila) 
									|| getMatrizTransiciones().get(nodo).get(i).getElemPila().equals(getPilaAutomata().getVACIO()))){
						transicion = getMatrizTransiciones().get(nodo).get(i); 
						aux.add(transicion);
					
					}
					if(getMatrizTransiciones().get(nodo).get(i).getElemCadena().equals(getEntradaAutomata().getVACIO()) 
							&& (getMatrizTransiciones().get(nodo).get(i).getElemPila().equals(elemPila))
								|| getMatrizTransiciones().get(nodo).get(i).getElemPila().equals(getPilaAutomata().getVACIO())){
						transicion = getMatrizTransiciones().get(nodo).get(i); 
						aux.add(transicion);
					}
				}
			}
		}
		for(int i = 0; i < eliminar; i++)
			aux.remove(0);
		return aux;
	}
	
	/**
	 * Método que reinicia la cadena de entrada y la pila para probar una nueva cadena
	 * @param cadena
	 */
	public void reiniciarElemCad(ArrayList<String> cadena){
		getEntradaAutomata().reiniciarCadena(cadena);
		getPilaAutomata().iniciarPila();
	}
	
	/**
	 * Método que cambia el automata de pila actual por otro nuevo
	 * @param ficheroLeido
	 * @param cadena
	 * @throws FileNotFoundException
	 */
	public void actualizarAutomata(String ficheroLeido, ArrayList<String> cadena) throws FileNotFoundException{
		lecturaFichero(ficheroLeido, cadena);
	}
	

	/*
	 * --------------------------------------Getters y Setters---------------------------------------
	 */

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
