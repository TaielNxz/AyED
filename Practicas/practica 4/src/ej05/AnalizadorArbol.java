package ej05;

import cositas.*;

public class AnalizadorArbol {

	public void AnalizarArbol() {
		
	}
	
	public int devolverMaximoPromedio( ArbolGeneral<AreaEmpresa> arbol ) {
		int promedioActual = 0;
		int mayorPromedio = 0;
		int cant = 0;
		
		ColaGenerica<ArbolGeneral<AreaEmpresa>> cola = new ColaGenerica<ArbolGeneral<AreaEmpresa>>();
		ArbolGeneral<AreaEmpresa> arbol_aux;
		cola.encolar(arbol);
		cola.encolar(null);
		
		while ( !cola.esVacia() ) {
			
			arbol_aux = cola.desencolar();
			
			if ( arbol_aux != null ) {
				
				promedioActual += arbol_aux.getDato().getTardanza();
				cant += 1;
				
				if ( arbol_aux.tieneHijos() ) {
					ListaGenerica<ArbolGeneral<AreaEmpresa>> listaHijos = arbol_aux.getHijos();
					listaHijos.comenzar();
					while ( !listaHijos.fin() ) {
						cola.encolar(listaHijos.proximo());
					}
				}
				
			} else {	
				if ( !cola.esVacia() ) {
					
					promedioActual = promedioActual / cant;
					
					if ( mayorPromedio < promedioActual ) {
						mayorPromedio = promedioActual;
					}

					cola.encolar(null);
					promedioActual = 0;
					cant = 0;
				}
			}
		}
		
		return mayorPromedio;
    }
	
}
