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

public class ej01 {

	public static void main(String[] args) {
		
		Imprimir imprimir = new Imprimir();
		
		// a. Que realice lo pedido con un for.
		imprimir.imprimirFor(2, 6);
		System.out.println();
		
		// b. Que realice lo pedido con un while.
		imprimir.imprimirFor(3, 6);
		System.out.println();
		
		// c. Que realice lo pedido sin utilizar estructuras de control iterativas (for, while, do while).
		imprimir.imprimirFor(4, 8);
		System.out.println();
	}
}