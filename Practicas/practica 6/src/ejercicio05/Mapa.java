package ejercicio05;

import cositas.*;

public class Mapa {

	
	Grafo<String> mapaCiudades;
	
	
// ========================================================================================================================== //
//                                                Ejercicio 5 : devolverCamino
// ========================================================================================================================== //

	public ListaGenerica<String> devolverCamino ( String ciudad1, String ciudad2 ) {
		
		// obtengo lista de vertices
		ListaGenerica<Vertice<String>> listaCiudades = this.mapaCiudades.listaDeVertices();
		
		// creo vertices de origen y destino
		Vertice<String> origen = null;
		Vertice<String> destino = null;
		
		// busco los vertices de origen y destino
		listaCiudades.comenzar();
		while ( !listaCiudades.fin() ) {
			
			// Guardo el vertice actual
			Vertice<String> ciudadActual = listaCiudades.proximo();
			
			// si el vertice actual es la ciudad origen, lo guardo
			if( ciudadActual.dato().equals(ciudad1) ) {
				origen = ciudadActual;
			}
			
			// si el vertice actual es la ciudad destino, lo guardo
			if ( ciudadActual.dato().equals(ciudad2) ) {
				destino = ciudadActual;
			}
		}
		
		// creo un camino
		ListaGenerica<String> camino = new ListaEnlazadaGenerica<String>();
		
		// creo lista de marcados
		boolean [] marcas = new boolean[listaCiudades.tamanio()];
		
		// verifico que se encontraran los vertices
		if( origen != null && destino != null ) {
			devolverCamino( origen , destino , marcas , camino );
		}
		
		return camino;
		
	}
	
	private boolean devolverCamino ( Vertice<String> origen , Vertice<String> destino , boolean [] marcas , ListaGenerica<String> camino ) {
		
		// marco el vertice origen como visitado
		marcas[origen.getPosicion()] = true;
		
		// agrego vertice a la lista
		camino.agregarFinal( origen.dato() );
		
		// si se llego al destino, se dejan de recorrer los adyacentes
		if ( origen == destino ) {
			return true;
		}
		
		// obtengo lista de adyacentes de origen
		ListaGenerica<Arista<String>> ady = this.mapaCiudades.listaDeAdyacentes(origen);
		
		// recorro lista de adyacentes
		ady.comenzar();
		if ( !ady.fin() ) {
			
			// obtengo vertice adyacente
			Vertice<String> vertice = ady.proximo().verticeDestino();
			
			// si no fue visitado
			if ( !marcas[vertice.getPosicion()] ) {
				
				// llamada recursiva 
				return devolverCamino( vertice , destino , marcas , camino );
				
			}
			
		}
		
		// si no se encontro el destino, se elimina el vertice de la lista
		camino.eliminarEn( camino.tamanio() );
		
		return false;
		
	}
	
// ========================================================================================================================== //
//                                  	    Ejercicio 5 : devolverCaminoExceptuando
//========================================================================================================================== //
	
	
	public ListaGenerica<String> devolverCaminoExceptuando ( String ciudad1, String ciudad2, ListaGenerica<String> ciudades , ListaGenerica<String> exceptuar ) {
		
		// obtengo lista de vertices
		ListaGenerica<Vertice<String>> listaCiudades = this.mapaCiudades.listaDeVertices();
		
		// creo vertices de origen y destino
		Vertice<String> origen = null;
		Vertice<String> destino = null;
		
		
		listaCiudades.comenzar();
		while ( !listaCiudades.fin() ) {
			
			// guardo Vertice Actual
			Vertice<String> vertice = listaCiudades.proximo();
			
			// guardo el vertice de origen
			if ( vertice.dato().equals(ciudad1) ) {
				origen = vertice;
			}
			
			// guardo el vertice de destino
			if ( vertice.dato().equals(ciudad2) ) {
				destino = vertice;
			}
			
		}
		
		// creo un camino
		ListaEnlazadaGenerica<String> camino = new ListaEnlazadaGenerica<String>();
		
		// creo lista de marcados
		boolean[] marcas = new boolean[ listaCiudades.tamanio() ];
		
		
        if( (origen != null) && (destino != null) ){
        	
            devolverCaminoExceptuando( origen , destino , marcas , camino , exceptuar );
        }
		
		return camino;
		
	}
	
	private boolean devolverCaminoExceptuando ( Vertice<String> origen , Vertice<String> destino , boolean[] marcas , ListaEnlazadaGenerica<String> camino , ListaGenerica<String> exceptuar ) {
		
		// marco el vertice origen como visitado
		marcas[origen.getPosicion()] = true;
		
		// agrego vertice a la lista
		camino.agregarFinal( origen.dato() );
		
		// si se llego al destino, se dejan de recorrer los adyacentes
		if ( origen == destino ) {
			return true;
		}
		
		// obtengo lista de adyacentes del vertice actual
		ListaGenerica<Arista<String>> ady = this.mapaCiudades.listaDeAdyacentes(origen);
		
		// recorro lista de adyacentes
		ady.comenzar();
		while ( !ady.fin() ) {
			
			// obtengo vertice adyacente
			Vertice<String> vertice = ady.proximo().verticeDestino();
			
			// vertifico que el vertice no pertenesca a la lista de exeptuar, lo marco para que no se revise
            if( exceptuar.incluye( vertice.dato() ) ){
                marcas[ vertice.getPosicion() ] = true;
            }
            
			// si no esta marcado
			if ( !marcas[vertice.getPosicion()] ) {
				
				return devolverCaminoExceptuando( vertice , destino , marcas , camino , exceptuar );

			}
		}
		
		camino.eliminarEn(camino.tamanio());
		
		return false;

	}



// ========================================================================================================================= //
//  										Ejercicio 5 : caminoMasCorto ( peso )
//========================================================================================================================== //

	
	public ListaGenerica<String> caminoMasCorto( String ciudad1, String ciudad2 ) {
		
		// obtegno lista de ciudades
		ListaGenerica<Vertice<String>> listaCiudades = mapaCiudades.listaDeVertices();
		
		// creo un camino
		ListaEnlazadaGenerica<String> camino = new ListaEnlazadaGenerica<String>();
	
		// creo un camino auxiliar
		ListaEnlazadaGenerica<String> caminoAux = new ListaEnlazadaGenerica<String>(); 
		
		// posicion de la ciudad origen
		int pos = -1;
		
		// boolean para cancelar el while cuando se encuentre la ciudad origen 
		boolean ok = false;
		
		
		// recorrer lista de ciudades hasta encontrar el origen
		listaCiudades.comenzar();
		while ( (!listaCiudades.fin()) && (!ok) ) {
			
			// obtengo Vertice  
			Vertice<String> vertice = listaCiudades.proximo();
			
			// si el vertice es la ciudad origen  
			if ( vertice.dato() == ciudad1 ) {
				// se encontro la ciudad origen
				ok = true;
				// se encontro la posicion de la ciudad origen
				pos = vertice.getPosicion();
				// agregar origen a la lista
				caminoAux.agregarFinal( vertice.dato() );
			}
		}
		

		
		// si se encontro la ciudad origen
		if ( pos != -1 ) {
			
			// guardo un valor grande para comparar
			Min minimo = new Min(9999);
			
			// creo un arreglo de marcados
			boolean[]marca = new boolean[ mapaCiudades.listaDeVertices().tamanio() ];
			
			// creo una variable para poner la distancia
			int distancia = 0;
			
			dfsCorto( pos , caminoAux , camino , marca , ciudad2 , minimo , distancia );
		}
		
		return camino;
		
	}
	
	
	private void dfsCorto ( int pos , ListaEnlazadaGenerica<String> caminoAux , ListaEnlazadaGenerica<String> camino 
			                        , boolean[] marca , String ciudad2 , Min minimo , int distancia ) {
		
		// marco el vertice acutal como visitado
		marca[pos] = true;
		
		// selecciono el vertice acutal
		Vertice<String> v = mapaCiudades.listaDeVertices().elemento(pos);
		
		// si se encontro la ciudad 2
		if ( v.dato() == ciudad2 ) {
			// guardar distancia
			if ( distancia < minimo.getMinimo() ) {
				
				// guardar camino
				clonarLista( caminoAux , camino );
				
				// guardar nuevo minimo
				minimo.setMinimo( distancia );
				
				// NO MARCO EL DESTINO PORQUE VOY A VOLVER A IR AHI
				marca[pos] = false;
			}
			
		} else {
			
			// obtengo lista de adyacentes del vertice
			ListaGenerica<Arista<String>> ady = mapaCiudades.listaDeAdyacentes(v);
			
			ady.comenzar();
			while ( !ady.fin() ) {
				
				// obtengo arista adyacente
				Arista<String> arista = ady.proximo();
				
				// obtengo posicion del vertice
				int j = arista.verticeDestino().getPosicion();
				
				// si no esta visitado
				if ( !marca[j] ) {
					
					// sumo el peso de la arista
					distancia+= arista.peso();
					
					// agrego elemento a la lista
					caminoAux.agregarFinal( arista.verticeDestino().dato() );
					
					// llamada recursiva
					dfsCorto( j , caminoAux , camino , marca , ciudad2 , minimo , distancia );
					
					// eliminar de la lista
					caminoAux.eliminarEn( caminoAux.tamanio() );
					
					// restar peso
					distancia -= arista.peso();
				}
			}
		}
	}
	
	
	private void clonarLista ( ListaGenerica<String> lista , ListaGenerica<String> clon ) {		
		lista.comenzar();
		while( !lista.fin() ) {
			clon.agregarFinal( lista.proximo() );
		}
	}
	

// ========================================================================================================================= //
//											Ejercicio 5 : caminoMasCorto ( vertices )
//========================================================================================================================== //
	

		public ListaGenerica<String> caminoCortoVertices( String ciudad1 , String ciudad2 ) {
			
			// lista de vertices
			ListaGenerica<Vertice<String>> listaCiudades = this.mapaCiudades.listaDeVertices();
			
			// camino resultante
			ListaGenerica<String> camino = new ListaEnlazadaGenerica<String>();
			
			// camino auxiliar
			ListaGenerica<String> caminoAux = new ListaEnlazadaGenerica<String>();			
			
			// Array de marcas
			boolean[] marca = new boolean[ listaCiudades.tamanio() ];
			
			// posicion
			int pos = -1;
			
			// contador
			Contador contador = new Contador(9999);
			
			// recorrer lista hasta encontrar la posicion del vertice
			listaCiudades.comenzar();
			while ( !listaCiudades.fin() && ( pos != -1 ) ) {
				
				// busco si existe el vertice de origen y guardo su posicion
				if ( listaCiudades.proximo().dato().equals( ciudad1 ) ) {
					pos = listaCiudades.proximo().getPosicion();
				}	
			}
			
			
			if ( pos != -1 ) {
				
				caminoCortoVertices( camino , caminoAux , marca , pos , ciudad2 , contador );
			}
			
			return camino;
					
		}
	
		
		private void caminoCortoVertices( ListaGenerica<String> camino , ListaGenerica<String> caminoAux ,
										  boolean[] marca , int pos , String destino , Contador contador ) {
			
			
			// agarro el vertice actual
			Vertice<String> vertice = mapaCiudades.listaDeVertices().elemento( pos );
			
			// marco el vertice como visitado
			marca[pos] = true;
			
			// si se llego a destino
			if ( vertice.dato().equals(destino) ) {
				
				if( caminoAux.tamanio() < contador.getCantidad() ) {
					// clono la lista
					clonarLista( caminoAux , camino );
					// guardar cantidad
					contador.setCantidad( caminoAux.tamanio() );
					// marco como no visitado para volver a chekear
					marca[pos] = false;
				}
				
			} else {
				
				// obtengo lista de adyacentes del vertice
				ListaGenerica<Arista<String>> ady = mapaCiudades.listaDeAdyacentes(vertice);
				
				// recorrer lista de adyacentes
				ady.comenzar();
				while ( !ady.fin() ) {
					
					// agarro el vertice adyacente
					Vertice<String> v = ady.proximo().verticeDestino();
					
					// si el vertice no esta visitado
					if ( !marca[v.getPosicion()] ) {
					
						// agrego a la lista de ciudades
						caminoAux.agregarFinal( v.dato() );
						
						// llamada recursiva
						caminoCortoVertices( camino , caminoAux , marca , pos , destino , contador );
						
						// elimino de la lista
						caminoAux.eliminarEn( caminoAux.tamanio() );
					}
					
				}
				
			}

		}
	
	
	

	
	
	
	
	
	
	
	
	
	
}
