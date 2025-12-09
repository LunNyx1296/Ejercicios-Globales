package principal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class LigaEsports {
	private ArrayList<String> competidores;
	private HashMap<String, Integer> partidasGanadas;

	public LigaEsports() {
		competidores = new ArrayList<>();
		partidasGanadas = new HashMap<>();
	}

	public void anadirCompetidor(String nombre) {
		competidores.add(nombre);
	}

	public void listarCompetidores() {
		System.out.println("Competidores inscritos:");
		for (String c : competidores) {
			System.out.println("- " + c);
		}
	}

	public void actualizarCompetidor(String antiguo, String nuevo) {
		int index = competidores.indexOf(antiguo);
		if (index != -1) {
			competidores.set(index, nuevo);
			System.out.println("Competidor actualizado: " + antiguo + " -> " + nuevo);
		} else {
			System.out.println("No se encontró al competidor: " + antiguo);
		}
	}

	public void eliminarCompetidor(String nombre) {
		if (competidores.remove(nombre)) {
			System.out.println("Competidor eliminado: " + nombre);
		} else {
			System.out.println("No se encontró al competidor: " + nombre);
		}
	}

	public void eliminarCompetidores(ArrayList<String> nombres) {
		for (String n : nombres) {
			competidores.remove(n);
		}
		System.out.println("Competidores eliminados: " + nombres);
	}

	public void registrarPartidas(String competidor, int cantidad) {
		partidasGanadas.put(competidor, partidasGanadas.getOrDefault(competidor, 0) + cantidad);
	}

	public void listarPartidas() {
		System.out.println("Partidas ganadas:");
		for (String c : partidasGanadas.keySet()) {
			System.out.println(c + " -> " + partidasGanadas.get(c));
		}
	}

	public void actualizarPartidas(String competidor, int nuevasPartidas) {
		if (partidasGanadas.containsKey(competidor)) {
			partidasGanadas.put(competidor, nuevasPartidas);
			System.out.println("Partidas actualizadas para " + competidor + ": " + nuevasPartidas);
		} else {
			System.out.println("No existe registro para " + competidor);
		}
	}

	public void eliminarRegistro(String competidor) {
		if (partidasGanadas.remove(competidor) != null) {
			System.out.println("Registro eliminado para " + competidor);
		} else {
			System.out.println("No existe registro para " + competidor);
		}
	}

	public boolean compararRegistros() {
		Iterator<String> itCompetidores = competidores.iterator();
		Iterator<String> itPartidas = partidasGanadas.keySet().iterator();

		while (itCompetidores.hasNext()) {
			String jugador = itCompetidores.next();
			boolean existe = false;

			itPartidas = partidasGanadas.keySet().iterator();
			while (itPartidas.hasNext()) {
				if (jugador.equals(itPartidas.next())) {
					existe = true;
					break;
				}
			}

			if (!existe) {
				return false;
			}
		}
		return true;
	}
}
