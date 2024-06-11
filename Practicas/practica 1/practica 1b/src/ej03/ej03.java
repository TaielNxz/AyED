/*
	a. Cree una clase llamada Estudiante con los atributos especificados abajo y
	sus correspondientes métodos getters y setters (haga uso de las facilidades
	que brinda eclipse)
		● nombre
		● apellido
		● comision
		● email
		● direccion
		
	b. Cree una clase llamada Profesor con los atributos especificados abajo y sus
	correspondientes métodos getters y setters (haga uso de las facilidades que
	brinda eclipse)
		● nombre
		● apellido
		● email
		● catedra
		● facultad
		
	c. Agregue un método de instancia llamado tusDatos() en la clase Estudiante
	y en la clase Profesor, que retorne un String con los datos de los atributos
	de las mismas. Para acceder a los valores de los atributos utilice los getters
	previamente definidos.
	
	d. Escriba una clase llamada Test con el método main, el cual cree un arreglo
	con 2 objetos Estudiante, otro arreglo con 3 objetos Profesor, y luego
	recorra ambos arreglos imprimiendo los valores obtenidos mediante el
	método tusDatos(). Recuerde asignar los valores de los atributos de los
	objetos Estudiante y Profesor invocando los respectivos métodos setters.
	
	e. Agregue dos breakpoints, uno en la línea donde itera sobre los estudiantes y
	otro en la línea donde itera sobre los profesores
	
	f. Ejecute el Test en modo debug y avance paso a paso visualizando si
	estudiante o el profesor recuperado es lo esperado.
*/

package ej03;

public class ej03 {
	
	public static void main(String[] args) {
	
       	Estudiante[] Estudiantes = new Estudiante[2];
        Profesor[] Profesores = new Profesor[3];
        
        Estudiantes[0] = new Estudiante("alumno1" , "apellido1" , "email1@hotmail.com" , "comision1" , "direccion1");
        Estudiantes[1] = new Estudiante("alumno2" , "apellido2" , "email2@hotmail.com" , "comision2" , "direccion2");

        Profesores[0] = new Profesor("profe1" , "apellido1" , "email1@hotmail.com" , "caterdra1" , "facultad1");
        Profesores[1] = new Profesor("profe2" , "apellido1" , "email1@hotmail.com" , "caterdra1" , "facultad1");
        Profesores[2] = new Profesor("profe3" , "apellido1" , "email1@hotmail.com" , "caterdra1" , "facultad1");

        System.out.println("Estudiantes:");
        for ( int i=0 ; i<2 ; i++ ) {
        	System.out.println( Estudiantes[i].tusDatos() );
        }
        
        System.out.println("Profesores:");
        for ( int i=0 ; i<3 ; i++ ) {
        	System.out.println( Profesores[i].tusDatos() );
        }
	}
}
