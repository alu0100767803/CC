/**
 * 
 */
package Practica2;

/**
 * @author Jorge
 *
 */
public class Transicion {

	private String simboloCinta;
	private String estadoDestino;
	private String simboloNuevo;
	private String desplazamiento;
	
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
