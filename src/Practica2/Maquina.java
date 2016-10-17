/**
 * 
 */
package Practica2;

import java.util.ArrayList;

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
	
	public Maquina(){
		
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
