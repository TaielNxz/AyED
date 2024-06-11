package ej02;

public class Alumno {

	private String legajo;
	private String nombre;
	private String apellido;
	private int dni;
	private String email;
	
	public Alumno(String legajo, String nombre, String apellido, int dni, String email) {
		this.legajo = legajo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.email = email;
	}

	public String getLegajo() {
		return legajo;
	}

	public void setLegajo(String legajo) {
		this.legajo = legajo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String tusDatos() {
		return    "\n nombre: " + getNombre() 
				+ "\n apellido: " + getApellido() 
				+ "\n email: " + getEmail() 
				+ "\n dni: " + getDni()
				+ "\n email: " + getEmail();
	}
}
