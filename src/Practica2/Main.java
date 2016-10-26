/**
 * 
 */
package Practica2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import Practica1.Automata;

/**
 * @author Jorge Alonso Hernandez
 * E-mail: alu0100767803@ull.edu.es
 * Fecha: 16/10/16
 * Asignatura: Complejidad Computacional
 * Comentario: Programa principal para la máquina de Turing
 */
public class Main {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		
		boolean existeFichero = false;	
		Scanner sc = new Scanner(System.in);
		String fichero = null;
		String ficheroCadena = null;
		String cadena = null;
		int opcion = 0;
		File fich = null;
		boolean opcionValida = false;
		ArrayList<String> vectorCadena = new ArrayList<String>();
		
		while(!existeFichero){
			System.out.println("---Máquina de Turing---");
			System.out.print("Introducir fichero con la máquina de Turing: ");
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
		Maquina maquina = new Maquina(fichero, vectorCadena);
			while(!opcionValida){
				try{
				System.out.println("---Máquina de Turing---");
				System.out.println("1. Introducir fichero con cadena a analizar");
				System.out.println("2. Introducir cadena por entrada de texto");
				System.out.println("3. Introducir otra máquina");
				System.out.println("4. Salir");
				System.out.print("Introducir el número de la opción: ");
				opcion = sc.nextInt();
				System.out.println();
				switch(opcion){
					case 1: 	while(!existeFichero){
											System.out.print("Introducir fichero con la cadena: ");
											sc = new Scanner(System.in);
											ficheroCadena = sc.nextLine();
											System.out.println();
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
										maquina.reiniciarCinta(vectorCadena);
										if(maquina.getCinta().comprobarCadena())
											maquina.ejecutar();
										else
											System.out.println("La cadena no pertenece al alfabeto de la cinta");
						break;
					case 2: 	System.out.print("Introducir la cadena de entrada: ");
										sc = new Scanner(System.in);
										cadena = sc.nextLine();
										System.out.println();
										vectorCadena = new ArrayList<String>(Arrays.asList(cadena.split("")));
										maquina.reiniciarCinta(vectorCadena);
										if(maquina.getCinta().comprobarCadena())
											maquina.ejecutar();
										else
											System.out.println("La cadena no pertenece al alfabeto de la cinta");
						break;
					case 3:		System.out.print("Introducir nuevo fichero: ");
										sc = new Scanner(System.in);
										ficheroCadena = sc.nextLine();
										System.out.println();
										fich = new File(ficheroCadena);
										if(fich.exists())
											existeFichero = true;
										else{
											System.out.println("El fichero \"" + ficheroCadena + "\" no existe");
											System.out.println();
										}
										maquina.actualizarAutomata(ficheroCadena, vectorCadena);
						break;
					case 4:	System.out.println("Saliendo...");
									System.exit(0);
						break;
					default: System.out.println("ERROR: la opcion elegida no existe");
						break;
				}
			}
			catch(InputMismatchException e){
				sc.nextLine();
				System.out.println("ERROR: debes introducir un número");
				System.out.println();
			}
		}
	}

}
