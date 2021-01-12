package paquete;

public class Departamento{
	private int numero_depto;
	private String nombre;
	private int cant_trabajadores;
	public Departamento(int numero_depto,String nombre,int cantidad_trabajadores) {
		this.numero_depto = numero_depto;
		this.nombre = nombre;
		this.cant_trabajadores = cantidad_trabajadores;
	}
	//METODOS SETTERS Y GETTERS
	public void setNumero_depto(int numero_depto) {
		this.numero_depto = numero_depto;
	}
	public int getNumero_depto() {
		return numero_depto;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNombre() {
		return nombre;
	}
	public void setCantidad_trabajadores(int cantidad) {
		this.cant_trabajadores = cantidad;
	}
	public int getCantidad_trabajadores() {
		return cant_trabajadores;
	}
	
	
}
