package ej02;

import cositas.ArbolBinario;

public class ej02 {
    //          40
    //         /  \
    //        25   78
    //       /  \    \
    //      10  32    7

	public static void main(String[] args) {
		
		ArbolBinario<Integer> abb = new ArbolBinario<Integer>(40);
		ArbolBinario<Integer> HI = new ArbolBinario<Integer>(25);
		ArbolBinario<Integer> HD = new ArbolBinario<Integer>(78);
		HI.agregarHijoIzquierdo( new ArbolBinario<Integer>(10) );
		HI.agregarHijoDerecho( new ArbolBinario<Integer>(32) );
		HD.agregarHijoDerecho( new ArbolBinario<Integer>(7) );
		abb.agregarHijoIzquierdo(HI);
		abb.agregarHijoDerecho(HD);
		
		System.out.println("\nRecorrido PreOrden");
		abb.printPreOrden();
		
		System.out.println("\nRecorrido InOrden");
		abb.printInOrden();
		
		System.out.println("\nRecorrido PosOrden");
		abb.printPosOrden();
	
		System.out.println("\nRecorrido PorNiveles");
		abb.porNiveles();

		// a) contarHojas():int 
		//    Devuelve la cantidad de árbol/subárbol hojas del árbol receptor. 
		// int cantHoja =  abb.contarHojas();
		System.out.println( "Cantidad de hojas: " + abb.contarHojas() );
		
		// b) espejo(): ArbolBinario<T>
		//    Devuelve el árbol binario espejo del árbol receptor. Por ejemplo:
		ArbolBinario<Integer> abbEspejo = abb.espejo();
		
		// c) entreNiveles(int n, m) 
		//    Imprime el recorrido por niveles de los elementos del árbol receptor 
		//    entre los niveles n y m (ambos inclusive). (0≤n<m≤altura del árbol)
		System.out.println("\nRecorrido EntreNiveles");
		abb.entreNiveles( 0, 1 );
		
	}
}
