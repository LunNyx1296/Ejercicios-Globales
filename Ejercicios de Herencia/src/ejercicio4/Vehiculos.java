package ejercicio4;

public abstract class Vehiculos {

	private static int contador = 0;
	private int idVehiculo;
	private String marca;
	private String modelo;
	private double precioPorHora;

	public Vehiculos(String marca, String modelo, double precioPorHora) {
		this.idVehiculo = ++contador;
		this.marca = marca;
		this.modelo = modelo;
		this.precioPorHora = precioPorHora;
	}

	public double calcularPrecioAlquiler(int horas) {
		return precioPorHora * horas;
	}

	public String descripcion() {
		return "ID: " + idVehiculo + ", Marca: " + marca + ", Modelo: " + modelo + ", Precio por hora: " + precioPorHora;
	}
}