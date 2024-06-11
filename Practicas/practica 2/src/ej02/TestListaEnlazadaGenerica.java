/*
 	2.3. Escriba una clase llamada TestListaEnlazadaGenerica 
	que cree 4 objetos de tipo Estudiante (implementado en el TP01B) 
	y los agregue a un objeto de tipo ListaEnlazadaGenerica 
	usando los diferentes métodos de la lista 
	y luego, imprima los elementos de dicha lista usando el método tusDatos().
 */

package ej02;
import cositas.*;


public class TestListaEnlazadaGenerica {

	public static void main(String[] args) {

		// Crea cuatro alumnos
		Alumno alumno1 = new Alumno( "1111/11" , "Nombre1" , "Apellido1" , 11111111 , "alumno1@hotmail.com" );
		Alumno alumno2 = new Alumno( "2222/22" , "Nombre2" , "Apellido2" , 22222222 , "alumno2@hotmail.com" );
		Alumno alumno3 = new Alumno( "3333/33" , "Nombre3" , "Apellido3" , 33333333 , "alumno3@hotmail.com" );
		Alumno alumno4 = new Alumno( "4444/44" , "Nombre4" , "Apellido4" , 44444444 , "alumno4@hotmail.com" );
		
		// Crea la lista 
		ListaEnlazadaGenerica<Alumno> l = new ListaEnlazadaGenerica<Alumno>();
		
		// Agrega los alumnos a la lsita
		l.agregarFinal(alumno1);
		l.agregarFinal(alumno2);
		l.agregarFinal(alumno3);
		l.agregarFinal(alumno4);
			
		// Recorre e imprime la lista
		l.comenzar();
		while( !l.fin() ) {
			System.out.println( l.proximo().tusDatos() );
		}
	}

}
