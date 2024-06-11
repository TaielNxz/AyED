package cositas;

/**
 * Implementacion del grafo con lista de ady
 * 
 * @author juan
 *
 */

public class GrafoImplListAdy<T> implements Grafo<T> {
	ListaGenerica<Vertice<T>> vertices = new ListaEnlazadaGenerica<Vertice<T>>();


	@Override
	public void agregarVertice(Vertice<T> v) {
		if(!vertices.incluye(v)){
		    vertices.agregarFinal(v);
			((VerticeImplListAdy<T>) v).setPosicion(vertices.tamanio());
		}
	}

	@Override
	public void eliminarVertice(Vertice<T> v) {
		int indice = ((VerticeImplListAdy<T>)v).getPosicion();
		if(indice >=0){
			Vertice<T> vert;
			vertices.comenzar();
			while(!vertices.fin()){
				vert = vertices.proximo();
				desConectar(vert, v);
			}
			
			boolean salir = false;
			vertices.comenzar();
			while(!vertices.fin() && !salir){
				vert = vertices.proximo();
				if(vert.equals(v)){
					vertices.eliminar(vert);
					salir = true;
				}
			}

			for(;indice<vertices.tamanio();indice++){
				vert = vertices.elemento(indice);
				((VerticeImplListAdy<T>)vert).setPosicion(vert.getPosicion()-1);
			}
		}
	}

	@Override
	public void conectar(Vertice<T> origen, Vertice<T> destino) {
		((VerticeImplListAdy<T>) origen).conectar(destino);
	}

	@Override
	public void conectar(Vertice<T> origen, Vertice<T> destino, int peso) {
		((VerticeImplListAdy<T>) origen).conectar(destino,peso);
	}

	@Override
	public void desConectar(Vertice<T> origen, Vertice<T> destino) {
		((VerticeImplListAdy<T>) origen).desconectar(destino);
	}

	@Override
	public boolean esAdyacente(Vertice<T> origen, Vertice<T> destino) {
		return ((VerticeImplListAdy<T>) origen).esAdyacente(destino);
	}

	@Override
	public boolean esVacio() {
		return vertices.esVacia();
	}

	@Override
	public ListaGenerica<Vertice<T>> listaDeVertices() {
		return vertices;
	}

	@Override
	public int peso(Vertice<T> origen, Vertice<T> destino) {
		return ((VerticeImplListAdy<T>) origen).peso(destino);
	}
	
    @Override
	public ListaGenerica<Arista<T>> listaDeAdyacentes(Vertice<T> v){
		return ((VerticeImplListAdy<T>) v).obtenerAdyacentes();
	}
	
    @Override
	public Vertice<T> vetice(int posicion){
		return vertices.elemento(posicion);
	}
    
    
    // Retorna una lista de vértices con el recorrido en profundidad del grafo recibido como parámetro.
    public void dfs_print( Grafo<T> grafo ) {
    	
        boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()+1];
        
        for ( int i=1 ; i<=grafo.listaDeVertices().tamanio() ; i++ ) {
            if ( !marca[i] ){
                this.dfs_print( i , grafo , marca );
            }
        }
    }
    
    private void dfs_print ( int i , Grafo<T> grafo , boolean[] marca ) {
		
    	// Lo marcamos como visitado
    	marca[i] = true; 
    	
    	// Tomamos el vertice
		Vertice<T> v = grafo.listaDeVertices().elemento(i);
		
		// imprimirmos el dato del vertice
		System.out.print( v.dato() );
		
		// Tomamos sus adyacentes
		ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(v); 
		
		// Recorremos los adyacentes
		ady.comenzar();
		while ( !ady.fin() ) { 
			// revisamos si los adyacentes fueron visitados y si no fue asi llamamos al dfs
			int j = ady.proximo().verticeDestino().getPosicion(); 
			if ( !marca[j] ) 
				dfs_print( j , grafo , marca );
		}
    }
    
    
    // Retorna una lista de vértices con el recorrido en profundidad del grafo recibido como parámetro.
    public ListaEnlazadaGenerica<Vertice<T>> dfs_salida( Grafo<T> grafo ) {
    	
        boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()+1];
        
        ListaEnlazadaGenerica<Vertice<T>> lis = new ListaEnlazadaGenerica<Vertice<T>>();
        
        for ( int i=1 ; i<=grafo.listaDeVertices().tamanio() ; i++ ) {
            if ( !marca[i] ){
                this.dfs_salida( i , grafo , marca , lis );
            }
        }
        
        return lis;
    }
    
    private void dfs_salida ( int i , Grafo<T> grafo , boolean[] marca , ListaEnlazadaGenerica<Vertice<T>> lis ) {
		
    	// Lo marcamos como visitado
    	marca[i] = true; 
    	
    	// Tomamos el vertice
		Vertice<T> v = grafo.listaDeVertices().elemento(i);
		
		// agregamos el vertice a la lista de salida
		lis.agregarFinal(v);
		
		// Tomamos sus adyacentes
		ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(v); 
		
		// Recorremos los adyacentes
		ady.comenzar();
		while ( !ady.fin() ) { 
			// revisamos si los adyacentes fueron visitados y si no fue asi llamamos al dfs
			int j = ady.proximo().verticeDestino().getPosicion(); 
			if ( !marca[j] ) 
				dfs_salida( j , grafo , marca , lis );
		}
    }
    
    
    
    
    public ListaGenerica<ListaGenerica<Vertice<String>>> dfs_caminos ( Grafo<String> grafo ) {
    	
    	// creo lista de visitados
    	boolean[] marcas = new boolean[grafo.listaDeVertices().tamanio()+1]; 
    	
    	// creo lista de caminos
    	ListaGenerica<ListaGenerica<Vertice<String>>> recorridos = new ListaEnlazadaGenerica<ListaGenerica<Vertice<String>>>();
    	
    	// creo camino
    	ListaGenerica<Vertice<String>>camino = null;
    	
    	int costo = 0;
	
    	for ( int i=0 ; i <= grafo.listaDeVertices().tamanio() ; i++ ) {
    		
    		// creo un nuevo camino
    		camino = new ListaEnlazadaGenerica<Vertice<String>>();
    		
    		// agrego el vertice actual al inicio del camino
    		camino.agregarInicio(grafo.listaDeVertices().elemento(i));
    		
    		// lo marco como visitado
    		marcas[i]=true;

    		// voy recorriendo el grafo para ver si se puede crear el camino
    		this.dfs_caminos( i , grafo , marcas, camino , costo , recorridos );
    		
    		// quito la marca para que sea posible agregar esta ciudad en otro camino
    		marcas[i]=false;
    	}
    	
    	
    	return recorridos;
    }
    
    private void dfs_caminos ( int i , Grafo<String> grafo , boolean[] marcas , ListaGenerica<Vertice<String>> camino ,  int costo , ListaGenerica<ListaGenerica<Vertice<String>>> recorridos ) {

    	// obtenemos el vertice actual
    	Vertice<String> v = grafo.listaDeVertices().elemento(i);
    	
    	// obtenemos los adyacentes
    	ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(v);
    	
    	// recorremos los adyacentes
    	ady.comenzar();
    	while( !ady.fin() ) {
    		
    		// obtenemos arista actual
    		Arista<String> arista = ady.proximo();
    		
    		// obtenemos la posicion del vertice adyacente
    		int j = arista.verticeDestino().getPosicion(); 
    		
    		// si el vertice adyacente no fue visitado
    		if ( !marcas[j] ) {
    		
    			// verifico el peso
    			if ( (arista.peso()+costo) <= 10 ) {
    				
    				// guardo el vertice adyacente
    				Vertice<String> vDestino = arista.verticeDestino();
    				
    				// lo agrego al camino
    				camino.agregarFinal(vDestino);
    				
    				// marco el vertice como visitado
    				marcas[j] = true;
    				
    				// si el camino actual suma costo 10..
    				if ( (arista.peso()+costo) == 10 ) {
    					// se guarda el camino
    					recorridos.agregarFinal( camino.clonar() );
    				} else {
    					// sino sesigue armano el camino
    					this.dfs_caminos( j , grafo , marcas , camino , arista.peso()+costo , recorridos );
    				}
    				
    				// se elimina el camino 
    				camino.eliminar(vDestino);
    				// se resetan las marcas en false
    				marcas[j]=false;
    					
    			}
    		}
    		
    	}
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
	public ListaGenerica<Vertice<T>> BFS (Grafo<T> grafo){
		
		boolean[] marca = new boolean[grafo.listaDeVertices().tamanio() + 1];
		
		ListaEnlazadaGenerica<Vertice<T>> lis = new ListaEnlazadaGenerica<Vertice<T>>();
		
		for (int i=1; i<=grafo.listaDeVertices().tamanio(); i++) {
			if (!marca[i])
				BFS(i,grafo,lis,marca);
		}
		
		return lis;
	}
	
	
	private void BFS ( int i , Grafo<T> grafo , ListaEnlazadaGenerica<Vertice<T>> lista , boolean[] marca ) {
		
		ListaGenerica<Arista<T>> listaAdj = null; //inicializamos lista
		ColaGenerica<Vertice<T>> cola = new ColaGenerica<Vertice<T>>(); //inicializamos cola
		cola.encolar(grafo.listaDeVertices().elemento(i)); // encolamos el elemento donde vamos a empezar a recorrer
		marca[i]= true; // Lo marcamos 
		
		while( !cola.esVacia() ) { 
			
			Vertice <T> v = cola.desencolar(); // Desencolamos 
			
			lista.agregarFinal(v); // Agregamos a la lista 
			
			listaAdj = grafo.listaDeAdyacentes(v); // Obtenemos sus adyacentes
			
			listaAdj.comenzar(); // colocamos el puntero al inicio
			while( !listaAdj.fin() ) { // Mientras posea adyacentes
				
				Arista<T> arista = listaAdj.proximo();// obtenemos la arista que conecta a el con su adyacente
				int j = arista.verticeDestino().getPosicion(); // sacamos su posicion 
				
				if (!marca[j]) { // si no esta marcado lo recorremos
					Vertice<T> w = arista.verticeDestino(); // obtenemos el apuntado
					marca[j] = true; // lo marcamos
					cola.encolar(w); // encolamos dicho adyacente
				}
			}
		}	
	}
}
