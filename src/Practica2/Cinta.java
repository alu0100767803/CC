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
	
	private ArrayList<String> cadena;
	private ArrayList<String> alfabetoEntrada;
	private ArrayList<String> alfabetoCinta;
	private String simboloBlanco;
	private int cabezaLE;
	private boolean cadenaAceptada;
	
	public Cinta(ArrayList<String> cad, ArrayList<String> alfE, ArrayList<String> alfC, String blanco){
		cadena = cad;
		alfabetoEntrada = alfE;
		alfabetoCinta = alfC;
		simboloBlanco = blanco;
		cabezaLE = 1;
		cadenaAceptada = false;
		
		anyadirBlancoInicio();
		anyadirBlancoFin();
		
	}
	
	public void reiniciarCadena(ArrayList<String> aux){
		setCadena(aux);
	}
	
	/**
	 * Método que desplaza la cinta
	 * @param desp
	 */
	public void desplazamientoCinta(String desp){
		if(desp.equals(getDERECHA()))
			setCabezaLE(getCabezaLE() + 1);
		else if(desp.equals(getIZQUIERDA()))
			setCabezaLE(getCabezaLE() - 1);
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
	
	public void mostrarCadena(){
		for(int i = 0; i < getCadena().size(); i++)
			System.out.print(getCadena().get(i));
		System.out.println();
		for(int i = 0; i < getCabezaLE(); i++)
			System.out.print(" ");
		System.out.println("^");
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
