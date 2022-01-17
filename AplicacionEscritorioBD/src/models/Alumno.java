package models;

public class Alumno {
	private String nombre;
	private String apellidos;
	private String ciclo;
	private double media;
	
	public Alumno(String nombre, String apellidos, String ciclo, double media) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.ciclo = ciclo;
		this.media = media;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCiclo() {
		return ciclo;
	}

	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}

	public double getMedia() {
		return media;
	}

	public void setMedia(double media) {
		this.media = media;
	}

	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", apellidos=" + apellidos + ", ciclo=" + ciclo + ", media=" + media + "]";
	}
}
