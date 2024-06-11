/*
	Ejercicio 3
	
	Defina una clase Java denominada ContadorArbol cuya función principal es 
	proveer métodos de validación sobre árboles binarios de enteros. 
	Para ello la clase tiene como variable de instancia un ArbolBinario<Integer>. 
	Implemente en dicha clase un método denominado numerosPares() 
	que devuelve en una estructura adecuada (sin ningún criterio de orden) 
	todos los elementos pares del árbol (divisibles por 2). 
	Defina la clase dentro del paquete tp03.ejercicio3

	a) Implemente el método realizando un recorrido InOrden.
	b) Implemente el método realizando un recorrido PostOrden.
*/

package ej03;

import cositas.*;

public class Ej03 {

	public static void main(String[] args) {

	    //          40
	    //         /  \
	    //        25   78
	    //       /  \    \
	    //      10  32    7
		
		ArbolBinario<Integer> abb = new ArbolBinario<Integer>(40);
		ArbolBinario<Integer> HI = new ArbolBinario<Integer>(25);
		ArbolBinario<Integer> HD = new ArbolBinario<Integer>(78);
		HI.agregarHijoIzquierdo( new ArbolBinario<Integer>(10) );
		HI.agregarHijoDerecho( new ArbolBinario<Integer>(32) );
		HD.agregarHijoDerecho( new ArbolBinario<Integer>(7) );
		abb.agregarHijoIzquierdo(HI);
		abb.agregarHijoDerecho(HD);
		
		
		ContadorArbol contador = new ContadorArbol();
		
		System.out.println("Pares InOrden ");
		
		ListaEnlazadaGenerica<Integer> lista1 = new ListaEnlazadaGenerica<>();
		
		contador.numerosParesInOrden( abb , lista1 );
		
        lista1.comenzar();
        while(!lista1.fin()){
            System.out.println(lista1.proximo());
        }
        
        System.out.println("Pares PostOrden ");
        
		ListaEnlazadaGenerica<Integer> lista2 = new ListaEnlazadaGenerica<>();
		
		contador.numerosParesPostOrden( abb , lista2 );
		
        lista2.comenzar();
        while(!lista2.fin()){
        	
            System.out.println(lista2.proximo());
        }
	}
}
