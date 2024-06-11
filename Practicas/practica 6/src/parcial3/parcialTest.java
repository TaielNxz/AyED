package parcial3;

import cositas.*;

public class parcialTest {

	public static void main(String[] args) {
		parcial parcial = new parcial();
		
		Grafo<String> ciudades = new GrafoImplListAdy<String>();
		
		VerticeImplListAdy<String>v1=new VerticeImplListAdy<String>("Paris");
		VerticeImplListAdy<String>v2=new VerticeImplListAdy<String>("Bruselas");
		VerticeImplListAdy<String>v3=new VerticeImplListAdy<String>("Amsterdam");
		VerticeImplListAdy<String>v4=new VerticeImplListAdy<String>("Milan");
		VerticeImplListAdy<String>v5=new VerticeImplListAdy<String>("Bologna");
		VerticeImplListAdy<String>v6=new VerticeImplListAdy<String>("Montpellier");
		VerticeImplListAdy<String>v7=new VerticeImplListAdy<String>("Valencia");
		VerticeImplListAdy<String>v8=new VerticeImplListAdy<String>("Barcelona");
		
		v1.conectar(v2);
		v1.conectar(v3);
		v1.conectar(v7);
		v1.conectar(v8);
		
		v2.conectar(v3);
		v2.conectar(v1);
		
		v3.conectar(v4);
		v3.conectar(v1);
		v3.conectar(v2);
		
		v4.conectar(v3);
		v4.conectar(v5);
		v4.conectar(v6);
		
		v5.conectar(v4);
		
		v6.conectar(v4);
		v6.conectar(v7);
		
		v7.conectar(v8);
		v7.conectar(v6);
		v7.conectar(v1);
		
		v8.conectar(v1);
		v8.conectar(v7);
		
		ciudades.agregarVertice(v1);
		ciudades.agregarVertice(v2);
		ciudades.agregarVertice(v3);
		ciudades.agregarVertice(v4);
		ciudades.agregarVertice(v5);
		ciudades.agregarVertice(v6);
		ciudades.agregarVertice(v7);
		ciudades.agregarVertice(v8);
		
		ListaGenerica<String> camino = parcial.resolver(ciudades, "Paris");
		
		camino.comenzar();
		while(!camino.fin()) {
			System.out.println(camino.proximo());
		}
	}
}
