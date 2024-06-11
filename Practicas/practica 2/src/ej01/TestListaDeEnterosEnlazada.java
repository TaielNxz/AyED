package ej01;
import cositas.ListaDeEnterosEnlazada;

public class TestListaDeEnterosEnlazada {

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
		while( !lista.fin() ) {	
			System.out.print( lista.proximo() + " " );
		}
	}
}
