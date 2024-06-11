package parcial3;

import cositas.*;

public class parcial {

	public ListaGenerica<String> resolver(Grafo<String> ciudades,String origen){
		
		// arreglo de marcados
		boolean []marca = new boolean[ciudades.listaDeVertices().tamanio()+1];
		
		// lista resultante
		ListaGenerica<String> lista=new ListaEnlazadaGenerica<String>();
		
		// lista auxiliar
		ListaGenerica<String> listaAux=new ListaEnlazadaGenerica<String>();
		
		// lista de vertices
		ListaGenerica<Vertice<String>> vertices = ciudades.listaDeVertices();
		
		// posicion del origen
		Integer pos=-1;

		// recorrer lista de vertices para encontrar posicion del origen
		vertices.comenzar();
		while( !vertices.fin() && pos == -1 ) {
			
			Vertice<String> v = vertices.proximo();
			
			if ( v.dato().equals(origen) ) {
				// guardo la posicion
				pos = v.getPosicion();
				// agregar a vertice origen a la lista
				listaAux.agregarFinal( v.dato() );
			}
		}
		
		// si se encontro el origen 
		if ( pos != -1 ) {
			
			Integer cantMax=0;
			Integer cantAct=-999;
			
			resolver( ciudades , origen , lista , listaAux , marca , pos , cantMax , cantAct );
		}
		
		return lista;
	}
	
	private void resolver( Grafo<String> ciudades, String origen, ListaGenerica<String> lista , ListaGenerica<String> listaAux , 
		                   boolean[] marca, Integer pos , Integer cantMax , Integer cantAct ) {
		
		// aumento el grado
		cantAct++;
		
		// obtengo vertice actual
		Vertice<String> vertice = ciudades.listaDeVertices().elemento(pos);
		
		// si el vertice es el origen && esta visitado && la cantidadActual supera a la maxima 
		if ( vertice.dato().equals(origen) && marca[pos] && cantAct>cantMax ) {
			cambio( lista , listaAux );
			cantMax = cantAct;
		} else {
			
			// obtengo los adyacentes del vertice actual
			ListaGenerica<Arista<String>> ady = ciudades.listaDeAdyacentes(vertice);
			
			// recorro los vertices
			ady.comenzar();
			while(!ady.fin()) {
				
				// obtengo el adyacente
				Vertice<String> v = ady.proximo().verticeDestino();
				
				// guardo su posicion
				pos = v.getPosicion();
				
				// si no esta visitado
				if( !marca[pos] ) {
					
					// marco como visitado
					marca[pos] = true;
					
					// lo agrego a la lista
					listaAux.agregarFinal( v.dato() );
					
					// llamada recursiva
					resolver( ciudades , origen , lista , listaAux , marca , pos , cantMax , cantAct );
					
					// elimino de la lista
					listaAux.eliminarEn(listaAux.tamanio());
				}
				
			}
		}
	}
	
	private void cambio( ListaGenerica<String> lista , ListaGenerica<String> listaAux ) {
		lista.comenzar();
		while(!lista.fin()) {
			lista.eliminar(lista.proximo());
		}
		listaAux.comenzar();
		while(!listaAux.fin()) {
			lista.agregarFinal(listaAux.proximo());
		}
	}
	
	
}
