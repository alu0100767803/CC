/**
 * 
 */
package Practica2;

/**
 * @author Jorge Alonso Hernandez
 * E-mail: alu0100767803@ull.edu.es
 * Fecha: 16/10/16
 * Asignatura: Complejidad Computacional
 * Comentario: Clase que alberga una transici�n de un estado
 */
public class Transicion {

	private String simboloCinta;		// S�mbolo de la cinta con el que se transita
	private String estadoDestino;		// Estado destino de la transici�n
	private String simboloNuevo;		// S�mbolo nuevo que se intercambiar� por el actual en la cinta
	private String desplazamiento;	// Desplazamiento que se produce en la cinta
	
	public Transicion(String simbC, String estD, String simbN, String desp){
		
		simboloCinta = simbC;
		estadoDestino = estD;
		simboloNuevo = simbN;
		desplazamiento = desp;
		
	}

	/*
	 * ----------------------------------Getters y Setters-----------------------------------------
	 */
	
	public String getSimboloCinta() {
		return simboloCinta;
	}

	public void setSimboloCinta(String simboloCinta) {
		this.simboloCinta = simboloCinta;
	}

	public String getEstadoDestino() {
		return estadoDestino;
	}

	public void setEstadoDestino(String estadoDestino) {
		this.estadoDestino = estadoDestino;
	}

	public String getSimboloNuevo() {
		return simboloNuevo;
	}

	public void setSimboloNuevo(String simboloNuevo) {
		this.simboloNuevo = simboloNuevo;
	}

	public String getDesplazamiento() {
		return desplazamiento;
	}

	public void setDesplazamiento(String desplazamiento) {
		this.desplazamiento = desplazamiento;
	}
	
	
}
