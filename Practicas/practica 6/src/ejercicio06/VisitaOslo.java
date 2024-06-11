/*
	Se quiere realizar un paseo en bicicleta por lugares emblemáticos de Oslo. Para esto se cuenta con un grafo de 
	bicisendas. Partiendo desde el “Ayuntamiento” hasta un lugar destino en menos de X minutos, sin pasar por 
	un conjunto de lugares que están restringidos.
	
	Escriba una clase llamada VisitaOslo e implemente su método:
	
	ListaGenerica<String> paseoEnBici( Grafo<String> lugares, String destino, int maxTiempo, ListaGenerica<String> lugaresRestringidos )
	
	En este ejemplo, para llegar desde Ayuntamiento a Museo Vikingo, sin pasar por: {“Akker Brigge”, “Palacio Real”} 
	y en no más de 120 minutos, el camino marcado en negrita cumple las condiciones.
	
	Notas:
		 El “Ayuntamiento” debe ser buscado antes de comenzar el recorrido para encontrar un camino.
		
		 De no existir camino posible, se debe retornar una lista vacía.
		
		 Debe retornar el primer camino que encuentre que cumple las restricciones.
		
		 Ejemplos de posibles caminos a retornar, sin pasar por “Akker Brigge” y “Palacio Real” en no más de 120 min (maxTiempo)
		
		 Ayuntamiento, El Tigre, Museo Munch, Parque Botánico, Galería Nacional, Parque Vigeland, FolkMuseum, 
		Museo Fram, Museo del Barco Polar, Museo Vikingo. El recorrido se hace en 91 minutos.
		
		 Ayuntamiento, Parque Botánico, Galería Nacional, Parque Vigeland, FolkMuseum, Museo 
		Fram, Museo del Barco Polar, Museo Vikingo. El recorrido se hace en 70 minutos.

*/

package ejercicio06;

import cositas.*;

public class VisitaOslo {

	
	ListaGenerica<String> paseoEnBici( Grafo<String> lugares, String destino, int maxTiempo, ListaGenerica<String> lugaresRestringidos ) {
		
		// lista de marcados
		boolean[] marca = new boolean[lugares.listaDeVertices().tamanio()+1];
		
		// lista de lugares
		ListaGenerica<Vertice<String>> listaLugares = lugares.listaDeVertices();
		
		// camino a retornar
		ListaGenerica<String> camino = new ListaEnlazadaGenerica<String>();
		
		// camino para construir
		ListaGenerica<String> caminoAux = new ListaEnlazadaGenerica<String>();	
		
		// Si el destino NO es un lugar restringido continuo con el algoritmo
		if ( !lugaresRestringidos.incluye(destino) ) {
			
			int pos = 0;
			boolean encontrado = false;
			
			// Recorrer lista de vertices hasta encontrar "Ayutamiento"
			listaLugares.comenzar();
			while( !listaLugares.fin() && !encontrado ) {
				
				// Obtener vertice
				Vertice<String> v = listaLugares.proximo();
				
				// Si el dato del vertice es "Ayutamiento", guardo la posicion del vertice
				if ( v.dato().equals("Ayuntamiento") ) {
					
					pos = v.getPosicion();
					
					encontrado = true;
					
					caminoAux.agregarFinal(v.dato());
				}
			}
			
			int tiempo = 0;
			
			dfs( lugares , lugaresRestringidos , camino , caminoAux, pos , marca , destino , tiempo , maxTiempo );
			
		}
			

		return camino;
	}
	
	
	private void dfs ( Grafo<String> lugares , ListaGenerica<String> lugaresRestringidos, ListaGenerica<String> camino, ListaGenerica<String> caminoAux, 
			           int pos, boolean[] marca, String destino, int tiempo, int maxTiempo) {

		// Marco el vertice acutal como visitado
		marca[pos] = true;
		
		// obtengo el vertice actual
		Vertice<String> v = lugares.listaDeVertices().elemento(pos);
		
		// si se encontro el destino guardo la lista
		if ( v.dato() == destino ) {
			clonar( caminoAux , camino );
		}
		
		// si falta recorrer
		if ( camino.esVacia() ) {
			
			// obtener los adyacentes
			ListaGenerica<Arista<String>> ady = lugares.listaDeAdyacentes(v);
			
			ady.comenzar();
			while( !ady.fin() && camino.esVacia() ) {
				
				Arista<String> arista = ady.proximo();
				
				int posAdy = arista.verticeDestino().getPosicion();
				
				// si el vertice adyacente NO fue visitado y NO esta restringido
				if ( !marca[posAdy] && !lugaresRestringidos.incluye(arista.verticeDestino().dato()) ) {
					
					// Adjunto el tiempo de este vertice
					tiempo += arista.peso();
					
					if ( tiempo <= maxTiempo ) {
						
						caminoAux.agregarFinal( arista.verticeDestino().dato() );
						
						dfs( lugares , lugaresRestringidos , camino , caminoAux, posAdy , marca , destino , tiempo , maxTiempo );
						
						caminoAux.eliminarEn(caminoAux.tamanio());
						
						if ( camino.esVacia() ) {
							
							marca[posAdy] = false;
						}
					}
					
					tiempo -= arista.peso();	
				}
			}
		}
	}
	
	
	private void clonar ( ListaGenerica<String> caminoAux , ListaGenerica<String> camino ) {
		caminoAux.comenzar();
		while(!caminoAux.fin()) {
			camino.agregarFinal(caminoAux.proximo());
		}
	}
}
