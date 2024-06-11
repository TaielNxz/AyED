/*
 * 2. Escriba un método de clase que dado un número n devuelva un nuevo arreglo de
 * tamaño n con los n primeros múltiplos enteros de n mayores o iguales que 1.
 * 		Ejemplo: f(5) = [5; 10; 15; 20; 25]; f(k) = {nk/k : 1..k}
 
 * Agregue al programa la posibilidad de probar con distintos valores de n
 * ingresándolos por teclado, mediante el uso de System.in. La clase Scanner permite
 * leer de forma sencilla valores de entrada
 */
package ej02;

public class Arreglos {

	public int[] DevolverArreglo( int n ) {
		// Crear arreglo de enteros
		int[] arreglo = new int[n];
		
		// Cargar arreglo
		for ( int i = 0 ; i < n ; i++ ) {	
			arreglo[i] = n*(i+1);	
		}

		return arreglo;
	}
}
