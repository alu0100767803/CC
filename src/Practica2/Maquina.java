/**
 * 
 */
package Practica2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * @author Jorge Alonso Hernandez
 * E-mail: alu0100767803@ull.edu.es
 * Fecha: 16/10/16
 * Asignatura: Complejidad Computacional
 * Comentario: Clase que simulará la máquina de Turing
 */
public class Maquina {
	
	private Cinta cinta;
	private ArrayList<String> estados;								// Estados de la máquina
	private String estadoInicial;											// Estado inicial de la máquina
	private ArrayList<String> estadosFinales; 				// Estados finales de la máquina
	private ArrayList<ArrayList<Transicion>> matrizTransiciones;	// Matriz con todas las transiciones de la máquina
	private int cabezaLE;
	
	public Maquina(String ficheroLeido, ArrayList<String> cadena) throws FileNotFoundException{
		lecturaFichero(ficheroLeido, cadena);
		mostrarComponentes();
		mostrarTransiciones();
	}
	
	private void lecturaFichero(String ficheroLeido, ArrayList<String> cadena) throws FileNotFoundException {
		
		// variables para la lectura del fichero 
			File fichero = new File(ficheroLeido);
			Scanner lector = new Scanner(fichero);
			StringTokenizer st = null;
			String cad = null;
			boolean comentario = true;
			String token = null;
		
		// Variables para ccomponer la cinta de la máquina
		ArrayList<String> vectorCadena = cadena;
		ArrayList<String> alfE = null;
		ArrayList<String> alfC = null;
		String blanco = null;
		
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
			
		// lectura de los componentes de la maquina
			setEstados(new ArrayList<String>());
			getEstados().add(token);
			while(st.hasMoreTokens()){
				token = st.nextToken();
				getEstados().add(token);
			}
			
			cad = lector.nextLine();
			alfE = leerVector(cad);
			cad = lector.nextLine();
			alfC = leerVector(cad);
			cad = lector.nextLine();
			setEstadoInicial(cad);
			blanco = lector.nextLine();
			cad = lector.nextLine();
			setEstadosFinales(leerVector(cad));
			
			// iniciar componentes
			setCinta(new Cinta(cadena, alfE, alfC, blanco));
			
		// lectura de las transiciones
			setMatrizTransiciones(new ArrayList<ArrayList<Transicion>>());
			while(lector.hasNextLine()){
				cad = lector.nextLine();
				ArrayList<String> aux = leerVector(cad);
				anyadirTransicion(aux);
			}
	}
	
	/**
	 * Método parañadir una nueva transición
	 * @param aux
	 */
	public void anyadirTransicion(ArrayList<String> aux){
		int nodo = obtenerIndiceEstado(aux.get(0));
		String simbC = aux.get(1);
		String estDestino = aux.get(2);
		String simbNuevo = aux.get(3);
		String desp = aux.get(4);
		
		Transicion transicion = new Transicion(simbC, estDestino, simbNuevo, desp);
		
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
	 * Método que devuelve el índice del nodo 
	 * @param nodo
	 * @return
	 */
	public int obtenerIndiceEstado(String nodo){
		for(int i = 0; i < getEstados().size(); i++)
			if(getEstados().get(i).equals(nodo))
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
	 * Método que muestra los componentes de la máquina
	 */
	public void mostrarComponentes(){
		System.out.println("Estados: " + getEstados());
		System.out.println("Alfabeto de entrada: " + getCinta().getAlfabetoEntrada());
		System.out.println("Alfabeto de la cinta: " + getCinta().getAlfabetoCinta());
		System.out.println("Estado incial: " + getEstadoInicial());
		System.out.println("Símbolo blanco: " + getCinta().getSimboloBlanco());
		System.out.println("Estados finales: " + getEstadosFinales());
	}
	
	/**
	 * Método que muestra por pantalla todas las transiciones del autómata
	 */
	public void mostrarTransiciones(){
		for(int i = 0; i < getMatrizTransiciones().size(); i++){
			for(int j = 0; j < getMatrizTransiciones().get(i).size();j++){
				System.out.print("Desde el estado " + getEstados().get(i));
				System.out.print(" con el simbolo " + obtenerTransicion(i, j).getSimboloCinta() + " en la cinta");
				System.out.print(" me desplazo hasta el estado " + obtenerTransicion(i, j).getEstadoDestino());
				System.out.print(" y se escribe en la cinta " + obtenerTransicion(i, j).getSimboloNuevo());
				System.out.print(" y desplazamiento de la cinta: " + obtenerTransicion(i, j).getDesplazamiento());
				
				System.out.println();
			}
		}
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
	
	
	public void reiniciarCinta(ArrayList<String> cadena){
		getCinta().reiniciarCadena(cadena);
	}
	
	/**
	 * Método que iguala dos vectores
	 * @param vector
	 * @return
	 */
	public ArrayList<String> igualarArray(ArrayList<String> vector){
		ArrayList<String> aux = new ArrayList<String>();
		for(int i = 0; i < vector.size(); i++){
			String cad = vector.get(i);
			aux.add(cad);
		}
		return aux;
	}
	
	public void ejecutar(){
		
	}
	
	public void actualizarAutomata(String ficheroLeido, ArrayList<String> cadena) throws FileNotFoundException{
		lecturaFichero(ficheroLeido, cadena);
	}

	/*
	 * ---------------------------------Getters y Setters------------------------------------------
	 */
	
	public ArrayList<String> getEstados() {
		return estados;
	}

	public void setEstados(ArrayList<String> estados) {
		this.estados = estados;
	}

	public String getEstadoInicial() {
		return estadoInicial;
	}

	public void setEstadoInicial(String estadoInicial) {
		this.estadoInicial = estadoInicial;
	}

	public ArrayList<String> getEstadosFinales() {
		return estadosFinales;
	}

	public void setEstadosFinales(ArrayList<String> estadosFinales) {
		this.estadosFinales = estadosFinales;
	}

	public Cinta getCinta() {
		return cinta;
	}

	public void setCinta(Cinta cinta) {
		this.cinta = cinta;
	}


	public ArrayList<ArrayList<Transicion>> getMatrizTransiciones() {
		return matrizTransiciones;
	}

	public void setMatrizTransiciones(ArrayList<ArrayList<Transicion>> matrizTransiciones) {
		this.matrizTransiciones = matrizTransiciones;
	}

	public int getCabezaLE() {
		return cabezaLE;
	}

	public void setCabezaLE(int cabezaLE) {
		this.cabezaLE = cabezaLE;
	}
	
	

}
