/**
 * 
 */
package Practica3;

/**
 * @author Jorge Alonso Hernandez
 * E-mail: alu0100767803@ull.edu.es
 * Fecha: 28/10/16
 * Asignatura: Complejidad Computacional
 * Comentario: Programa que realiza la FRP de la potencia
 */
public class Potencia {
	
	private final int x;					// variable que representa la base
	private final int y;					// variable que representa el exponente
	private final int potencia;		// variable con la solución de la potencia
	
	public Potencia(int x, int y){
		this.x = x;															
		this.y = y;															
		potencia = potencia(getX(), getY());		
	}
	
	/**
	 * Función que representa la suma mediante FRP
	 * @param x
	 * @param y
	 * @return
	 */
	public int suma(int x, int y){
		if(y == 0)
			return x;
		else{
			int aux[] = {x, y - 1, suma(x, y - 1)};
			return s(proyeccion(aux, 2));
		}
	}
	
	/**
	 * Función que representa la multiplicación mediante FRP
	 * @param x
	 * @param y
	 * @return
	 */
	public int producto(int x, int y){
		if(y == 0)
			return z(x);
		else{
			int aux[] = {x, y - 1, producto(x, y - 1)};
			return suma(proyeccion(aux, 0), proyeccion(aux, 2));
		}
	}
	
	
	/**
	 * Función que representa la potencia mediante FRP
	 * @param x
	 * @param y
	 * @return
	 */
	public int potencia(int x, int y){
		if(y == 0)
			return uno(x);
		else{
			int aux[] = {x, y - 1, potencia(x, y - 1)};
			return producto(proyeccion(aux, 0), proyeccion(aux, 2));
		}
	}
	
	/**
	 * Función que retorna un 1
	 * @param x
	 * @return
	 */
	public int uno(int x){
		return 1;
	}
	
	/**
	 * Función nula
	 * @param x
	 * @return
	 */
	public int z(int x){
		return 0;
	}
	
	/**
	 * Función sucesor
	 * @param x
	 * @return
	 */
	public int s(int x){
		return x + 1;
	}
	
	/**
	 * Función proyección
	 * @param aux
	 * @param pos
	 * @return
	 */
	public int proyeccion(int[] aux, int pos){
		if(aux.length >= 1 && pos >= 0 && pos <= aux.length)
			return aux[pos];
		else{
			System.out.println("Accediendo a una posicion incorrecta");
			System.exit(0);
			return 0;
		}
	}
	
	public void mostrarResultado(){
		System.out.println("Resultado de la potencia(" + getX() + ", " + getY() + ") = " + getPotencia());
		System.out.println();
	}

	// ---------------------------------------Getters y Setters-------------------------------------------------
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getPotencia() {
		return potencia;
	}

}
