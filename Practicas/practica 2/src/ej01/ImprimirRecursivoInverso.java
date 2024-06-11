package ej01;
import cositas.ListaDeEnterosEnlazada;

public class ImprimirRecursivoInverso {

	public static void imprimirInverso( ListaDeEnterosEnlazada L , int pos ) {
		
		if( pos > 0 ) {
			System.out.print( L.elemento(pos) + " " );
			pos--;
			imprimirInverso( L , pos );
		}
	}
	
	public static void main(String[] args) {
		// Crear lista
		ListaDeEnterosEnlazada lista = new ListaDeEnterosEnlazada();
		
		// Cargar datos
		lista.agregarFinal(1);
		lista.agregarFinal(2);
		lista.agregarFinal(3);
		lista.agregarFinal(4);
		
		// Recorrer e Imprimir
		lista.comenzar();
		imprimirInverso( lista , lista.tamanio() );
	}

}
