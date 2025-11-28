package principal;

import java.time.Year;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class AplicacionBiblioteca {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		List<socios> socio = new ArrayList<>();
		int opcion;

		do {
			mostrarMenu();
			while (!teclado.hasNextInt()) {
				System.out.println("Introduce un número de opción válido.");
				teclado.nextLine();
			}
			opcion = teclado.nextInt();
			teclado.nextLine();
			switch (opcion) {
			case 0 -> introducirSocio(socio, teclado);
			case 1 -> visualizarSocios(socio);
			case 2 -> visualizarBibliotecarios(socio);
			case 3 -> visualizarBibliotecariosSeccion(socio, teclado);
			case 4 -> buscarPorNombre(socio, teclado);
			case 5 -> filtrarPorCuota(socio, teclado);
			case 6 -> bibliotecariosPorAntiguedad(socio, teclado);
			case 7 -> darDeBaja(socio, teclado);
			case 8 -> System.out.println("Saliendo...");
			default -> System.out.println("Opción no válida.");
			}
		} while (opcion != 8);

		teclado.close();
	}

	public static void mostrarMenu() {
		System.out.println("\nMENÚ:");
		System.out.println("0. Introducir socio/bibliotecario");
		System.out.println("1. Visualizar todos los socios (con cuota final)");
		System.out.println("2. Visualizar únicamente los bibliotecarios");
		System.out.println("3. Visualizar bibliotecarios de una sección concreta");
		System.out.println("4. Buscar por nombre o parte del nombre");
		System.out.println("5. Filtrar por cuota mensual (>= umbral)");
		System.out.println("6. Bibliotecarios con X años o más");
		System.out.println("7. Dar de baja socio/bibliotecario por DNI");
		System.out.println("8. Salir");
		System.out.print("Elige una opción: ");
	}

	public static void introducirSocio(List<socios> socio, Scanner teclado) {
		System.out.print("DNI: ");
		String dni = teclado.nextLine().trim();
		if (dni.isEmpty()) {
			System.out.println("ERROR: El DNI no puede estar vacío.");
			return;
		}
		if (existeDni(socio, dni)) {
			System.out.println("ERROR: Ya existe una persona con ese DNI.");
			return;
		}

		System.out.print("Nombre completo: ");
		String nombre = teclado.nextLine().trim();

		int mes = leerEntero(teclado, "Mes de alta (1-12): ", 1, 12);
		int año = leerEntero(teclado, "Año de alta (e.g., 2017): ", 1900, Year.now().getValue());
		int libros = leerEntero(teclado, "Libros permitidos (>=1): ", 1, Integer.MAX_VALUE);

		System.out.print("¿Es bibliotecario? (s/n): ");
		String resp = teclado.nextLine().trim();
		if (resp.equalsIgnoreCase("s")) {
			System.out.print("Sección: ");
			String seccion = teclado.nextLine().trim();
			socio.add(new Bibliotecario(dni, nombre, mes, año, libros, seccion));
		} else {
			socio.add(new socios(dni, nombre, mes, año, libros));
		}
		System.out.println("Alta realizada correctamente en '" + socios.getNombreBiblioteca() + "'.");
	}

	// ----- Caso 1 -----
	public static void visualizarSocios(List<socios> socio) {
		if (socio.isEmpty()) {
			System.out.println("No hay personas registradas.");
			return;
		}
		int añoActual = Year.now().getValue();
		System.out.println("Listado de socios (incluye bibliotecarios):");
		for (socios s : socio) {
			double cuota = s.calcularCuotaFinal(añoActual);
			boolean esBib = s instanceof Bibliotecario;
			String tipo = esBib ? "[BIBLIOTECARIO]" : "[SOCIO]";
			System.out.println(tipo + " " + s.toString());
			System.out.printf(Locale.US, "Cuota final: %.2f €%n", cuota);
			System.out.println("---");
		}
	}

	// ----- Caso 2 -----
	public static void visualizarBibliotecarios(List<socios> socio) {
		boolean hay = false;
		int añoActual = Year.now().getValue();
		for (socios s : socio) {
			if (s instanceof Bibliotecario) {
				Bibliotecario b = (Bibliotecario) s;
				hay = true;
				System.out.println(b.toString());
				System.out.printf(Locale.US, "Cuota final: %.2f €%n", b.calcularCuotaFinal(añoActual));
				System.out.println("---");
			}
		}
		if (!hay) {
			System.out.println("No hay bibliotecarios registrados.");
		}
	}

	// ----- Caso 3 -----
	public static void visualizarBibliotecariosSeccion(List<socios> socio, Scanner teclado) {
		System.out.print("Introduce la sección: ");
		String seccion = teclado.nextLine().trim();
		if (seccion.isEmpty()) {
			System.out.println("La sección no puede estar vacía.");
			return;
		}
		List<String> nombres = new ArrayList<>();
		for (socios s : socio) {
			if (s instanceof Bibliotecario) {
				Bibliotecario b = (Bibliotecario) s;
				if (b.getSeccion().equalsIgnoreCase(seccion)) {
					nombres.add(b.getNombreCompleto());
				}
			}
		}
		if (nombres.isEmpty()) {
			System.out.println("No hay bibliotecarios en esa sección.");
			return;
		}
		System.out.println("Bibliotecario/s de la sección " + seccion.toUpperCase(Locale.ROOT));
		for (String nombre : nombres) {
			System.out.println("- " + nombre);
		}
	}

	// ----- Caso 4 -----
	public static void buscarPorNombre(List<socios> socio, Scanner teclado) {
		System.out.print("Introduce nombre o parte del nombre: ");
		String filtro = teclado.nextLine().trim();
		if (filtro.isEmpty()) {
			System.out.println("El texto de búsqueda no puede estar vacío.");
			return;
		}
		int añoActual = Year.now().getValue();
		List<socios> encontrados = new ArrayList<>();
		for (socios s : socio) {
			if (s.getNombreCompleto().toLowerCase(Locale.ROOT).contains(filtro.toLowerCase(Locale.ROOT))) {
				encontrados.add(s);
			}
		}
		if (encontrados.isEmpty()) {
			System.out.println("ERROR: No se encontraron coincidencias.");
			return;
		}
		for (socios s : encontrados) {
			boolean esBib = s instanceof Bibliotecario;
			System.out.println("- DNI: " + s.getDni());
			System.out.println("  Años en la biblioteca: " + s.calcularAntiguedad(añoActual));
			System.out.println("  Es bibliotecario: " + (esBib ? "Sí" : "No"));
		}
	}

	// ----- Caso 5 -----
	public static void filtrarPorCuota(List<socios> socio, Scanner teclado) {
		System.out.print("Introduce una cuota mensual (umbral): ");
		Double umbral = leerDouble(teclado);
		if (umbral == null || umbral < 0) {
			System.out.println("Cuota no válida.");
			return;
		}
		int añoActual = Year.now().getValue();
		List<socios> filtrados = new ArrayList<>();
		for (socios s : socio) {
			double cuota = s.calcularCuotaFinal(añoActual);
			if (cuota >= umbral) {
				filtrados.add(s);
			}
		}
		if (filtrados.isEmpty()) {
			System.out.println("No se encontraron socios con cuota final igual o superior a " + umbral + " €.");
			return;
		}
		System.out.println("Socios con cuota >= " + String.format(Locale.US, "%.2f", umbral) + " €:");
		for (socios s : filtrados) {
			boolean esBib = s instanceof Bibliotecario;
			double cuota = s.calcularCuotaFinal(añoActual);
			String marcador = esBib ? "[BIBLIOTECARIO]" : "[SOCIO]";
			System.out.printf("%s %s -> Cuota final: %.2f €%n", marcador, s.getNombreCompleto(), cuota);
		}
	}

	// ----- Caso 6 -----
	public static void bibliotecariosPorAntiguedad(List<socios> socio, Scanner teclado) {
		int años = leerEntero(teclado, "Introduce un nº de años: ", 0, 200);
		int añoActual = Year.now().getValue();
		List<Bibliotecario> lista = new ArrayList<>();
		for (socios s : socio) {
			if (s instanceof Bibliotecario) {
				Bibliotecario b = (Bibliotecario) s;
				if (b.calcularAntiguedad(añoActual) >= años) {
					lista.add(b);
				}
			}
		}
		if (lista.isEmpty()) {
			System.out.println("No hay bibliotecarios con " + años + " años o más de antigüedad.");
			return;
		}
		System.out.println("Bibliotecarios con " + años + " años o más:");
		for (Bibliotecario b : lista) {
			System.out.println("- " + b.getNombreCompleto() + " (" + b.calcularAntiguedad(añoActual) + " años, sección "
					+ b.getSeccion() + ")");
		}
	}

	// ----- Caso 7 -----
	public static void darDeBaja(List<socios> socio, Scanner teclado) {
		System.out.print("Introduce el DNI para dar de baja: ");
		String dni = teclado.nextLine().trim();
		Iterator<socios> it = socio.iterator();
		boolean encontrado = false;
		while (it.hasNext()) {
			socios s = it.next();
			if (s.getDni().equalsIgnoreCase(dni)) {
				it.remove();
				encontrado = true;
				System.out.println("Baja realizada correctamente para DNI " + dni + ".");
				break;
			}
		}
		if (!encontrado) {
			System.out.println("ERROR: No existe una persona con ese DNI.");
		}
	}

	// ----- Utilidades -----
	private static boolean existeDni(List<socios> socio, String dni) {
		for (socios s : socio) {
			if (s.getDni().equalsIgnoreCase(dni))
				return true;
		}
		return false;
	}

	private static int leerEntero(Scanner teclado, String prompt, int min, int max) {
		while (true) {
			System.out.print(prompt);
			String linea = teclado.nextLine().trim();
			try {
				int valor = Integer.parseInt(linea);
				if (valor < min || valor > max) {
					System.out.println("Valor fuera de rango [" + min + " - " + max + "].");
					continue;
				}
				return valor;
			} catch (NumberFormatException e) {
				System.out.println("Introduce un número entero válido.");
			}
		}
	}

	private static Double leerDouble(Scanner teclado) {
		String linea = teclado.nextLine().trim();
		try {
			return Double.parseDouble(linea.replace(',', '.'));
		} catch (NumberFormatException e) {
			return null;
		}
	}
}
