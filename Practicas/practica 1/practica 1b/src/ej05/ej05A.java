/*
	5. Dado un arreglo de valores tipo int se desea calcular el valor máximo, mínimo, y
	promedio en un único método. Escriba tres métodos de clase, donde respectivamente:
	
	a. Devuelva lo pedido por el mecanismo de retorno de un método en Java ("return").
	
	b. Devuelva lo pedido interactuando con algún parámetro (el parámetro no puede 
	ser de tipo arreglo).
	
	c. Devuelva lo pedido sin usar parámetros ni la sentencia "return".
*/

package ej05;

public class ej05A {

	// a. Devuelva lo pedido por el mecanismo de retorno de un método en Java ("return").
	public static int[] puntoA ( int[] arreglo ) {
		
		int[] datos = new int[3];
		int min = 9999;
	    int max = -9999;
	    int promedio = 0;
		
		for ( int i=0 ; i<arreglo.length ; i++ ) {
			
			// minimo
			if ( arreglo[i] < min ) {
				min = arreglo[i];
			}
			
			// maximo
			if ( arreglo[i] > max ) {
				max = arreglo[i];
			}
			
			// promedio
			promedio += arreglo[i];	
		}
		
		promedio /= arreglo.length;
	
		datos[0] = min;
		datos[1] = max;
		datos[2] = promedio;
		
		return datos;
	}
	
	
	public static void main(String[] args) {
		// Crear un arreglo
		int[] vector = { 4 , 12 , 5 , 6 , 3 };
		
		// Extraer arreglo con los valores
		int[] valores = puntoA( vector );
		
		// Imprimir los valores
		System.out.println( "Minimo: " + valores[0] );
		System.out.println( "Maximo: " + valores[1] );
		System.out.println( "Promedio: " + valores[2] );
	}
}
