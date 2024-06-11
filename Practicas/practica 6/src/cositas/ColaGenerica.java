/*
   	encolar(T elem): Agrega elem a la cola.
   	desencolar(): Elimina y devuelve el primer elemento de la cola.
    tope(): Devuelve el elemento en el tope de la cola sin eliminarlo.
	esVacia(): Retorna true si la cola está vacía, false en caso contrario.
 */

package cositas;

public class ColaGenerica<T> {

    private ListaGenerica<T> datos = new ListaEnlazadaGenerica<T>();

    public void encolar(T elem){
        datos.agregarFinal(elem);    
    }
    
    public T desencolar(){
        T elemento = this.tope();
        datos.eliminarEn(1);
        return elemento;
    }
    
    public T tope(){
        return datos.elemento(1);
    }
    
    public boolean esVacia(){
        return datos.esVacia();
    }
}
