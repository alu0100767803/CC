/**
 * 
 */
package Practica2;

import java.util.ArrayList;

/**
 * @author Jorge
 *
 */
public class Maquina {
	
	private final String DERECHA = "R";
	private final String IZQUIERDA = "L";
	private final String PARADA = "S";
	
	private ArrayList<String> estados;
	private String estadoInicial;
	private ArrayList<String> estadosFinales;  
	
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

	public String getDERECHA() {
		return DERECHA;
	}

	public String getIZQUIERDA() {
		return IZQUIERDA;
	}

	public String getPARADA() {
		return PARADA;
	}
	

}
