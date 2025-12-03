package principal;

import java.time.LocalDate;
import java.util.HashMap;

public class Cliente extends Persona {
	private LocalDate fechaAlta;
	private HashMap<String, Entretenimiento> entrenamientos;
	private int contador;

	public Cliente(String dni, String nombre, LocalDate fechaAlta,HashMap<String, Entretenimiento> entrenamientos) {
		super(dni, nombre);
		this.entrenamientos = entrenamientos;
		this.fechaAlta = fechaAlta;
		contador = 100;
		
	}

	public LocalDate getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(LocalDate fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public HashMap<String, Entretenimiento> getEntrenamientos() {
		return entrenamientos;
	}

	public void setEntrenamientos(LocalDate ahora,String ejercicio, int repeticiones) {
		String codigo = "WOD-" + contador;
		Entretenimiento nuevo = new Entretenimiento(ahora,ejercicio, repeticiones);
		entrenamientos.put(codigo, nuevo);
		contador++;
	}
	
	@Override
	public String visualizar() {
		return super.visualizar()+" Fecha Alta: "+getFechaAlta();
	}
	
	public void visualizarEntrenamientos(){ 
		for (String key : entrenamientos.keySet()) {
			System.out.println(key+entrenamientos.get(key));
		}
	}

}
