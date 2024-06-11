package ej01;
import cositas.ListaDeEnterosConArreglos;

public class TestListaDeEnterosConArreglos {

	public static void main(String[] args) {
		// Crear lista
		ListaDeEnterosConArreglos lista = new ListaDeEnterosConArreglos();
		
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
