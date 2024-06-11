package ej03;

import cositas.*;

public class RecorridosAG {

	
	
	// Método que retorna una lista con los elementos impares del árbol “a” 
	// que sean mayores al valor “n” pasados como parámetros, recorrido en preorden.
	public ListaEnlazadaGenerica<Integer> numerosImparesMayoresPreOrden( ArbolGeneral<Integer> a, Integer n ) {
		ListaEnlazadaGenerica<Integer> listaImpares = new ListaEnlazadaGenerica<Integer>();
		this.imparesPreOrden( listaImpares , a , n );
		return listaImpares;
	}
		
	private void imparesPreOrden( ListaEnlazadaGenerica<Integer> listaImpares , ArbolGeneral<Integer> a , int n ) {
		
		if ( a.getDato() % 2 == 1 && a.getDato() > n  ) {
			listaImpares.agregarFinal( a.getDato() );
		}
		
		if ( a.tieneHijos() ) {
			ListaGenerica<ArbolGeneral<Integer>> listaHijos = a.getHijos();
			listaHijos.comenzar();
			while ( !listaHijos.fin() ) {
				imparesPreOrden( listaImpares , listaHijos.proximo() , n );
			}
		}
	}
	

	
	
	// Método que retorna una lista con los elementos impares del árbol “a” que sean mayores al valor “n” 
	// pasados como parámetros recorrido en postorden.
	public ListaEnlazadaGenerica<Integer> numerosImparesMayoresPostOrden( ArbolGeneral<Integer> a , int n ) {
		ListaEnlazadaGenerica<Integer> listaImpares = new ListaEnlazadaGenerica<Integer>();
		imparesPostOrden( listaImpares , a , n );
		return listaImpares;
	}
	
	private void imparesPostOrden( ListaEnlazadaGenerica<Integer> listaImpares , ArbolGeneral<Integer> a , int n ) {
		
		if ( a.tieneHijos() ) {
			ListaGenerica<ArbolGeneral<Integer>> listaHijos = a.getHijos();
			listaHijos.comenzar();
			while( !listaHijos.fin() ) {
				imparesPostOrden( listaImpares , listaHijos.proximo() , n );
			}
		}
		
		if ( a.getDato() % 2 == 1 && a.getDato() > n ) {
			listaImpares.agregarFinal( a.getDato() );
		}
	}
	
	
	
	
	// Método que retorna una lista con los elementos impares del árbol “a” que sean mayores al valor “n” 
	// pasados como parámetros, recorrido en inorden.
	public ListaEnlazadaGenerica<Integer> numerosImparesMayoresInOrden ( ArbolGeneral<Integer> a , Integer n ) {
		ListaEnlazadaGenerica<Integer> listaImpares = new ListaEnlazadaGenerica<Integer>();
		this.imparesInOrden( listaImpares , a , n );
		return listaImpares;
	}
	
	
	private void imparesInOrden( ListaEnlazadaGenerica<Integer> listaImpares , ArbolGeneral<Integer> a , Integer n ) {
		
		if ( a.tieneHijos() ) {
			ListaGenerica<ArbolGeneral<Integer>> listaHijos = a.getHijos();
			listaHijos.comenzar();
	        imparesInOrden( listaImpares , listaHijos.proximo() , n );
		}
		
		if ( a.getDato() % 2 == 1 && a.getDato() > n  ) {
			listaImpares.agregarFinal( a.getDato() );
		}
		
		if ( a.tieneHijos() ) {
			ListaGenerica<ArbolGeneral<Integer>> listaHijos = a.getHijos();
			while ( !listaHijos.fin() ) {
				imparesInOrden( listaImpares , listaHijos.proximo() , n );
			}
		}
	}
	

	
	
	// Método que retorna una lista con los elementos impares del árbol “a” que sean mayores al valor “n” 
	// pasados como parámetros, recorrido por niveles.	
	public ListaEnlazadaGenerica<Integer> numerosImparesMayoresPorNiveles( ArbolGeneral<Integer> a , Integer n ) {
		
		ListaEnlazadaGenerica<Integer> listaImpares = new ListaEnlazadaGenerica<Integer>();
		ColaGenerica<ArbolGeneral<Integer>> cola = new ColaGenerica<ArbolGeneral<Integer>>();
		ArbolGeneral<Integer> a_aux;
		cola.encolar(a);
		
		while ( !cola.esVacia() ) {
			
			a_aux = cola.desencolar();

			if ( a_aux.getDato() % 2 == 1 && a.getDato() > n  ) {
				listaImpares.agregarFinal( a_aux.getDato() );
			}
			
			if ( a_aux.tieneHijos() ) {
				ListaGenerica<ArbolGeneral<Integer>> hijos = a_aux.getHijos();
				hijos.comenzar();
				while ( !hijos.fin() ) {
					cola.encolar(hijos.proximo());
				}
			}
		}

		return listaImpares;
	}

}
