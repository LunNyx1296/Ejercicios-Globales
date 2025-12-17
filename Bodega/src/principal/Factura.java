package principal;

import java.util.ArrayList;

public class Factura implements IFacturacion {

	private int numero;
	private String nombre;
	private String apellido;
	private ArrayList<LineaFactura> lineasFactura = new ArrayList<>();

	public Factura(int numero, String nombre, String apellido) {
		this.numero = numero;
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public void añadirLinea(String codigo, int cantidad, double total) {
		lineasFactura.add(new LineaFactura(codigo, cantidad, total));
	}

	@Override
	public double calcularTotal() {
		double totalSinIVA = 0;
		for (LineaFactura l : lineasFactura)
			totalSinIVA += l.getTotalLinea();
		return totalSinIVA * (1 + IVA);
	}

	public void print() {
		System.out.println("Numero: " + numero);
		System.out.println("Nombre: " + nombre);
		System.out.println("Apellido: " + apellido);

		for (LineaFactura l : lineasFactura)
			System.out.println(l);

		System.out.println("TOTAL CON IVA: " + calcularTotal());
	}
}