package principal;

public class Refresco extends Articulo {

	private String sabor;
	private boolean zumo;
	private boolean gas;
	private int azucar;

	public Refresco(String codigo, String nombre, String marca, double precio, int stock, String sabor, boolean zumo,
			boolean gas, int azucar) {

		super(codigo, nombre, marca, precio, stock);
		this.sabor = sabor;
		this.zumo = zumo;
		this.gas = gas;
		this.azucar = azucar;
	}

	@Override
	public void printCaracteristicas() {
		System.out.println("Codigo: " + codigo);
		System.out.println("Nombre: " + nombre);
		System.out.println("Marca: " + marca);
		System.out.println("Precio: " + precio);
		System.out.println("Stock: " + stock);
		System.out.println("Sabor: " + sabor);
		System.out.println("Zumo: " + zumo);
		System.out.println("Gas: " + gas);
		System.out.println("Azucar: " + azucar);
	}

	@Override
	public boolean sano() {
		return azucar < 25;
	}
}
