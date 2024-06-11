/*
   	encolar(T elem): Agrega elem a la cola.
   	desencolar(): Elimina y devuelve el primer elemento de la cola.
    tope(): Devuelve el elemento en el tope de la cola sin eliminarlo.
	esVacia(): Retorna true si la cola está vacía, false en caso contrario.
 */

package ej03;
import cositas.*;

public class ColaGenerica<T> {

	private ListaEnlazadaGenerica<T> lista = new ListaEnlazadaGenerica<T>();
	
	public void apilar( T elem ) {
		lista.agregarFinal( elem );
	}
		
	public T desencolar() {		
		T dato = this.tope();
		// eliminar elemento de la cola
		lista.eliminarEn( lista.tamanio() );
		// retornar elemento salvado
		return dato;
	}
	
	public T tope() {
		return lista.elemento( lista.tamanio() );	
	}
	
    public boolean esVacia(){
        return lista.esVacia();
    }
}
