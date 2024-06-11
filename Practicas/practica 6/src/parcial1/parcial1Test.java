package parcial1;

import cositas.*;

public class parcial1Test {

	public static void main(String[] args) {
		
		Grafo<String> grafo = new GrafoImplListAdy<String>();
		
		// crear vertices
		Vertice<String> paris = new VerticeImplListAdy<String>("Paris");
		Vertice<String> barcelona = new VerticeImplListAdy<String>("Barcelona");
		Vertice<String> valencia = new VerticeImplListAdy<String>("Valencia");
		Vertice<String> bruselas = new VerticeImplListAdy<String>("Bruselas");
		Vertice<String> montpellier = new VerticeImplListAdy<String>("montpellier");
		Vertice<String> amsterdam = new VerticeImplListAdy<String>("Amsterdam");
		Vertice<String> milan = new VerticeImplListAdy<String>("Milan");
		Vertice<String> bologna = new VerticeImplListAdy<String>("Bologna");
		
		// agregar vertices
		grafo.agregarVertice(paris);
		grafo.agregarVertice(barcelona);
		grafo.agregarVertice(valencia);
		grafo.agregarVertice(bruselas);
		grafo.agregarVertice(montpellier);
		grafo.agregarVertice(amsterdam);
		grafo.agregarVertice(milan);
		grafo.agregarVertice(bologna);
		
		// conectar ciudades
		grafo.conectar( paris , barcelona );
		grafo.conectar( paris , valencia );
		grafo.conectar( paris , bruselas );
		grafo.conectar( paris , amsterdam );
		
		grafo.conectar( barcelona , paris );
		grafo.conectar( barcelona , valencia );
		
		grafo.conectar( valencia , barcelona );
		grafo.conectar( valencia , paris );
		grafo.conectar( valencia , montpellier );
		
		grafo.conectar( bruselas , paris );
		grafo.conectar( bruselas , amsterdam );
		
		grafo.conectar( montpellier , valencia );
		grafo.conectar( montpellier , milan );
		
		grafo.conectar( amsterdam , paris );
		grafo.conectar( amsterdam , bruselas );
		grafo.conectar( amsterdam , milan );
		
		grafo.conectar( milan , montpellier );
		grafo.conectar( milan , amsterdam );
		grafo.conectar( milan , bologna );
		
		grafo.conectar( bologna , milan );
		
		parcial1 caminoLargo = new parcial1();
		
		ListaGenerica<String> lista = caminoLargo.caminoMasLargo( grafo, "Paris" );
		
		System.out.print( lista.tamanio() );
		
		lista.comenzar();
		while( !lista.fin() ) {
			
			System.out.print( lista.proximo() );
		}

	}

}
