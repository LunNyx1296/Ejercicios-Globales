package escuela;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {

	private static List<Ciclo> ciclos = new ArrayList<>();
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int opcion;
		do {
			mostrarMenu();
			opcion = Integer.parseInt(sc.nextLine());
			switch (opcion) {
			case 1 -> matricularAlumno();
			case 2 -> listarAlumnos();
			case 3 -> mostrarInfoAlumno();
			case 4 -> modificarAlumno();
			case 5 -> modificarRepetidoresDAW();
			case 6 -> darDeBajaAlumno();
			case 7 -> System.out.println("Saliendo...");
			default -> System.out.println("Opción no válida");
			}
		} while (opcion != 7);
	}

	private static void mostrarMenu() {
		System.out.println("\n--- MENÚ ---");
		System.out.println("1. Matricular alumno/a");
		System.out.println("2. Listado de alumnos");
		System.out.println("3. Información de un alumno por NIF");
		System.out.println("4. Modificar datos de un alumno");
		System.out.println("5. Modificar repetidor en DAW por edad");
		System.out.println("6. Dar de baja a un alumno");
		System.out.println("7. Salir");
		System.out.print("Elige opción: ");
	}

	// A. Matricular alumno
	private static void matricularAlumno() {
		System.out.print("Introduce NIF: ");
		String nif = sc.nextLine();

		int vecesMatriculado = 0;
		for (Ciclo c : ciclos) {
			if (c.getNif().equalsIgnoreCase(nif)) {
				vecesMatriculado++;
			}
		}

		if (vecesMatriculado == 2) {
			System.out.println("Alumno/a ya introducido en ambos ciclos.");
			return;
		}

		System.out.print("Nombre: ");
		String nombre = sc.nextLine();
		System.out.print("Fecha nacimiento (AAAA-MM-DD): ");
		LocalDate fecha = LocalDate.parse(sc.nextLine());
		System.out.print("Ciclo (DAM/DAW): ");
		Ciclo.CicloEnum cicloEnum = Ciclo.CicloEnum.valueOf(sc.nextLine().toUpperCase());
		System.out.print("¿Es repetidor? (true/false): ");
		boolean repetidor = Boolean.parseBoolean(sc.nextLine());

		// comprobar si ya está en ese ciclo
		for (Ciclo c : ciclos) {
			if (c.getNif().equalsIgnoreCase(nif) && c.getCiclo() == cicloEnum) {
				System.out.println("Ya está matriculado en este ciclo. Solo puede matricularse en el otro.");
				return;
			}
		}

		ciclos.add(new Ciclo(nif, nombre, fecha, cicloEnum, repetidor));
		System.out.println("Alumno matriculado correctamente.");
	}

	// B. Listado de alumnos
	private static void listarAlumnos() {
		if (ciclos.isEmpty()) {
			System.out.println("No hay alumnos introducidos.");
			return;
		}
		for (Ciclo c : ciclos) {
			System.out.println(c.getNombre() + " - " + c.getNif() + " - " + c.getCiclo());
		}
	}

	// C. Info de un alumno por NIF
	private static void mostrarInfoAlumno() {
		if (ciclos.isEmpty()) {
			System.out.println("No hay alumnos introducidos.");
			return;
		}
		System.out.print("Introduce NIF: ");
		String nif = sc.nextLine();
		boolean encontrado = false;
		for (Ciclo c : ciclos) {
			if (c.getNif().equalsIgnoreCase(nif)) {
				System.out.println(c);
				encontrado = true;
			}
		}
		if (!encontrado) {
			System.out.println("Alumno no encontrado.");
		}
	}

	// D Modificar los datos de un alumno.
	private static void modificarAlumno() {
		if (ciclos.isEmpty()) {
			System.out.println("No hay alumnos introducidos.");
			return;
		}
		System.out.print("Introduce NIF: ");
		String nif = sc.nextLine();
		boolean encontrado = false;
		for (Ciclo c : ciclos) {
			if (c.getNif().equalsIgnoreCase(nif)) {
				System.out.print("Nuevo nombre: ");
				c.setNombre(sc.nextLine());
				System.out.print("Nueva fecha nacimiento (AAAA-MM-DD): ");
				c.setFechaNacimiento(LocalDate.parse(sc.nextLine()));
				System.out.print("¿Es repetidor? (true/false): ");
				c.setRepetidor(Boolean.parseBoolean(sc.nextLine()));
				System.out.println("Datos modificados correctamente.");
				encontrado = true;
				break;
			}
		}
		if (!encontrado) {
			System.out.println("Alumno no encontrado.");
		}
	}

	// E. Modificar repetidor de DAW por edad
	private static void modificarRepetidoresDAW() {
		if (ciclos.isEmpty()) {
			System.out.println("No hay alumnos introducidos.");
			return;
		}
		System.out.print("Introduce edad: ");
		int edad = Integer.parseInt(sc.nextLine());
		int anioActual = LocalDate.now().getYear();

		boolean encontrado = false;
		for (Ciclo c : ciclos) {
			int edadAlumno = anioActual - c.getFechaNacimiento().getYear();
			if (c.getCiclo() == Ciclo.CicloEnum.DAW && edadAlumno == edad) {
				c.setRepetidor(true);
				encontrado = true;
			}
		}
		if (!encontrado) {
			System.out.println("No existen alumnos DAW con esa edad.");
		} else {
			System.out.println("Campo repetidor actualizado.");
		}
	}



// F. Dar de baja alumno
	private static void darDeBajaAlumno() {
		if (ciclos.isEmpty()) {
			System.out.println("No hay alumnos introducidos.");
			return;
		}
		System.out.print("Introduce NIF: ");
		String nif = sc.nextLine();
		boolean encontrado = false;
		for (int i = 0; i < ciclos.size(); i++) {
			Ciclo c = ciclos.get(i);
			if (c.getNif().equalsIgnoreCase(nif)) {
				System.out.println("Información del alumno: " + c);
				encontrado = true;
			}
		}
		if (!encontrado) {
			System.out.println("Alumno no encontrado.");
			return;
		}
		System.out.print("¿Confirmar baja? (s/n): ");
		String respuesta = sc.nextLine();
		if (respuesta.equalsIgnoreCase("s")) {
			// eliminar todos los ciclos con ese NIF
			for (int i = ciclos.size() - 1; i >= 0; i--) {
				if (ciclos.get(i).getNif().equalsIgnoreCase(nif)) {
					ciclos.remove(i);
				}
			}
			System.out.println("Alumno dado de baja.");
		} else {
			System.out.println("Operación cancelada.");
		}
	}
}