/*
	5. Dado un arreglo de valores tipo int se desea calcular el valor máximo, mínimo, y
	promedio en un único método. Escriba tres métodos de clase, donde respectivamente:
	
		a. Devuelva lo pedido por el mecanismo de retorno de un método en Java 
		("return").
		b. Devuelva lo pedido interactuando con algún parámetro (el parámetro no puede 
		ser de tipo arreglo).
		c. Devuelva lo pedido sin usar parámetros ni la sentencia "return".
*/
package ej05;

public class ej05C {
	
	private int min = 9999;
	private int max = -9999;
	private int promedio = 0;
	
	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public int getPromedio() {
		return promedio;
	}

	public void setPromedio(int promedio) {
		this.promedio = promedio;
	}

	// c. Devuelva lo pedido sin usar parámetros ni la sentencia "return".
	public void puntoC ( int[] arreglo ) {
		
		for ( int i=0 ; i<arreglo.length ; i++ ) {
			
			// minimo
			if ( arreglo[i] < this.getMin() ) {
				this.setMin( arreglo[i] );
			}
			
			// maximo
			if ( arreglo[i] > this.getMax()  ) {
				this.setMax( arreglo[i] );
			}
			
			// promedio	
			this.setPromedio( this.getPromedio() + arreglo[i] );
		}
		
		this.setPromedio( this.getPromedio() / arreglo.length );
	}
	
	
	public static void main(String[] args) {
		// Crear un arreglo
		int[] vector = { 4 , 12 , 5 , 6 , 3 };
		
		// Instanciacion falopa
		ej05C hola = new ej05C();
		
		// Modificar variables de instancia
		hola.puntoC( vector );
		
		// Imprimir los valores
		System.out.println( "Maximo: " + hola.getMin() );
		System.out.println( "Minimo: " + hola.getMax() );
		System.out.println( "Promedio: " + hola.getPromedio() );
	}
}
