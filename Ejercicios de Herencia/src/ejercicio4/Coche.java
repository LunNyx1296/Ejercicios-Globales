package ejercicio4;

public class Coche extends Vehiculos {

	private int numPuertas;
	private boolean esElectrico;

	public Coche(String marca, String modelo, double precioPorHora, int numPuertas, boolean esElectrico) {
		super(marca, modelo, precioPorHora);
		this.numPuertas = numPuertas;
		this.esElectrico = esElectrico;
	}

	@Override
	public double calcularPrecioAlquiler(int horas) {
		double precioBase = super.calcularPrecioAlquiler(horas);
		if (esElectrico) {
			return precioBase * 0.9; // 10% discount
		}
		return precioBase;
	}

	@Override
	public String descripcion() {
		return super.descripcion() + ", Número de puertas: " + numPuertas + ", Eléctrico: " + (esElectrico ? "Sí" : "No");
	}
}