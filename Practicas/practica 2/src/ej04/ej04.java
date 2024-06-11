/*
	4. Considere un string de caracteres S, 
	el cual comprende únicamente los caracteres: (,),[,],{,}. 
	Decimos que S está balanceado si tiene alguna de las siguientes formas:
	
	S = "" S es el string de longitud cero.
	S = "(T)"
	S = "[T]"
	S = "{T}"
	S = "TU"
	
	Donde ambos T y U son strings balanceados. Por ejemplo, "{( ) [ ( ) ] }" 
	está balanceado, pero "( [ ) ]" no lo está.
 */

package ej04;
import cositas.*;
import ej03.*;
import java.util.Scanner;

public class ej04 {

	 public static boolean esBalanceado(String cadena) {
        
		 
		ListaGenerica<Character> inicio = new ListaEnlazadaGenerica<Character>();
        inicio.agregarFinal('(');
        inicio.agregarFinal('[');
        inicio.agregarFinal('{');
        ListaGenerica<Character> cierre = new ListaEnlazadaGenerica<Character>();
        cierre.agregarFinal('(');
        cierre.agregarFinal('[');
        cierre.agregarFinal('{');
        PilaGenerica<Character> pila = new PilaGenerica<Character>();
       
        Character actual;
        Character elem;
        
	    for ( int i=0 ; i<cadena.length() ; i++ ) {
            
	    	actual = cadena.charAt(i);
            
            if ( inicio.incluye(actual) ) {
                pila.apilar(actual);
            } else {
                elem = pila.desencolar();
                
                if (inicio.elemento(elem) != cierre.elemento(actual)) {
                    return false;
                }
            }

	    }

	    if ( !pila.esVacia() ) {
	    	return false;
	    }
	        
	    return true;
    }
	 
	 
    public static void main(String[] args) {
    	// Llamar al scanner para ingresar datos
        Scanner scanner = new Scanner(System.in);
        
        // Ingresar caracteres
        System.out.println("ingresar caracteres {}[](): ");
		String S = scanner.nextLine();
		scanner.close();
  
		// Revisar si la exprecion balanceada
        if ( esBalanceado(S) ){
            System.out.println( "La expresion esta balanceada: " + S );
        } else {
        	System.out.println( "La expresion no esta balanceada" );
        }
    }
}
