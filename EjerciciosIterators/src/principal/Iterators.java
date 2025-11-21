package principal;

import java.util.ArrayList;
import java.util.Iterator;

public class Iterators {

	public static void main(String[] args) {
		ArrayList<String> alumnos = new ArrayList<>();
		alumnos.add("Ana");
		alumnos.add("Luis");
		alumnos.add("Marta");
		alumnos.add("Juan");
		alumnos.add("Pedro");

		Iterator<String> iterator = alumnos.iterator();

		System.out.println("Lista de alumnos:");
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}

		iterator = alumnos.iterator();
		while (iterator.hasNext()) {
			if (iterator.next().length() < 4) {
				iterator.remove();
			}
		}

		System.out.println("Lista después de eliminar nombres con menos de 4 letras:");
		for (String nombre : alumnos) {
			System.out.println(nombre);
		}
	}
}