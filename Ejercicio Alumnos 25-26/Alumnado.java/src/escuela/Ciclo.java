package escuela;

import java.time.LocalDate;

public class Ciclo {
	private String nif;
	private String nombre;
	private LocalDate fechaNacimiento;
	private CicloEnum ciclo;
	private boolean repetidor;

	public Ciclo(String nif, String nombre, LocalDate fechaNacimiento, CicloEnum ciclo, boolean repetidor) {
		this.nif = nif;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.ciclo = ciclo;
		this.repetidor = repetidor;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public CicloEnum getCiclo() {
		return ciclo;
	}

	public void setCiclo(CicloEnum ciclo) {
		this.ciclo = ciclo;
	}

	public boolean isRepetidor() {
		return repetidor;
	}

	public void setRepetidor(boolean repetidor) {
		this.repetidor = repetidor;
	}

	@Override
	public String toString() {
		return "Alumno{" + "nif='" + nif + '\'' + ", nombre='" + nombre + '\'' + ", fechaNacimiento=" + fechaNacimiento
				+ ", ciclo=" + ciclo + ", repetidor=" + repetidor + '}';
	}

	public enum CicloEnum {
		DAM, DAW
	}
}
