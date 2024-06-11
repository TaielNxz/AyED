package ej05;

import cositas.*;

public class Ej05 {

	public static void main(String[] args) {
		
		
		/* ========================== NIVEL 0 ========================== */
		ArbolGeneral<AreaEmpresa> M = new ArbolGeneral<AreaEmpresa>(new AreaEmpresa (14,"M") );
		
		
		
		/* ========================== NIVEL 1 ========================== */
		ListaEnlazadaGenerica<ArbolGeneral<AreaEmpresa>> hijos_M = new ListaEnlazadaGenerica<ArbolGeneral<AreaEmpresa>>();
		ArbolGeneral<AreaEmpresa> J = new ArbolGeneral<AreaEmpresa>( new AreaEmpresa (13,"J") );
		ArbolGeneral<AreaEmpresa> K = new ArbolGeneral<AreaEmpresa>( new AreaEmpresa (25,"K") );
		ArbolGeneral<AreaEmpresa> L = new ArbolGeneral<AreaEmpresa>( new AreaEmpresa (10,"L") );
		hijos_M.agregarFinal(J);
		hijos_M.agregarFinal(K);
		hijos_M.agregarFinal(L);
		
		M.setHijos(hijos_M);

		
		
		/* ========================== NIVEL 2 ========================== */
		ListaEnlazadaGenerica<ArbolGeneral<AreaEmpresa>> hijos_J = new ListaEnlazadaGenerica<ArbolGeneral<AreaEmpresa>>();
		ArbolGeneral<AreaEmpresa> A = new ArbolGeneral<AreaEmpresa>( new AreaEmpresa (4,"A") );
		ArbolGeneral<AreaEmpresa> B = new ArbolGeneral<AreaEmpresa>( new AreaEmpresa (7,"B") );
		ArbolGeneral<AreaEmpresa> C = new ArbolGeneral<AreaEmpresa>( new AreaEmpresa (5,"C") );
		hijos_J.agregarFinal(A);
		hijos_J.agregarFinal(B);
		hijos_J.agregarFinal(C);
		
		J.setHijos(hijos_J);
		
		
		ListaEnlazadaGenerica<ArbolGeneral<AreaEmpresa>> hijos_K = new ListaEnlazadaGenerica<ArbolGeneral<AreaEmpresa>>();
		ArbolGeneral<AreaEmpresa> D = new ArbolGeneral<AreaEmpresa>( new AreaEmpresa (6,"D") );
		ArbolGeneral<AreaEmpresa> E = new ArbolGeneral<AreaEmpresa>( new AreaEmpresa (10,"E") );
		ArbolGeneral<AreaEmpresa> F = new ArbolGeneral<AreaEmpresa>( new AreaEmpresa (18,"F") );
		hijos_K.agregarFinal(D);
		hijos_K.agregarFinal(E);
		hijos_K.agregarFinal(F);
		
		K.setHijos(hijos_K);
		
		
		ListaEnlazadaGenerica<ArbolGeneral<AreaEmpresa>> hijos_L = new ListaEnlazadaGenerica<ArbolGeneral<AreaEmpresa>>();
		ArbolGeneral<AreaEmpresa> G = new ArbolGeneral<AreaEmpresa>( new AreaEmpresa (9,"G") );
		ArbolGeneral<AreaEmpresa> H = new ArbolGeneral<AreaEmpresa>( new AreaEmpresa (12,"H") );
		ArbolGeneral<AreaEmpresa> I = new ArbolGeneral<AreaEmpresa>( new AreaEmpresa (19,"I") );
		hijos_L.agregarFinal(G);
		hijos_L.agregarFinal(H);
		hijos_L.agregarFinal(I);
		
		L.setHijos(hijos_L);
		
		
		AnalizadorArbol analizador = new AnalizadorArbol();
		
		System.out.println( "Maximo Promedio: " + analizador.devolverMaximoPromedio( M ) );
		
	}
}
