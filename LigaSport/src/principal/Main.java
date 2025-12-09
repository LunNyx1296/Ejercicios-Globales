package principal;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		LigaEsports liga = new LigaEsports();

		liga.anadirCompetidor("Alice");
		liga.anadirCompetidor("Bob");
		liga.anadirCompetidor("Charlie");

		liga.listarCompetidores();

		liga.actualizarCompetidor("Charlie", "Carlos");

		liga.eliminarCompetidor("Bob");

		ArrayList<String> eliminarLista = new ArrayList<>();
		eliminarLista.add("Alice");
		eliminarLista.add("Carlos");
		liga.eliminarCompetidores(eliminarLista);

		liga.listarCompetidores();

		liga.registrarPartidas("Alice", 3);
		liga.registrarPartidas("Bob", 5);
		liga.registrarPartidas("Carlos", 2);

		liga.listarPartidas();

		liga.actualizarPartidas("Bob", 10);

		liga.eliminarRegistro("Carlos");

		liga.listarPartidas();

		boolean resultado = liga.compararRegistros();
		System.out.println("¿Todos los competidores tienen registro en el HashMap? " + resultado);

		liga.anadirCompetidor("David");
		resultado = liga.compararRegistros();
		System.out.println("Ejemplo con fallo: " + resultado);
	}
}
