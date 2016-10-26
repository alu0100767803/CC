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
 * Comentario: Clase que alberga la cinta de la máquina
 */
public class Cinta {
	
	private final String DERECHA = "R";								// Variable del movimiento a la derecha la cinta
	private final String IZQUIERDA = "L";							// Variable del movimiento a la izquierda la cinta
	private final String PARADA = "S";								// Variable para no avanzar en la cinta
	
	private ArrayList<String> cadena;									// Vector con la cinra de la máquina
	private ArrayList<String> alfabetoEntrada;				// Alfabeto de la cadena de entrada
	private ArrayList<String> alfabetoCinta;					// Alfabeto de la cinta
	private String simboloBlanco;											// Símbolo que representa el símbolo blanco
	private int cabezaLE;															// Cabeza de lectura escritura de la cinta
	private boolean cadenaAceptada;										// Variable que contiene si la cadena es aceptada o no
	
	public Cinta(ArrayList<String> cad, ArrayList<String> alfE, ArrayList<String> alfC, String blanco){
		if(!cad.isEmpty())
			cadena = cad;
		else
			cadena = new ArrayList<String>();
		alfabetoEntrada = alfE;
		alfabetoCinta = alfC;
		simboloBlanco = blanco;
		cabezaLE = 1;
		cadenaAceptada = false;
		
		anyadirBlancoInicio();
		anyadirBlancoFin();
		
	}
	
	/**
	 * Método que reinicia la cinta con una cadena nueva
	 * @param aux
	 */
	public void reiniciarCadena(ArrayList<String> aux){
		if(!aux.get(0).equals(""))
			setCadena(igualarArray(aux));
		else
			setCadena(new ArrayList<String>());
		setCabezaLE(1);
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
	
	/**
	 * Método que desplaza la cinta
	 * @param desp
	 */
	public void desplazamientoCinta(String desp){
		if(desp.equals(getDERECHA())){
			if(getCabezaLE() == getCadena().size() - 1)
				anyadirBlancoFin();
			setCabezaLE(getCabezaLE() + 1);
		}
		else if(desp.equals(getIZQUIERDA())) {
			if(getCabezaLE() == 0){
				anyadirBlancoInicio();
				setCabezaLE(0);
			}
			else
				setCabezaLE(getCabezaLE() - 1);
		}
		else if(desp.equals(getPARADA()))
			setCabezaLE(getCabezaLE());
		else{
			System.out.println("ERROR: Desplazamiento incorrecto");
			System.out.println("El desplazamiento \"" + desp + "\" no existe");
		}
	}
	
	/**
	 * Método que añade un simbolo blanco al final de la cadena
	 */
	public void anyadirBlancoFin(){
		getCadena().add(getSimboloBlanco());
	}
	
	/**
	 * Método que añade un símbolo blanco al principio de la cadena
	 */
	public void anyadirBlancoInicio(){
		getCadena().add(0, getSimboloBlanco());
	}
	
	/**
	 * Método que muestra la cinta y la cabeza de lectura escritura
	 */
	public void mostrarCadena(){
		for(int i = 0; i < getCadena().size(); i++)
			System.out.print(getCadena().get(i));
		System.out.println();
		for(int i = 0; i < getCabezaLE(); i++){
			System.out.print(" ");
			if(getCadena().get(i).length() > 1){
				for(int j = 0; j < getCadena().get(i).length() - 1; j++)
					System.out.print(" ");
			}
		}
	
		System.out.println("^");
	}
	
	/**
	 * Método que devuelve el elemento al que apunta la cabeza de lectura escritura
	 * @return
	 */
	public String obtenerElemCad(){
		return getCadena().get(getCabezaLE());
	}
	
	/**
	 * Método que cambia el símbolo de la cinta al que apunta la cabeza de lectura escritura por el que introducce la transición
	 * @param simboloNuevo
	 */
	public void cambiarSimbolo(String simboloNuevo){
		getCadena().set(getCabezaLE(), simboloNuevo);
	}
	
	/**
	 * Método que devuelve true si los elementos de la cinta pertenecen al alfabeto de la cinta
	 * @return
	 */
	public boolean comprobarCadena(){
		for(int i = 0; i < getCadena().size(); i++){
			if(!comprobarElemento(getCadena().get(i)))
				return false;
		}
		return true;
	}
	
	public boolean comprobarElemento(String elem){
		for(int i = 0; i < getAlfabetoCinta().size(); i++){
			if(elem.equals(getAlfabetoCinta().get(i)) || elem.equals(getSimboloBlanco()))
				return true;
		}
		return false;
	}

	/*
	 * ----------------------------------Getters y Setters-------------------------------------------------
	 */
	public ArrayList<String> getCadena() {
		return cadena;
	}

	public void setCadena(ArrayList<String> cadena) {
		cadena.add(0, getSimboloBlanco());
		cadena.add(getSimboloBlanco());
		this.cadena = cadena;
	}

	public ArrayList<String> getAlfabetoEntrada() {
		return alfabetoEntrada;
	}

	public void setAlfabetoEntrada(ArrayList<String> alfabetoEntrada) {
		this.alfabetoEntrada = alfabetoEntrada;
	}

	public ArrayList<String> getAlfabetoCinta() {
		return alfabetoCinta;
	}

	public void setAlfabetoCinta(ArrayList<String> alfabetoCinta) {
		this.alfabetoCinta = alfabetoCinta;
	}

	public String getSimboloBlanco() {
		return simboloBlanco;
	}

	public void setSimboloBlanco(String simboloBlanco) {
		this.simboloBlanco = simboloBlanco;
	}

	public int getCabezaLE() {
		return cabezaLE;
	}

	public void setCabezaLE(int cabezaLE) {
		this.cabezaLE = cabezaLE;
	}

	public String getDERECHA() {
		return DERECHA;
	}

	public String getIZQUIERDA() {
		return IZQUIERDA;
	}

	public String getPARADA() {
		return PARADA;
	}

	public boolean isCadenaAceptada() {
		return cadenaAceptada;
	}

	public void setCadenaAceptada(boolean cadenaAceptada) {
		this.cadenaAceptada = cadenaAceptada;
	}
	
	

}
