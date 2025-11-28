package principal;

public class Bibliotecario extends socios {
	private static final double PLUS_BIBLIOTECARIO = 30.0;
	private String seccion;

	public Bibliotecario(String dni, String nombreCompleto, int mesAlta, int añoAlta, int librosPermitidos,
			String seccion) {
		super(dni, nombreCompleto, mesAlta, añoAlta, librosPermitidos);
		this.seccion = seccion;
	}

	public String getSeccion() {
		return seccion;
	}

	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}

	public static double getPlusBibliotecario() {
		return PLUS_BIBLIOTECARIO;
	}

	@Override
	public double calcularCuotaFinal(int añoActual) {
		return super.calcularCuotaFinal(añoActual) + PLUS_BIBLIOTECARIO;
	}

	@Override
	public String toString() {
		return "Bibliotecario{" + "DNI='" + getDni() + '\'' + ", Nombre='" + getNombreCompleto() + '\'' + ", Seccion='"
				+ seccion + '\'' + ", Alta=" + getMesAlta() + "/" + getañoAlta() + ", LibrosPermitidos="
				+ getLibrosPermitidos() + '}';
	}
}
