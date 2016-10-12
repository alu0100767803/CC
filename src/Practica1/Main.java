
package Practica1;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Jorge Alonso Hernandez
 * E-mail: alu0100767803@ull.edu.es
 * Fecha: 28/09/16
 * Asignatura: Complejidad Computacional
 * Comentario: Programa principal para el automata de pila
 */
public class Main {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		boolean existeFichero = false;						// Variable para comprobar si existe el fichero 
		Scanner sc = new Scanner(System.in);
		String fichero = null;
		String ficheroCadena = null;
		String cadena = null;
		int opcion = 0;
		File fich = null;
		boolean opcionValida = false;
		ArrayList<String> vectorCadena = new ArrayList<String>();
		
		while(!existeFichero){
			System.out.println("---Autómata de pila por estado final---");
			System.out.println("Introducir fichero con el autómata de pila: ");
			fichero = sc.nextLine();
			// Comprobacion de si existe el fichero
			fich = new File(fichero);
			if(fich.exists())
				existeFichero = true;
			else{
				System.out.println("El fichero \"" + fichero + "\" no existe");
				System.out.println();
			}
		}
		existeFichero = false;
		System.out.println();
		Automata automata = new Automata(fichero, vectorCadena);
			while(!opcionValida){
				System.out.println("---Autómata de pila por estado final---");
				System.out.println("1. Introducir fichero con cadena a analizar");
				System.out.println("2. Introducir cadena por entrada de texto");
				System.out.println("3. Introducir otro Automata");
				System.out.println("4. Salir");
				System.out.println("Introducir el número de la opción: ");
				opcion = sc.nextInt();
				switch(opcion){
					case 1: while(!existeFichero){
										System.out.println("Introducir fichero con la cadena: ");
										sc = new Scanner(System.in);
										ficheroCadena = sc.nextLine();
										fich = new File(ficheroCadena);
										if(fich.exists())
											existeFichero = true;
										else{
											System.out.println("El fichero \"" + ficheroCadena + "\" no existe");
											System.out.println();
										}
									}
									Scanner scan = new Scanner(fich);
									cadena = scan.nextLine();
									vectorCadena = new ArrayList<String>(Arrays.asList(cadena.split("")));
									automata.reiniciarElemCad(vectorCadena);
									automata.ejecutar();
						break;
					case 2: 	System.out.print("Introducir la cadena de entrada: ");
										sc = new Scanner(System.in);
										cadena = sc.nextLine();
										vectorCadena = new ArrayList<String>(Arrays.asList(cadena.split("")));
										automata.reiniciarElemCad(vectorCadena);
										automata.ejecutar();
						break;
					case 3:		System.out.println("Introducir nuevo fichero");
										sc = new Scanner(System.in);
										ficheroCadena = sc.nextLine();
										fich = new File(ficheroCadena);
										if(fich.exists())
											existeFichero = true;
										else{
											System.out.println("El fichero \"" + ficheroCadena + "\" no existe");
											System.out.println();
										}
										automata.actualizarAutomata(ficheroCadena, vectorCadena);
						break;
					case 4:	System.out.println("Saliendo...");
									System.exit(0);
						break;
					default: System.out.println("ERROR: la opcion elegida no existe");
						break;
				}
			}
	}


}
