/*
 * 2. Escriba un método de clase que dado un número n devuelva un nuevo arreglo de
 * tamaño n con los n primeros múltiplos enteros de n mayores o iguales que 1.
 * 		Ejemplo: f(5) = [5; 10; 15; 20; 25]; f(k) = {nk/k : 1..k}
 
 * Agregue al programa la posibilidad de probar con distintos valores de n
 * ingresándolos por teclado, mediante el uso de System.in. La clase Scanner permite
 * leer de forma sencilla valores de entrada
 */
package ej02;

import java.util.Scanner;

public class ej02 {

	public static void main(String[] args) {	
		// Llamar al scanner para ingresar datos de teclado
		Scanner scanner = new Scanner(System.in);
		
		// Instanciar esta cosa para crear un arreglo
		Arreglos arreglos = new Arreglos();
		
		// Leer un numero
		System.out.print("Ingrese un numero:");
		int numero = scanner.nextInt();
		
		// Crear el arreglo
		int[] nuevoArreglo = arreglos.DevolverArreglo(numero);
		
		// Imprimir el arreglo
        for( int i = 0 ; i<numero ; i++ ){
        	System.out.println( nuevoArreglo[i] );
        }
        
        // Cerrar el scanner
        scanner.close();
	}

}
