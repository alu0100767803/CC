/**
 * 
 */
package Practica1;

import java.util.ArrayList;

/**
 * @author Jorge Alonso Hernandez
 * E-mail: alu0100767803@ull.edu.es
 * Fecha: 28/09/16
 * Asignatura: Complejidad Computacional
 * Comentario: Clase que alberga la cadena de entrada 
 */
public class Entrada {
	
	private final String VACIO = ":"; 						// Simbolo que representa el no consumir nada de la cadena de entrada
	
	private ArrayList<String> cadena;							// Cadena a ser evaluada
	private ArrayList<String> alfabetoEntrada;		// Alfabeto de la cadena introducida
	private boolean cadenaAceptada;								// Variable que contiene un true si la cadena es aceptada por el autómata de pila
	
	public Entrada(ArrayList<String> cadena, ArrayList<String> alfabeto){
		this.cadena = cadena;
		alfabetoEntrada = alfabeto;
		cadenaAceptada = false;
		comprobarCadena();
	}
	
	/**
	 * Método que compruba si la cadena pertenece al alfabeto de la entrada
	 */
	public void comprobarCadena(){
		for (int i = 0; i < getCadena().size(); i++){
			if(!comprobarElemento(getCadena().get(i)))
				salirConError(getCadena().get(i));
		}
	}
	
	/**
	 * COmprueba si el elemento pertenece al alafabeo de la entradas
	 * @param elemento
	 * @return
	 */
	public boolean comprobarElemento(String elemento){
		if(elemento.equals(getVACIO()))
			return true;
		for(int i = 0; i < getAlfabetoEntrada().size(); i++){
			if(elemento.equals(getAlfabetoEntrada().get(i)))
				return true;
		}
		return false;
	}
	
	/**
	 * Método que sale con error si la cadena no pertenece al lenguaje de la entrada
	 * @param elemento
	 */
	public void salirConError(String elemento){
		System.out.println("El elemento " + elemento + " de la cadena, no pertenece al alfabeto de la entrada ");
		System.exit(0); 	// probar a pedir otra cadena;
	}
	
	/*
	 * ---------------------------------------Getters y Setters-------------------------------------
	 */
	
	public ArrayList<String> getCadena() {
		return cadena;
	}

	public void setCadena(ArrayList<String> cadena) {
		this.cadena = cadena;
	}

	public ArrayList<String> getAlfabetoEntrada() {
		return alfabetoEntrada;
	}

	public void setAlfabetoEntrada(ArrayList<String> alfabetoEntrada) {
		this.alfabetoEntrada = alfabetoEntrada;
	}

	public boolean isCadenaAceptada() {
		return cadenaAceptada;
	}

	public void setCadenaAceptada(boolean cadenaAceptada) {
		this.cadenaAceptada = cadenaAceptada;
	}

	public String getVACIO() {
		return VACIO;
	}
	
	

}
