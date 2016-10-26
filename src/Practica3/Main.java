/**
 * 
 */
package Practica3;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Jorge
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int x,y;
		Potencia potencia;
		boolean bucle = true;
		int opcion = 0;
		
		
		while(bucle){
			try{
				System.out.println("Funciones Primitivas Recursivas");
				System.out.println("---------potencia(x,y)---------");
				System.out.println("1. Introducir 'x' e 'y' y ejecutar");
				System.out.println("2. Salir");
				System.out.print("Introducir opcion elegida: ");
				opcion = scan.nextInt();
				switch(opcion){
					case 1:		System.out.print("Introducir x: ");
										x = scan.nextInt();
										System.out.print("Introducir y: ");
										y = scan.nextInt();
										System.out.println();
						break;
					case 2:	System.out.println("Saliendo...");
									System.exit(0);
						break;
					default:	System.out.println("ERROR: la opcion elegida no existe");
										System.out.println();
						break;
				}
				
			}
			catch(InputMismatchException e){
				scan.nextLine();
				System.out.println("ERROR: debes introducir un número");
				System.out.println();
			}
		}
	}

}
