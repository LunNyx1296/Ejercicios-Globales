package principal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		List<Alumno> listaAlumnos = new ArrayList<>();
		listaAlumnos.add(new Alumno ("Ana", LocalDate.of(2023, 10, 15)));
		listaAlumnos.add(new Alumno ("Luis", LocalDate.of(2023, 9, 20)));
		listaAlumnos.add(new Alumno ("Carlos", LocalDate.of(2023, 10, 5)));
		
		System.out.println("Antes de Ordenar: "+listaAlumnos);
		
		Collections.sort(listaAlumnos);
		
		System.out.println("Después de ordenar: " + listaAlumnos);
	}
}
