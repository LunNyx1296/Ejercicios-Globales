package principal;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
	private static final List<Object> personas = new ArrayList<>();

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int opcion;
		do {
			System.out.println("\n--- MENÚ ---");
			System.out.println("1. Alta de cliente/empleado");
			System.out.println("2. Listado de clientes");
			System.out.println("3. Añadir medición a un cliente y ver su evolución");
			System.out.println("4. Estadística de gordis");
			System.out.println("99. Salir");
			System.out.print("Opción: ");
			while (!teclado.hasNextInt()) {
				teclado.nextLine();
				System.out.print("Opción: ");
			}
			opcion = teclado.nextInt();
			teclado.nextLine();

			switch (opcion) {
			case 1 -> alta(teclado);
			case 2 -> listadoClientes();
			case 3 -> evolucionCliente(teclado);
			case 4 -> estadisticaGordis();
			case 99 -> System.out.println("Saliendo...");
			default -> System.out.println("Opción inválida.");
			}
		} while (opcion != 99);
		teclado.close();
	}

	private static void alta(Scanner teclado) {
		System.out.print("¿Qué desea introducir? (gordi/empleado): ");
		String tipo = teclado.nextLine().trim().toLowerCase();
		System.out.print("Nombre: ");
		String nombre = teclado.nextLine();
		System.out.print("Fecha nacimiento (dd/mm/aaaa o dd-mm-aaaa): ");
		String fnac = teclado.nextLine();

		if (tipo.equals("gordi")) {
			System.out.print("Altura en metros (ej. 1.72): ");
			float altura = leerFloat(teclado);
			Cliente c = new Cliente(nombre, fnac, altura);
			System.out.println("Código asignado: " + c.getCodigo());
			int minimo = 1;
			System.out.print("¿Cuántas mediciones va a introducir? (mínimo " + minimo + "): ");
			int n = leerEnteroMinimo(teclado, minimo);
			for (int i = 1; i <= n; i++) {
				System.out.println("Medición " + i + ":");
				System.out.print("Fecha (dd/mm/aaaa): ");
				String fecha = teclado.nextLine();
				System.out.print("Peso (kg): ");
				float peso = leerFloat(teclado);
				c.addMedicion(fecha, peso);
			}
			personas.add(c);
			System.out.println("Cliente añadido.");

		} else if (tipo.equals("empleado")) {
			System.out.print("Fecha alta (dd/mm/aaaa): ");
			String falta = teclado.nextLine();
			Empleado e = new Empleado(nombre, fnac, falta);
			personas.add(e);
			System.out.println("Empleado añadido.");
		} else {
			System.out.println("Tipo no reconocido. Use 'gordi' o 'empleado'.");
		}
	}

	private static void listadoClientes() {
		List<Cliente> clientes = extraerClientes();
		if (clientes.isEmpty()) {
			System.out.println("No hay clientes registrados.");
			return;
		}
		int añoRef = 2017;
		for (Cliente c : clientes) {
			int edad = c.getEdadEstimada(añoRef);
			Float ultimoPeso = c.getUltimoPeso();
			Float imc = c.calcularIMCConPeso(ultimoPeso);
			System.out.println("Nombre: " + c.getNombre());
			System.out.println("Edad: " + edad);
			System.out.println("Código: " + c.getCodigo());
			if (imc == null) {
				System.out.println("IMC: No calculable (altura 0 o sin mediciones).");
			} else {
				System.out.println("IMC (último peso): " + String.format("%.2f", imc));
			}
			System.out.println("---");
		}
	}

	private static void evolucionCliente(Scanner teclado) {
		System.out.print("Introduce nombre de gordi: ");
		String nombre = teclado.nextLine();
		Cliente c = buscarClientePorNombre(nombre);
		if (c == null) {
			System.out.println("El cliente buscado no ha sido encontrado");
			System.out.print("¿Desea dar de baja algún cliente? (S/N): ");
			if (teclado.nextLine().trim().equalsIgnoreCase("S")) {
				System.out.print("Nombre a eliminar: ");
				String del = teclado.nextLine();
				eliminarClientePorNombre(del);
			}
			return;
		}

		System.out.println("Año nac. Altura " + c.getAñoNacimiento() + " " + c.getAlturaM());
		System.out.println("Mediciones:");
		for (Medicion m : c.getMediciones()) {
			System.out.println(m.toString());
		}

		System.out.print("Fecha nueva medición en formato: dd/mm/aaaa: ");
		String fechaNueva = teclado.nextLine();
		System.out.print("Nuevo peso: ");
		float pesoNuevo = leerFloat(teclado);
		Float pesoUltimoAntes = c.getUltimoPeso();
		Float pesoPrimero = c.getPrimerPeso();
		c.addMedicion(fechaNueva, pesoNuevo);

		Float imcActual = c.calcularIMCConPeso(c.getUltimoPeso());
		if (imcActual != null) {
			System.out.println("IMC ACTUAL= " + String.format("%.2f", imcActual));
		} else {
			System.out.println("IMC ACTUAL= no calculable");
		}

		if (pesoUltimoAntes != null) {
			float diffUltima = pesoNuevo - pesoUltimoAntes;
			System.out.println("Diferencia peso última medición: " + formatoSigno(diffUltima) + " Kg.");
		} else {
			System.out.println("No había medición previa para comparar.");
		}

		if (pesoPrimero != null) {
			float diffInicio = pesoNuevo - pesoPrimero;
			System.out
					.println("Diferencia de peso desde el inicio del tratamiento: " + formatoSigno(diffInicio) + " Kg");
		}

		if (pesoUltimoAntes != null) {
			float cambio = pesoUltimoAntes - pesoNuevo;
			if (cambio > 0.200f) {
				System.out.println("LA DIETA ASIGNADA ES CORRECTA!!");
			} else {
				System.out.println("REVISIÓN DE LA DIETA!!");
			}
		}
	}

	private static void estadisticaGordis() {
		List<Cliente> clientes = extraerClientes();
		if (clientes.isEmpty()) {
			System.out.println("No hay clientes registrados.");
			return;
		}

		java.util.Map<String, Integer> conteos = new java.util.HashMap<>();

		for (Cliente c : clientes) {
			Float primerPeso = c.getPrimerPeso();
			Float imc = c.calcularIMCConPeso(primerPeso);
			if (imc == null)
				continue;
			String clase = ClasificadorIMC.clasificacion(imc);
			conteos.put(clase, conteos.getOrDefault(clase, 0) + 1);
		}

		if (conteos.isEmpty()) {
			System.out.println("No hay IMC calculables (sin mediciones o altura 0).");
			return;
		}

		List<java.util.Map.Entry<String, Integer>> listado = new ArrayList<>(conteos.entrySet());
		listado.sort(Comparator.<java.util.Map.Entry<String, Integer>>comparingInt(e -> e.getValue()).reversed());

		System.out.println("Clasificación | Nº de clientes");
		for (var e : listado) {
			System.out.println(e.getKey() + " | " + e.getValue());
		}
	}

	private static List<Cliente> extraerClientes() {
		List<Cliente> lista = new ArrayList<>();
		for (Object o : personas) {
			if (o instanceof Cliente c)
				lista.add(c);
		}
		return lista;
	}

	private static Cliente buscarClientePorNombre(String nombre) {
		for (Object o : personas) {
			if (o instanceof Cliente c) {
				if (c.getNombre().equalsIgnoreCase(nombre))
					return c;
			}
		}
		return null;
	}

	private static void eliminarClientePorNombre(String nombre) {
		for (int i = 0; i < personas.size(); i++) {
			Object o = personas.get(i);
			if (o instanceof Cliente c && c.getNombre().equalsIgnoreCase(nombre)) {
				personas.remove(i);
				System.out.println("Cliente eliminado: " + nombre);
				return;
			}
		}
		System.out.println("Cliente no encontrado: " + nombre);
	}

	private static float leerFloat(Scanner teclado) {
		while (true) {
			String s = teclado.nextLine().trim().replace(',', '.');
			try {
				return Float.parseFloat(s);
			} catch (NumberFormatException e) {
				System.out.print("Valor no válido, introduzca de nuevo: ");
			}
		}
	}

	private static int leerEnteroMinimo(Scanner teclado, int minimo) {
		while (true) {
			String s = teclado.nextLine().trim();
			try {
				int n = Integer.parseInt(s);
				if (n >= minimo)
					return n;
			} catch (NumberFormatException ignored) {
			}
			System.out.print("Número no válido, mínimo " + minimo + ": ");
		}
	}

	private static String formatoSigno(float valor) {
		String s = String.format("%.3f", Math.abs(valor));
		return (valor >= 0 ? "+" : "-") + s;
	}
}
