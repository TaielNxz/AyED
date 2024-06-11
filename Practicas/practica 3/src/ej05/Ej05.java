/*
	Ejercicio 5
	
	Implemente una clase Java llamada ProfundidadDeArbolBinario 
	que tiene como variable de instancia un árbol binario de números enteros 
	y un método de instancia sumaElementosProfundidad(int p):int 
	el cuál devuelve la suma de todos los nodos del árbol 
	que se encuentren a la profundidad pasada como argumento.
 */

package ej05;

import cositas.ArbolBinario;

public class Ej05 {

	public static void main(String[] args) {

	    //           40
	    //          /   \
	    //        25     78
	    //       /  \   /  \
	    //      10  32 65   7
		
		ArbolBinario<Integer> abb = new ArbolBinario<Integer>(40);
		ArbolBinario<Integer> HI = new ArbolBinario<Integer>(25);
		ArbolBinario<Integer> HD = new ArbolBinario<Integer>(78);
		HI.agregarHijoIzquierdo( new ArbolBinario<Integer>(10) );
		HI.agregarHijoDerecho( new ArbolBinario<Integer>(32) );
		HD.agregarHijoIzquierdo( new ArbolBinario<Integer>(65) );
		HD.agregarHijoDerecho( new ArbolBinario<Integer>(7) );
		abb.agregarHijoIzquierdo(HI);
		abb.agregarHijoDerecho(HD);
		
        ProfundidadDeArbolBinario profundidad = new ProfundidadDeArbolBinario();
        profundidad.setArbol(abb);
        
        System.out.println( "nivel 0: " + profundidad.sumaElementosProfundidad(0) );
        System.out.println( "nivel 1: " + profundidad.sumaElementosProfundidad(1) );
        System.out.println( "nivel 2: " + profundidad.sumaElementosProfundidad(2) );
	}
}
