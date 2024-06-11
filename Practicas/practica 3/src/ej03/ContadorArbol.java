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

public class ContadorArbol {


	public ListaEnlazadaGenerica<Integer> numerosParesInOrden( ArbolBinario<Integer> abb , ListaEnlazadaGenerica<Integer> lista ) {
		
		if ( abb.tieneHijoIzquierdo() ) {
			numerosParesInOrden( abb.getHijoIzquierdo() , lista );
		}
		
        if ( (abb.getDato() % 2) == 0 ){
            lista.agregarFinal(abb.getDato());
        }
		
		if ( abb.tieneHijoDerecho() ) {
			numerosParesInOrden( abb.getHijoDerecho() , lista );			
		}
        
        return lista;
	}
	
	public ListaEnlazadaGenerica<Integer> numerosParesPostOrden( ArbolBinario<Integer> abb , ListaEnlazadaGenerica<Integer> lista ) {
		
		if ( abb.tieneHijoIzquierdo() ) {
			numerosParesPostOrden( abb.getHijoIzquierdo() , lista );
		}
		
		if ( abb.tieneHijoDerecho() ) {
			numerosParesPostOrden( abb.getHijoDerecho() , lista );			
		}
		
        if ( (abb.getDato() % 2) == 0 ){
            lista.agregarFinal(abb.getDato());
        }
        
        return lista;
	}
	
}
