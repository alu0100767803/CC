
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
		
		boolean existeFichero = false;		// Variable para comprobar si existe el fichero 
		Scanner sc = new Scanner(System.in);
		String fichero = null;
		String ficheroCadena = null;
		String cadena = null;
		int opcion = 0;
		File fich = null;
		boolean opcionValida = false;
		
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
		
		while(!opcionValida){
			System.out.println("---Autómata de pila por estado final---");
			System.out.println("1. Introducir fichero con cadena a analizar");
			System.out.println("2. Introducir cadena por entrada de texto");
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
								opcionValida = true;
					break;
				case 2: 	System.out.print("Introducir la cadena de entrada: ");
									sc = new Scanner(System.in);
									cadena = sc.nextLine();
									opcionValida = true;
					break;
				default: System.out.println("ERROR: la opcion elegida no existe");
					break;
			}
		}
		Automata automata = new Automata(fichero, cadena);
		automata.ejecutar();
		
		
		
		/*
		 * Forma de pasar de un String a un ArrayList<String>
		 * 
		 * String prueba = "aabb";
		ArrayList<String> array = new ArrayList<String>(Arrays.asList(prueba.split("")));
		
		for(int i = 0; i < array.size(); i++){
			System.out.println(array.get(i));
		}*/
	}


}
