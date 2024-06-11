package ejercicio04;

import cositas.*;


public class recorridos<T> {

	public void dfs(Grafo<T> grafo){
		
		// crea arreglo de marcados
		boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];
		
		// recorro todos los vertices
		for( int i=0 ; i<grafo.listaDeVertices().tamanio() ; i++ ) {
			// si no esta marcado
			if ( !marca[i] )
				this.dfs( i, grafo, marca );
		}
	}
	
	private void dfs( int i , Grafo<T> grafo , boolean[] marca ) {
		
		// marco el vertice como visitado
		marca[i] = true;
		
		// creo una arista auxiliar
		Arista <T> arista = null;
		
		// obtengo el vertice actual
		Vertice<T> v = grafo.listaDeVertices().elemento(i);
		
		// imprimo el dato del vertice
		System.out.println(v);
		
		// obtengo sus ayacentes
		ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(v);
		
		// comienzo  recorrer lista de adyacentes
		ady.comenzar();
		while( !ady.fin() ) {
			
			// agarro la arista
			arista = ady.proximo();
			
			// obtengo la posicion del vertice adyacente
			int j = arista.verticeDestino().getPosicion();
			
			// si no fue visitado hago una llamada recursiva
			if( !marca[j] )
				this.dfs( j , grafo , marca );
		}
	}


	
	public void bfs(Grafo<T> grafo) {
		
		// crea arreglo de marcados
		boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];
		
		for (int i = 0; i < marca.length; i++) {
			if ( !marca[i] )
				this.bfs( i+1 , grafo , marca ); //las listas empiezan en la pos 1
		}
	}
	
	
	private void bfs( int i, Grafo<T> grafo , boolean[] marca ) {
		
		// creo lista de adycentes
		ListaGenerica<Arista<T>> ady = null;
		
		// creo una cola de vertices
		ColaGenerica<Vertice<T>> q = new ColaGenerica<Vertice<T>>();
		
		// encolo el vertice
		q.encolar( grafo.listaDeVertices().elemento(i) );
		
		// marco el vertice como visitado
		marca[i] = true;
		
		// mientras la cola no este vacia
		while ( !q.esVacia() ) {
			
			// desencolo vertice
			Vertice<T> v = q.desencolar();
			
			// imprimo el dato del vertice
			System.out.println(v);
			
			// obtengo adyacentes del vertice
			ady = grafo.listaDeAdyacentes(v);
			
			// recorro la lista de adyacentes
			ady.comenzar();
			
			while (!ady.fin()) {
				
				Arista<T> arista = ady.proximo();
				
				int j = arista.verticeDestino().getPosicion();
			
				if (!marca[j]) {
					Vertice<T> w = arista.verticeDestino();
					marca[j] = true;
					q.encolar(w);
				}
			
			}
		}
	}

}
