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
			} else if (nombre.startsWith("M")) {
				listIterator.add("Marcos");
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
	}
}