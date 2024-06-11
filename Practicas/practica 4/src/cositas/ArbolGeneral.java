package cositas;

import ej05.AreaEmpresa;

public class ArbolGeneral<T> {

	private T dato;

	private ListaGenerica<ArbolGeneral<T>> hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();

	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}

	public void setHijos(ListaGenerica<ArbolGeneral<T>> hijos) {
		if (hijos==null)
			this.hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();
		else
			this.hijos = hijos;
	}

	public ArbolGeneral(T dato) {
		this.dato = dato;
	}

	public ArbolGeneral(T dato, ListaGenerica<ArbolGeneral<T>> hijos) {
		this(dato);
		if (hijos==null)
			this.hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();
		else
			this.hijos = hijos;
	}

	public ListaGenerica<ArbolGeneral<T>> getHijos() {
		return this.hijos;
	}

	public void agregarHijo(ArbolGeneral<T> unHijo) {

		this.getHijos().agregarFinal(unHijo);
	}

	public boolean esHoja() {

		return !this.tieneHijos();
	}
	
	public boolean tieneHijos() {
		return !this.hijos.esVacia();
	}
	
	public boolean esVacio() {

		return this.dato == null && !this.tieneHijos();
	}

	public void eliminarHijo(ArbolGeneral<T> hijo) {
		if (this.tieneHijos()) {
			ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
			if (hijos.incluye(hijo)) 
				hijos.eliminar(hijo);
		}
	}


/* =====================================================================================================
 *                                          Ejercicio 4
 * ================================================================================================== */

	// a) public int altura(): int devuelve la altura del árbol, es decir, 
	//    la longitud del camino más largo desde el nodo raíz hasta una hoja.
	public Integer altura() {
		int i = -1;
		if ( esHoja() ) {
			return 0;
		} else {
			if( tieneHijos() ){
				ListaGenerica<ArbolGeneral<T>> listaHijos = this.getHijos();
				listaHijos.comenzar();
				while ( !listaHijos.fin() ){
					i = Math.max( i , listaHijos.proximo().altura() );
				}
			}
		}
		return i + 1;
	}




	// b) public int nivel(T dato) devuelve la profundidad o nivel del dato en el árbol. 
	//    El nivel de un nodo es la longitud del único camino de la raíz al nodo. 
	public int nivel(T dato) {
        ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<ArbolGeneral<T>>();
        ArbolGeneral<T> aux;

        cola.encolar(this);
        cola.encolar(null);

        int nivel = 0;

        while ( !cola.esVacia() ) {
        	
            aux = cola.desencolar();
            
            if (aux != null) {
            	
                if ( aux.getDato() == dato ) {
                    return nivel;
                }
                
                if ( aux.tieneHijos() ) {
                    ListaGenerica<ArbolGeneral<T>> listaHijos = aux.getHijos();
                    listaHijos.comenzar();
                    while ( !listaHijos.fin() ) {
                        cola.encolar( listaHijos.proximo() );
                    }
                }
                
            } else if ( !cola.esVacia() ) {
                cola.encolar(null);
                nivel++;
            }
        }
        return -1;
    }


	// c) public int ancho(): int la amplitud (ancho) de un árbol se define como 
	//    la cantidad de nodos que se encuentran en el nivel que posee la mayor cantidad de nodos.
	public Integer ancho() {
		
		ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<ArbolGeneral<T>>();
		ArbolGeneral<T> aux;
		cola.encolar(this);
		cola.encolar(null);
		
		int cantidad=0,max = -1,nivel = 0;
		
		while (!cola.esVacia()) {
			aux = cola.desencolar();
			if (aux != null) {
				cantidad++;
				if (aux.tieneHijos()) {
					ListaGenerica<ArbolGeneral<T>> lhijos = aux.getHijos();
					lhijos.comenzar();
					while (!lhijos.fin())
						cola.encolar(lhijos.proximo());
				}
			}
			else {					
				if(cantidad > max)
					max = cantidad;
				cantidad=0;		
				if (!cola.esVacia()) {			
					cola.encolar(null);
					nivel++;

				}
			}
		}
		return max;
	}

	
	
	
	
	
	

/* =====================================================================================================
 *                                          Ejercicio 6
 * ================================================================================================== */
	
	public Boolean esAncestro ( T a , T b ) {
		
        boolean encontreA = false;
        ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<ArbolGeneral<T>>();
        cola.encolar(this);
        cola.encolar(null);
        
        
        while( !cola.esVacia() ){
        	
            ArbolGeneral<T> arbol_aux = cola.desencolar();
            
            if ( arbol_aux != null ) {
            	
                if ( arbol_aux.getDato() == a ){
                    encontreA = true;
                    
                    while( !cola.esVacia() ){
                        cola.desencolar();
                    }
                    
                } else if ( encontreA && arbol_aux.getDato() == b ) {
                    return true;
                }
                
                if ( arbol_aux.tieneHijos() ){
                    ListaGenerica<ArbolGeneral<T>> hijos = arbol_aux.getHijos();
                    hijos.comenzar();
                    while( !hijos.fin() ){
                        cola.encolar( hijos.proximo() );
                    }
                }
                
            } else {
            	if ( !cola.esVacia() ) 
	                cola.encolar(null);
            }
            
        }
        return false;
    }
	
	

}
