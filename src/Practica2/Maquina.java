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
	
	private ArrayList<String> estados;								// Estados de la máquina
	private String estadoInicial;											// Estado inicial de la máquina
	private ArrayList<String> estadosFinales; 				// Estados finales de la máquina
	private ArrayList<Transicion> matrizTransiciones;	// Matriz con todas las transiciones de la máquina
	private int cabezaLE;
	
	public Maquina(String ficheroLeido, ArrayList<String> cadena) throws FileNotFoundException{
		lecturaFichero(ficheroLeido, cadena);
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

}
