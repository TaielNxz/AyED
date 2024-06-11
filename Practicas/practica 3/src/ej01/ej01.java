/*
	1. Considere la siguiente especificación de la clase Java ArbolBinario (con la representación hijo 
	izquierdo e hijo derecho)
	
	• El constructor ArbolBinario(T dato) inicializa un árbol con el dato pasado como parámetro 
	  y ambos hijos nulos.
	
	• Los métodos getHijoIzquierdo():ArbolBinario<T> y
	  getHijoDerecho():ArbolBinario<T>, retornan los hijos izquierdo y derecho 
	  respectivamente del árbol. 
	
	• El método agregarHijoIzquierdo(ArbolBinario<T> unHijo) y 
	  agregarHijoDerecho(ArbolBinario<T> unHijo) agrega un hijo como hijo izquierdo o 
	  derecho del árbol. 
	
	• El método eliminarHijoIzquierdo() y eliminarHijoDerecho(), eliminan el hijo 
	  correspondiente.
	
	• El método esVacio() indica si el árbol está vacío y el método esHoja() no tiene hijos.
	
	• El método tieneHijoIzquierdo() y tieneHijoDerecho() devuelven un booleano indicando 
	  si tiene dicho hijo el árbol receptor del mensaje.
	  
	  a) Analice la implementación en JAVA de las clases ArbolBinario brindadas por la cátedra.
 */
package ej01;

import cositas.ArbolBinario;

public class ej01 {

	public static void main(String[] args) {
		
		ArbolBinario<Integer> abb = new ArbolBinario<Integer>(40);
		ArbolBinario<Integer> HI = new ArbolBinario<Integer>(25);
		ArbolBinario<Integer> HD = new ArbolBinario<Integer>(78);
		HI.agregarHijoIzquierdo( new ArbolBinario<Integer>(10) );
		HI.agregarHijoDerecho( new ArbolBinario<Integer>(32) );
		abb.agregarHijoIzquierdo(HI);
		abb.agregarHijoDerecho(HD);

	}
}
