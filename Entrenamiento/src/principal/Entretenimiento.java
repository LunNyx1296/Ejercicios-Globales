package principal;

import java.time.LocalDate;


public class Entretenimiento {
	private LocalDate ahora;
	private String ejercicio;
	private int repeticiones;

	public Entretenimiento(LocalDate ahora, String ejercicio, int repeticiones) {
		this.ahora = ahora;
		this.ejercicio = ejercicio;
		this.repeticiones = repeticiones;
	}

	@Override
	public String toString() {
		return "Ejercicio: " + ejercicio + ", Repeticiones: " + repeticiones;
	}
}
