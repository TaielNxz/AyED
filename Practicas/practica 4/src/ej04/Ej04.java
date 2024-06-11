package ej04;

import cositas.*;

public class Ej04 {

	public static void main(String[] args) {
		
		
		ArbolGeneral<String> a1 = new ArbolGeneral<String>("a1");
		ArbolGeneral<String> a2 = new ArbolGeneral<String>("a2");
		ArbolGeneral<String> a3 = new ArbolGeneral<String>("a3");
		ListaEnlazadaGenerica<ArbolGeneral<String>> hijos_a = new ListaEnlazadaGenerica<ArbolGeneral<String>>();
		hijos_a.agregarFinal(a1);
		hijos_a.agregarFinal(a2);
		hijos_a.agregarFinal(a3);
		ArbolGeneral<String> a = new ArbolGeneral<String>( "a" , hijos_a );

		
		
		ArbolGeneral<String> a11 = new ArbolGeneral<String>("a11");
		ArbolGeneral<String> a12 = new ArbolGeneral<String>("a12");
		ArbolGeneral<String> a13 = new ArbolGeneral<String>("a13");
		ListaEnlazadaGenerica<ArbolGeneral<String>> hijos_a1 = new ListaEnlazadaGenerica<ArbolGeneral<String>>();
		hijos_a1.agregarFinal(a11);
		hijos_a1.agregarFinal(a12);
		hijos_a1.agregarFinal(a13);
		a1.setHijos(hijos_a1);
		
		
		
		ArbolGeneral<String> a21 = new ArbolGeneral<String>("a21");
		ArbolGeneral<String> a22 = new ArbolGeneral<String>("a22");
		ArbolGeneral<String> a23 = new ArbolGeneral<String>("a23");
		ListaEnlazadaGenerica<ArbolGeneral<String>> hijos_a2 = new ListaEnlazadaGenerica<ArbolGeneral<String>>();
		hijos_a1.agregarFinal(a21);
		hijos_a1.agregarFinal(a22);
		hijos_a1.agregarFinal(a23);
		a2.setHijos(hijos_a2);
		
		
		
		ArbolGeneral<String> a31 = new ArbolGeneral<String>("a31");
		ListaEnlazadaGenerica<ArbolGeneral<String>> hijos_a3 = new ListaEnlazadaGenerica<ArbolGeneral<String>>();
		hijos_a1.agregarFinal(a31);
		a3.setHijos(hijos_a3);
		
		
		
		ArbolGeneral<String> a311 = new ArbolGeneral<String>("a311");
		ArbolGeneral<String> a312 = new ArbolGeneral<String>("a312");
		ArbolGeneral<String> a313 = new ArbolGeneral<String>("a313");
		ListaEnlazadaGenerica<ArbolGeneral<String>> hijos_a31 = new ListaEnlazadaGenerica<ArbolGeneral<String>>();
		hijos_a31.agregarFinal(a311);
		hijos_a31.agregarFinal(a312);
		hijos_a31.agregarFinal(a313);
		a31.setHijos(hijos_a31);
		
		System.out.println( "Altura del arbol: " + a.altura() );
		System.out.println( "Nivel de dato: " + a.nivel("a11") );
		
	}

}
