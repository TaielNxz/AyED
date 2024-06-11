package cositas;

import cositas.ColaGenerica;


public class ArbolBinario<T> {
	
	private T dato;
	private ArbolBinario<T> hijoIzquierdo;   
	private ArbolBinario<T> hijoDerecho; 
	
	public ArbolBinario() {
		super();
	}

	public ArbolBinario(T dato) {
		this.dato = dato;
	}

	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}

	public ArbolBinario<T> getHijoIzquierdo() {
		return this.hijoIzquierdo;
	}

	public ArbolBinario<T> getHijoDerecho() {
		return this.hijoDerecho;

	}
	
	public void agregarHijoIzquierdo(ArbolBinario<T> hijo) {
		this.hijoIzquierdo = hijo;
	}

	public void agregarHijoDerecho(ArbolBinario<T> hijo) {
		this.hijoDerecho = hijo;
	}

	public void eliminarHijoIzquierdo() {
		this.hijoIzquierdo = null;
	}

	public void eliminarHijoDerecho() {
		this.hijoDerecho = null;
	}

	public boolean esVacio() {
		return this.getDato() == null && !this.tieneHijoIzquierdo() && !this.tieneHijoDerecho();
	}

	public boolean esHoja() {
		return (!this.tieneHijoIzquierdo() && !this.tieneHijoDerecho());
	}

	public String toString() {
		return this.getDato().toString();
	}
	 
	public boolean tieneHijoIzquierdo() {
		return this.hijoIzquierdo!=null;
	}
	 
	public boolean tieneHijoDerecho() {
		return this.hijoDerecho!=null;
	}
	
/* ======================================================================================
 * ======================================================================================
 * ====================================================================================== */

	public void printPreOrden() {
		
		if( !this.esVacio() ) {
			
			System.out.println( this.getDato() );
			
			if ( this.tieneHijoIzquierdo() ) {
				this.getHijoIzquierdo().printPreOrden();
			}
			
			if ( this.tieneHijoDerecho() ) {
				this.getHijoDerecho().printPreOrden();			
			}
			
		}
	}

	public void printInOrden() {
		
		if( !this.esVacio() ) {
			
			if ( this.tieneHijoIzquierdo() ) {
				this.getHijoIzquierdo().printInOrden();
			}
			
			System.out.println( this.getDato() );
			
			if ( this.tieneHijoDerecho() ) {
				this.getHijoDerecho().printInOrden();			
			}
			
		}
	}
	
	public void printPosOrden() {
		
		if( !this.esVacio() ) {
			
			if ( this.tieneHijoIzquierdo() ) {
				this.getHijoIzquierdo().printPosOrden();
			}
			
			if ( this.tieneHijoDerecho() ) {
				this.getHijoDerecho().printPosOrden();			
			}
			
			System.out.println( this.getDato() );
			
		}
	}
	

	public void porNiveles() {
		
		int i = 0;
		ArbolBinario<T> arbol_aux = null;
		ColaGenerica<ArbolBinario<T>> cola = new ColaGenerica<>();
		cola.encolar(this);
		cola.encolar(null);
		
		
		System.out.println( "Nivel " + i );
		
		while ( !cola.esVacia() ) {

			arbol_aux = cola.desencolar();
			
			if ( arbol_aux != null ) {
				
				System.out.println( arbol_aux.getDato() );
				
				if ( arbol_aux.tieneHijoIzquierdo() ) {
					cola.encolar(arbol_aux.getHijoIzquierdo());
				}
				
				if ( arbol_aux.tieneHijoDerecho() ) {
					cola.encolar(arbol_aux.getHijoDerecho());	
				}
				
			} else if ( !cola.esVacia() ) {
				System.out.println( "Nivel " + (++i) );
				cola.encolar(null);
			}
		}
	}


/* ======================================================================================
 * ======================================================================================
 * ====================================================================================== */

	
	public int contarHojas() {
		
		int cantHI = 0;
		int cantHD = 0;
		
		if( !this.esHoja() ) {
			
			if( this.tieneHijoIzquierdo() ) {
				cantHI = this.getHijoIzquierdo().contarHojas();
			}
			
			if( this.tieneHijoDerecho() ) {
				cantHD = this.getHijoIzquierdo().contarHojas();
			}
			
		} else {
			return 1;
		}
		
		return cantHI + cantHD;
	}
	
	
	public ArbolBinario<T> espejo() {
		
		if ( this.esVacio() ){
			return new ArbolBinario<>();
		} else {
			
			ArbolBinario<T> espejoAbb = new ArbolBinario<T>(this.getDato());
			
			if ( this.tieneHijoIzquierdo() )
				espejoAbb.agregarHijoDerecho( this.getHijoIzquierdo().espejo() );
			
			if ( this.tieneHijoDerecho() )
				espejoAbb.agregarHijoIzquierdo( this.getHijoDerecho().espejo() );
			
			return espejoAbb;
		}
	}
	
	
	public void entreNiveles( int n , int m ) {
		
		int nivel = 0;
		ArbolBinario<T> arbol_aux = null;
		ColaGenerica<ArbolBinario<T>> cola = new ColaGenerica<>();
		cola.encolar(this);
		cola.encolar(null);
		
		
		System.out.println( "Nivel " + nivel );
		
		while ( !cola.esVacia() ) {

			arbol_aux = cola.desencolar();
			
			if ( arbol_aux != null ) {
				
				if( n<=nivel && nivel<=m ) {
					System.out.println( arbol_aux.getDato() );
				}

				if ( arbol_aux.tieneHijoIzquierdo() ) {
					cola.encolar(arbol_aux.getHijoIzquierdo());
				}
				
				if ( arbol_aux.tieneHijoDerecho() ) {
					cola.encolar(arbol_aux.getHijoDerecho());	
				}
				
			} else if ( !cola.esVacia() ) {
				nivel++;
				System.out.println( "Nivel " + nivel );
				cola.encolar(null);
			}
		}
	}
}
