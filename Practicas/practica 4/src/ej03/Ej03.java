package ej03;

import cositas.*;

public class Ej03 {

	public static void main(String[] args) {
	
		ArbolGeneral<Integer> a1 = new ArbolGeneral<Integer>(15);
		ArbolGeneral<Integer> a2 = new ArbolGeneral<Integer>(3);
		ArbolGeneral<Integer> a3 = new ArbolGeneral<Integer>(7);
		ArbolGeneral<Integer> a4 = new ArbolGeneral<Integer>(10);
		ListaGenerica<ArbolGeneral<Integer>> hijos_raiz = new ListaEnlazadaGenerica<ArbolGeneral<Integer>>();
		hijos_raiz.agregarFinal(a1);
		hijos_raiz.agregarFinal(a2);
		hijos_raiz.agregarFinal(a3);
		hijos_raiz.agregarFinal(a4);
		ArbolGeneral<Integer> a = new ArbolGeneral<Integer>( 11 , hijos_raiz );
			
		
		ArbolGeneral<Integer> a11 = new ArbolGeneral<Integer>(17);
		ArbolGeneral<Integer> a12 = new ArbolGeneral<Integer>(11);
		ArbolGeneral<Integer> a13 = new ArbolGeneral<Integer>(9);
		ListaGenerica<ArbolGeneral<Integer>> hijos_a1 = new ListaEnlazadaGenerica<ArbolGeneral<Integer>>();
		hijos_a1.agregarFinal(a11);
		hijos_a1.agregarFinal(a12);
		hijos_a1.agregarFinal(a13);
		a1.setHijos(hijos_a1);
		
		
		ArbolGeneral<Integer> a31 = new ArbolGeneral<Integer>(16);
		ArbolGeneral<Integer> a32 = new ArbolGeneral<Integer>(5);
		ArbolGeneral<Integer> a33 = new ArbolGeneral<Integer>(8);
		ListaGenerica<ArbolGeneral<Integer>> hijos_a3 = new ListaEnlazadaGenerica<ArbolGeneral<Integer>>();
		hijos_a1.agregarFinal(a31);
		hijos_a1.agregarFinal(a32);
		hijos_a1.agregarFinal(a33);
		a3.setHijos(hijos_a3);
		
		
		ArbolGeneral<Integer> a41 = new ArbolGeneral<Integer>(14);
		ArbolGeneral<Integer> a42 = new ArbolGeneral<Integer>(7);
		ListaGenerica<ArbolGeneral<Integer>> hijos_a4 = new ListaEnlazadaGenerica<ArbolGeneral<Integer>>();
		hijos_a4.agregarFinal(a41);
		hijos_a4.agregarFinal(a42);
		a4.setHijos(hijos_a4);
		
		
		ArbolGeneral<Integer> a421 = new ArbolGeneral<Integer>(2);
		ArbolGeneral<Integer> a422 = new ArbolGeneral<Integer>(4);
		ArbolGeneral<Integer> a423 = new ArbolGeneral<Integer>(6);
		ListaGenerica<ArbolGeneral<Integer>> hijos_a42 = new ListaEnlazadaGenerica<ArbolGeneral<Integer>>();
		hijos_a42.agregarFinal(a421);
		hijos_a42.agregarFinal(a422);
		a4.setHijos(hijos_a4);
		
		
		RecorridosAG recorrido = new RecorridosAG();
		ListaGenerica<Integer> listaPreOrden = recorrido.numerosImparesMayoresPreOrden( a , 3 );
		ListaGenerica<Integer> listaPostOrden = recorrido.numerosImparesMayoresPostOrden( a , 3 );
		ListaGenerica<Integer> listaInOrden = recorrido.numerosImparesMayoresInOrden( a , 3 );
		ListaGenerica<Integer> listaPorNiveles = recorrido.numerosImparesMayoresPorNiveles( a , 3 );
		
		System.out.println("lista PreOrden:");
		listaPreOrden.comenzar();
		while ( !listaPreOrden.fin() ) {
			System.out.println( listaPreOrden.proximo() );
		}
		
		System.out.println("lista PostOrden:");
		listaPostOrden.comenzar();
		while ( !listaPostOrden.fin() ) {
			System.out.println( listaPostOrden.proximo() );
		}
		
		System.out.println("lista InOrden:");
		listaInOrden.comenzar();
		while ( !listaInOrden.fin() ) {
			System.out.println( listaInOrden.proximo() );
		}	
		
		System.out.println("lista PorNiveles:");
		listaPorNiveles.comenzar();
		while ( !listaPorNiveles.fin() ) {
			System.out.println( listaPorNiveles.proximo() );
		}	
	}
}
