package ej01;
import cositas.*;

public class Sucesiones {

    public static int calcular( int n ) {
    	
        if ( n % 2 == 0 ) { // ES PAR
            n = n / 2;
        } else {            // ES IMPAR
                n = 3*n+1;
        }
   
        return n;
    }
    
    
    public static ListaDeEnterosEnlazada calcularSucesion ( int n ) {
        
    	ListaDeEnterosEnlazada lista;
    	
        if ( n > 1 ){
        	lista = calcularSucesion( calcular(n) );
        } else {
        	lista = new ListaDeEnterosEnlazada();
        }
        
        lista.agregarInicio(n);
        
        return lista;
    }
    
    public static void main(String[] args) {
    	Sucesiones f = new Sucesiones();
        ListaDeEnterosEnlazada lista = f.calcularSucesion(6);
        
        //Imprimir
        lista.comenzar();
        while ( !lista.fin() ) {
            System.out.println( lista.proximo() );
        }
    }
 
}
