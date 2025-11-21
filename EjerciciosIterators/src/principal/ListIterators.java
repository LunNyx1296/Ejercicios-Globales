package principal;

import java.util.ArrayList;
import java.util.ListIterator;

public class ListIterators {

	public static void main(String[] args) {
		ArrayList<String> alumnos = new ArrayList<>();
		alumnos.add("Ana");
		alumnos.add("Luis");
		alumnos.add("Marta");
		alumnos.add("Juan");
		alumnos.add("Pedro");

		ListIterator<String> listIterator = alumnos.listIterator();

		while (listIterator.hasNext()) {
			String nombre = listIterator.next();
			if (nombre.startsWith("P")) {
				listIterator.set(nombre.toUpperCase());
			}
		}

		System.out.println("Lista después de modificaciones:");
		for (String nombre : alumnos) {
			System.out.println(nombre);
		}

		System.out.println("Lista en orden inverso:");
		while (listIterator.hasPrevious()) {
			System.out.println(listIterator.previous());
		}

		listIterator = alumnos.listIterator();
		while (listIterator.hasNext()) {
			String nombre = listIterator.next();
			if (nombre.equals("Marta")) {
				listIterator.remove();
				System.out.println("Se eliminó a Marta. Lista actualizada:");
				for (String alumno : alumnos) {
					System.out.println(alumno);
				}
				listIterator.add("Marcos"); 
				System.out.println("Se añadió Marcos después de eliminar a Marta. Lista actualizada:");
				for (String alumno : alumnos) {
					System.out.println(alumno);
				}
				break;
			}
		}

		listIterator = alumnos.listIterator();
		System.out.println("Avanzando hacia el medio de la lista:");
		int steps = alumnos.size() / 2;
		for (int i = 0; i < steps && listIterator.hasNext(); i++) {
			System.out.println("Avanzando: " + listIterator.next());
		}

		System.out.println("Retrocediendo desde el medio:");
		while (listIterator.hasPrevious()) {
			System.out.println("Retrocediendo: " + listIterator.previous());
		}
	}
}