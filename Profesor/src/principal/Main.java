package principal;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		Universidad uni = new Universidad();
		int opcion;

		do {
			System.out.println("\n--- MENÚ ---");
			System.out.println("1. Introducir nuevo profesor");
			System.out.println("2. Añadir publicación");
			System.out.println("3. Mostrar libros galardonados de un año");
			System.out.println("4. Listado por departamento");
			System.out.println("5. Listar profesores");
			System.out.println("6. Salir");
			System.out.print("Opción: ");
			opcion = teclado.nextInt();
			teclado.nextLine();

			switch (opcion) {
			case 1:
				System.out.print("Email: ");
				String email = teclado.nextLine();
				System.out.print("Nombre: ");
				String nombre = teclado.nextLine();
				System.out.print("Departamento: ");
				String dept = teclado.nextLine();
				uni.addProfesor(email, nombre, dept);
				break;

			case 2:
				System.out.print("Email del profesor: ");
				String em = teclado.nextLine();
				System.out.println("¿Libro o Artículo? (L/A): ");
				String tipo = teclado.nextLine();
				System.out.print("Fecha: ");
				String fecha = teclado.nextLine();
				System.out.print("Título: ");
				String titulo = teclado.nextLine();

				if (tipo.equalsIgnoreCase("L")) {
					System.out.print("ISBN: ");
					String isbn = teclado.nextLine();
					System.out.print("Premiado (S/N): ");
					boolean premiado = teclado.nextLine().equalsIgnoreCase("S");
					uni.addPublicacion(em, new Libro(fecha, titulo, isbn, premiado));
				} else {
					System.out.print("Medio: ");
					String medio = teclado.nextLine();
					uni.addPublicacion(em, new Articulo(fecha, titulo, medio));
				}
				break;

			case 3:
				System.out.print("Introduce año: ");
				int anio = teclado.nextInt();
				uni.mostrarLibrosPremiados(anio);
				break;

			case 4:
				uni.listadoPorDepartamento();
				break;

			case 5:
				uni.listarProfesores();
				break;

			case 6:
				System.out.println("Saliendo...");
				break;

			default:
				System.out.println("Opción inválida.");
			}
		} while (opcion != 6);

		teclado.close();
	}
}
