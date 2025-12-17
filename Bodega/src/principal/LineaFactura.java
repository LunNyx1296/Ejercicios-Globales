package principal;

public class LineaFactura {

	private String codigo;
	private int cantidad;
	private double totalLinea;

	public LineaFactura(String codigo, int cantidad, double totalLinea) {
		this.codigo = codigo;
		this.cantidad = cantidad;
		this.totalLinea = totalLinea;
	}

	public double getTotalLinea() {
		return totalLinea;
	}

	@Override
	public String toString() {
		return "LineaFactura [codigo=" + codigo + ", cantidad=" + cantidad + ", totalLinea=" + totalLinea + "]";
	}

}
