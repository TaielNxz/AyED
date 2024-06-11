package parcial2;

import cositas.*;

public class parcial2 {

	public ListaGenerica<Ciudad> resolver ( Grafo<Ciudad> ciudades , String origen , String destino ) {
		
		// lista de ciudades
		ListaGenerica<Vertice<Ciudad>> listaCiudades = ciudades.listaDeVertices();
		
		// camino a devolver
		ListaGenerica<Ciudad> camino = new ListaEnlazadaGenerica<Ciudad>();
		
		// camino auxiliar
		ListaGenerica<Ciudad> caminoAux = new ListaEnlazadaGenerica<Ciudad>();
		
		// lista de marcados
		boolean[] marca = new boolean[ ciudades.listaDeVertices().tamanio() ];
		
		// vertices origen y destino
		boolean existeOrigen = false;
		boolean existeDestino = false;
		
		// buscar vertices de origen y destino
		listaCiudades.comenzar();
		while ( !listaCiudades.fin() && !existeOrigen && !existeDestino ) {
			
			Vertice<Ciudad> vertice = listaCiudades.proximo();
			
			if ( vertice.dato().equals(origen) ) {
				existeOrigen = true;
			}
			
			if ( vertice.dato().equals(destino) ) {
				existeDestino = true;
			}
			
		}
				
		// Si los vertices fueron encontrados
		if ( existeOrigen && existeDestino ) {
			
			crearCamino( ciudades , camino , caminoAux , marca , origen , destino );
			
		}
		
		
		return camino;
		
	}
	
	
	private boolean crearCamino( Grafo<Ciudad> ciudades , ListaGenerica<Ciudad> camino , ListaGenerica<Ciudad> caminoAux , boolean[] marca , Vertice<Ciudad> origen , Vertice<Ciudad> destino ) {
		
		
		ciudades.listaDeVertices().elemento(0)
		
		// marcar como visitado
		marca[origen.getPosicion()] = true;
		
		// agrego a la lista
		caminoAux.agregarFinal( origen.dato() );
		
		// si es el destino encontes clono la lista
		if ( origen.equals(destino) ) {
			
			clonarLista( camino , caminoAux );
			
			return true;
			
		} else {
			
			// obtener lista de adyacentes
			ListaGenerica<Arista<Ciudad>> ady = ciudades.listaDeAdyacentes(origen);
			
			ady.comenzar();
			if( !ady.fin() ) {
			
				// obtengo vertice adyacente
				Vertice<Ciudad> vertice = ady.proximo().verticeDestino();
				
				// si el vertice no fue visitado y no hay fase 1
				if ( !marca[vertice.getPosicion()] && vertice.dato().getFase() != 1 ) {
					crearCamino( ciudades , camino , caminoAux , marca , vertice , destino );
				}
			}
			
		}
		
		
		// agrego a la lista
		caminoAux.eliminarEn( caminoAux.tamanio() );
		
		return false;
		
		
	}
	
	private void clonarLista ( ListaGenerica<Ciudad> lista , ListaGenerica<Ciudad> clon ) {		
		lista.comenzar();
		while( !lista.fin() ) {
			clon.agregarFinal( lista.proximo() );
		}
	}
	
}
