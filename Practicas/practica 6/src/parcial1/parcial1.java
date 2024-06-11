package parcial1;

import cositas.*;

public class parcial1 {


	public parcial1() {
	}


	// camino mas largo
	public ListaGenerica<String> caminoMasLargo ( Grafo<String> ciudades , String origen ) {
		
		// lista de ciudades
		ListaGenerica<Vertice<String>> listaCiudades = ciudades.listaDeVertices();
		
		// camino resultante
		ListaGenerica<String> camino = new ListaEnlazadaGenerica<String>();
		
		// camino auxiliar
		ListaGenerica<String> caminoAux = new ListaEnlazadaGenerica<String>();
		
		// Arreglo de marcados
		boolean[] marca = new boolean[ciudades.listaDeVertices().tamanio()+1];
		
		// Cantidad
		Contador contador = new Contador(-1);
		
		// posicion del vertice a buscar
		int pos = -1;
		
		// recorrer lista de ciudades
		listaCiudades.comenzar();
		if( !listaCiudades.fin() ) {
			
			// obtengo vertice acutal
			Vertice<String> vertice = listaCiudades.proximo();
			
			// si se encuentra el origen guardo la posicion
			if ( vertice.dato().equals(origen) ) {
				pos = vertice.getPosicion();
			}
		}
		
		// si se encontro la ciudad origen
		if ( pos != -1 ) {
			
			caminoMasLargo( ciudades , origen , pos , camino , caminoAux , marca , contador );

		}
		
		return camino;
		
	}
	
	
	private void caminoMasLargo ( Grafo<String> ciudades , String origen , int pos , ListaGenerica<String> camino , ListaGenerica<String> caminoAux , boolean[] marca , Contador contador ) {
		
		// agarro el vertice
		Vertice<String> vertice = ciudades.listaDeVertices().elemento(pos);
		
		// agrego al camino
		caminoAux.agregarFinal( vertice.dato() );
		
		// si el adyacente es el origen
		if ( vertice.dato().equals(origen) && marca[pos] ) {
			
			if ( caminoAux.tamanio() > contador.getCantidad() ) {
				// clono la lista
				clonarLista( caminoAux , camino );
				// guardo largo de la lista
				contador.setCantidad( caminoAux.tamanio() );
			}
			
		} else {
			
			// marco el vertice como leido
			marca[pos] = true;
			
			// adyacentes del vertice
			ListaGenerica<Arista<String>> ady = ciudades.listaDeAdyacentes(vertice);
			
			// comienzo a recorrer la lista
			ady.comenzar();
			while ( !ady.fin() ) {
				
				// obtengo vertice adyacente
				Vertice<String> v = ady.proximo().verticeDestino();
				
				if ( !marca[v.getPosicion()] ) {
					
					// llamada recursiva
					caminoMasLargo( ciudades , origen , v.getPosicion() , camino , caminoAux , marca , contador );
				
					// elimino del camino
					caminoAux.eliminarEn( caminoAux.tamanio() );
				}
			}
		} 
		
		
	}
	
	private void clonarLista ( ListaGenerica<String> origen , ListaGenerica<String> clon ) {
		
		origen.comenzar();
		while ( !origen.fin() ) {
			String a = origen.proximo();
			clon.agregarFinal( a );
		}
	}
	
}
