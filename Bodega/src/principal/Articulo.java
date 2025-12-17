package principal;

public abstract class Articulo {
	protected String codigo;
	protected String nombre;
	protected String marca;
	protected double precio;
	protected int stock;

	public Articulo(String codigo, String nombre, String marca, double precio, int stock) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.marca = marca;
		this.precio = precio;
		this.stock = stock;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public String getMarca() {
		return marca;
	}

	public double getPrecio() {
		return precio;
	}

	public int getStock() {
		return stock;
	}

	public void SumarStock(int cantidad) {
		stock += cantidad;
	}

	public void QuitarStock(int cantidad) {
		stock -= cantidad;
	}

	public abstract void printCaracteristicas();
	
	public abstract boolean sano();
}