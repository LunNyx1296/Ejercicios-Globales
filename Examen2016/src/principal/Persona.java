package principal;

import java.util.ArrayList;
import java.util.List;

class Persona {
	private String nombre;
	private String fechaNacimiento;

	public Persona(String nombre, String fechaNacimiento) {
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNombre() {
		return nombre;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public int getAñoNacimiento() {
		if (fechaNacimiento == null)
			return 0;
		String[] parts = fechaNacimiento.contains("/") ? fechaNacimiento.split("/") : fechaNacimiento.split("-");
		if (parts.length != 3)
			return 0;
		try {
			return Integer.parseInt(parts[2]);
		} catch (NumberFormatException e) {
			return 0;
		}
	}

	public int getEdadEstimada(int añoReferencia) {
		int año = getAñoNacimiento();
		if (año == 0)
			return 0;
		return Math.max(0, añoReferencia - año);
	}
}

class Medicion {
	private String fecha;
	private float pesoKg;

	public Medicion(String fecha, float pesoKg) {
		this.fecha = fecha;
		this.pesoKg = pesoKg;
	}

	public String getFecha() {
		return fecha;
	}

	public float getPesoKg() {
		return pesoKg;
	}

	@Override
	public String toString() {
		return fecha + " " + String.format("%.3f", pesoKg);
	}
}

class Cliente extends Persona {
	private String codigo;
	private float alturaM;
	private List<Medicion> mediciones;

	public Cliente(String nombre, String fechaNacimiento, float alturaM) {
		super(nombre, fechaNacimiento);
		this.alturaM = alturaM;
		this.codigo = generarCodigo(nombre, getAñoNacimiento());
		this.mediciones = new ArrayList<>();
	}

	private String generarCodigo(String nombre, int año) {
		String letras = nombre == null ? "" : nombre.replaceAll("\\s+", "");
		String pref = letras.length() >= 2 ? letras.substring(0, 2).toUpperCase()
				: (letras.toUpperCase() + "XX").substring(0, 2);
		String suf = String.format("%02d", año % 100);
		return pref + "-" + suf;
	}

	public String getCodigo() {
		return codigo;
	}

	public float getAlturaM() {
		return alturaM;
	}

	public List<Medicion> getMediciones() {
		return mediciones;
	}

	public void addMedicion(String fecha, float pesoKg) {
		mediciones.add(new Medicion(fecha, pesoKg));
	}

	public Float getUltimoPeso() {
		if (mediciones.isEmpty())
			return null;
		return mediciones.get(mediciones.size() - 1).getPesoKg();
	}

	public Float getPrimerPeso() {
		if (mediciones.isEmpty())
			return null;
		return mediciones.get(0).getPesoKg();
	}

	public Float calcularIMCConPeso(Float peso) {
		if (peso == null)
			return null;
		if (alturaM == 0f)
			return null;
		return peso / (alturaM * alturaM);
	}
}

class Empleado extends Persona {
	private String fechaAlta;

	public Empleado(String nombre, String fechaNacimiento, String fechaAlta) {
		super(nombre, fechaNacimiento);
		this.fechaAlta = fechaAlta;
	}

	public String getFechaAlta() {
		return fechaAlta;
	}
}
