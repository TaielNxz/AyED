package ej04;

import cositas.*;

public class Ej04 {

	public static void main(String[] args) {

	    //           40
	    //          /   \
	    //        25     78
	    //       /  \   /  \
	    //      10  32 65   7
		
		ArbolBinario<Integer> abb = new ArbolBinario<Integer>(40);
		ArbolBinario<Integer> HI = new ArbolBinario<Integer>(25);
		ArbolBinario<Integer> HD = new ArbolBinario<Integer>(78);
		HI.agregarHijoIzquierdo( new ArbolBinario<Integer>(10) );
		HI.agregarHijoDerecho( new ArbolBinario<Integer>(32) );
		HD.agregarHijoIzquierdo( new ArbolBinario<Integer>(65) );
		HD.agregarHijoDerecho( new ArbolBinario<Integer>(7) );
		abb.agregarHijoIzquierdo(HI);
		abb.agregarHijoDerecho(HD);
		
        RedBinariaLlena red = new RedBinariaLlena();
        System.out.println( "El mayor retardo es de " + red.retardoReenvio(abb) + " segs" );	
	}

}
