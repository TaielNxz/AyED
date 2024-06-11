/*
 * 1. Escriba tres métodos de clase (static) que reciban por parámetro dos números
 * enteros (tipo int) a y b e impriman todos los números enteros comprendidos entre
 * a; b (inclusive), uno por cada línea en la salida estándar. Para ello, dentro de una
 * nueva clase escriba un método por cada uno de los siguientes incisos:	
 * a. Que realice lo pedido con un for.
 * b. Que realice lo pedido con un while.
 * c. Que realice lo pedido sin utilizar estructuras de control iterativas (for, while, do while).
 */
package ej01;

public class Imprimir {

	// a. Que realice lo pedido con un for.
	public void imprimirFor( int a , int b ) {
		for ( int i = a ; i<=b ; i++ ) {
			System.out.print( i + " " );
		}	
	}
	
	// b. Que realice lo pedido con un while.
	public void imprimirWhiel( int a , int b ) {	
		int i = a;
		while ( i <= b ) {
			System.out.print( i + " " );
			i++;
		}	
	}
	
	// c. Que realice lo pedido sin utilizar estructuras de control iterativas.
	public void imprimirSolito( int a , int b ) {
		if ( a < b ) {
			System.out.print( a + " " );
			imprimirSolito( a++ , b );
		}
	}
}
