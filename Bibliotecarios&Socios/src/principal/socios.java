package principal;

public class socios {
	private static final String NOMBRE_BIBLIOTECA = "Lectura Viva";
	private static final double CUOTA_BASE = 12.0;

	private String dni;
	private String nombreCompleto;
	private int mesAlta;
	private int añoAlta;
	private int librosPermitidos;

	public socios(String dni, String nombreCompleto, int mesAlta, int añoAlta, int librosPermitidos) {
		this.dni = dni;
		this.nombreCompleto = nombreCompleto;
		this.mesAlta = mesAlta;
		this.añoAlta = añoAlta;
		this.librosPermitidos = librosPermitidos;
	}

	public String getDni() {
		return dni;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public int getMesAlta() {
		return mesAlta;
	}

	public int getañoAlta() {
		return añoAlta;
	}

	public int getLibrosPermitidos() {
		return librosPermitidos;
	}

	public static String getNombreBiblioteca() {
		return NOMBRE_BIBLIOTECA;
	}

	public static double getCuotaBase() {
		return CUOTA_BASE;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public void setLibrosPermitidos(int librosPermitidos) {
		this.librosPermitidos = librosPermitidos;
	}

	public int calcularAntiguedad(int añoActual) {
		return Math.max(0, añoActual - añoAlta);
	}

	public double calcularCuotaFinal(int añoActual) {
		double cuota = CUOTA_BASE;
		if (librosPermitidos > 3) {
			cuota += (librosPermitidos - 3);
		}
		int antiguedad = calcularAntiguedad(añoActual);
		if (antiguedad >= 8) {
			cuota -= 2.0;
		}
		return cuota;
	}

	@Override
	public String toString() {
		return "Socio{" + "Biblioteca='" + NOMBRE_BIBLIOTECA + '\'' + ", DNI='" + dni + '\'' + ", Nombre='"
				+ nombreCompleto + '\'' + ", Alta=" + mesAlta + "/" + añoAlta + ", LibrosPermitidos=" + librosPermitidos
				+ '}';
	}
}
