/*
 *	Ejercicio 7
 *
 *	Sea una red de agua potable, la cual comienza en un caño maestro y la misma se va dividiendo 
 *	sucesivamente hasta llegar a cada una de las casas.
 *	
 *  Por el caño maestro ingresan “x” cantidad de litros y en la medida que el caño se divide, de acuerdo 
 *	con las bifurcaciones que pueda tener, el caudal se divide en partes iguales en cada una de ellas. 
 *  
 *  Es decir, si un caño maestro recibe 1000 litros y tiene por ejemplo 4 bifurcaciones 
 *  se divide en 4 partes iguales, donde cada división tendrá un caudal de 250 litros.
 *  
 *  Luego, si una de esas divisiones se vuelve a dividir, por ej. en 5 partes, 
 *  cada una tendrá un caudal de 50 litros y así sucesivamente hasta llegar un lugar sin bifurcaciones.
 *  
 *  Se debe implementar una clase RedDeAguaPotable que contenga el método con la siguiente firma:
 *  
 *  public double minimoCaudal(double caudal)
 *  
 *  que calcule el caudal de cada nodo y determine cuál es el mínimo caudal que recibe una casa. 
 *  Asuma que la estructura de caños de la red está representada por una variable de instancia 
 *  de la clase RedAguaPotable y que es un ArbolGeneral.
 *  Extendiendo el ejemplo en el siguiente gráfico, al llamar al método minimoCaudal con un valor de 
 *  1000.0 debería retornar 25.
 */

package ej07;

import cositas.*;

public class RedDeAguaPotable<T> {

	private ArbolGeneral<Double> estructura;
	
	public RedDeAguaPotable( ArbolGeneral<Double> estructura ) {
		this.estructura = estructura;
	}
	
	
	public double minimoCaudal( double caudal ){
		
        Double min = 9999.9;
        
        if ( estructura.tieneHijos() ){
        	
        	// crear lista de hijos
            ListaGenerica<ArbolGeneral<Double>> listaHijos = estructura.getHijos();
            
            // calcular el caudal de cada hijo
            Double caudalHijo = caudal / listaHijos.tamanio();
            
            // asignar caudal a cada hijo
            for ( int i = 1 ; i <= listaHijos.tamanio() ; i++ )  {
            	listaHijos.elemento(i).setDato( caudalHijo );
            }
            
            
            listaHijos.comenzar();
            while ( !listaHijos.fin() ) {
                RedDeAguaPotable redHijo = new RedDeAguaPotable( listaHijos.proximo() );
                min = Math.min( redHijo.minimoCaudal(caudalHijo) , min );
            }
            
            return min;
            
        } else {
            return estructura.getDato();
        }
    }
}
