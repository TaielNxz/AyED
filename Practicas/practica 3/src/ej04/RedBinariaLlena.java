/*
	Ejercicio 4
	Una red binaria es una red que posee una topología de árbol binario lleno.

	Los nodos que conforman una red binaria llena tiene la particularidad 
	de que todos ellos conocen cuál es su retardo de reenvío. 
	El retardo de reenvío se define como el período comprendido entre 
	que un nodo recibe un mensaje y lo reenvía a sus dos hijos.
	
	Su tarea es calcular el mayor retardo posible, en el camino que realiza un mensaje desde la raíz 
	hasta llegar a las hojas en una red binaria llena.
	
	Nota: asuma que cada nodo tiene el dato de retardo de reenvío expresado en cantidad de segundos.
	
	a) Indique qué estrategia (recorrido en profundidad o por niveles) utilizará para resolver el 
	problema. 
	
	b) Cree una clase Java llamada RedBinariaLlena (dentro del paquete tp03.ejercicio4) 
	donde implementará lo solicitado en el método retardoReenvio():int
*/
package ej04;

import cositas.*;

public class RedBinariaLlena {
	
    private static ArbolBinario<Integer> arbol = new ArbolBinario<>();
    
    public void setArbol( ArbolBinario<Integer> arbol ) {
        RedBinariaLlena.arbol = arbol;
    }
    
    public static ArbolBinario<Integer> getArbol() {
        return arbol;
    }

    public static int retardoReenvio( ArbolBinario <Integer> arbol ) {
    	
        int HI,HD,max;
        
        if ( arbol.esHoja() ){
            return arbol.getDato();
        } else {
            HI = retardoReenvio( arbol.getHijoIzquierdo() );
            HD = retardoReenvio( arbol.getHijoDerecho() );
            max = Math.max(HI,HD);
            
            return max+arbol.getDato();
        }
    }
}
