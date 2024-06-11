/*
	Ejercicio 5
	
	Implemente una clase Java llamada ProfundidadDeArbolBinario 
	que tiene como variable de instancia un árbol binario de números enteros 
	y un método de instancia sumaElementosProfundidad(int p):int 
	el cuál devuelve la suma de todos los nodos del árbol 
	que se encuentren a la profundidad pasada como argumento.
 */

package ej05;

import cositas.*;

public class ProfundidadDeArbolBinario {

	private ArbolBinario<Integer> arbol;
	 
    public void setArbol(ArbolBinario<Integer> arbol){
        this.arbol = arbol;
    }
    
    // Cuando encuentra el nivel no sigue con los otros niveles
    public int sumaElementosProfundidad( int p ) {
    
    	ArbolBinario<Integer> aux = new ArbolBinario<Integer>();
    	ColaGenerica<ArbolBinario<Integer>> cola = new ColaGenerica<ArbolBinario<Integer>>();
    	cola.encolar(this.arbol);
    	cola.encolar(null);
    	int altura = 0;
    	int suma = 0;
    	
    	while ( !cola.esVacia() ) {
    		
    		aux = cola.desencolar();
    		
    		if ( aux != null ) {
    			
    			if ( altura == p ) {
    				suma = suma + aux.getDato();
    			}
	    		
	    		if ( aux.tieneHijoIzquierdo() ) {
	    			cola.encolar( aux.getHijoIzquierdo() );
	    		}
	    		
	    		if ( aux.tieneHijoDerecho() ) {
	    			cola.encolar( aux.getHijoDerecho() );
	    		}
  
	    	} else if ( !cola.esVacia() ) {
	    		altura++; 
	    		cola.encolar(null);
	    	}
    	}

    	return suma;
    }
}