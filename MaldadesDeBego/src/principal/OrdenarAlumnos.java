package principal;

import java.util.*;

public class OrdenarAlumnos {
    static class Alumno {
        String nombre;
        String apellido1;
        String apellido2;

        Alumno(String nombre, String apellido1, String apellido2) {
            this.nombre = nombre;
            this.apellido1 = apellido1;
            this.apellido2 = apellido2;
        }

        public String toString() {
            return nombre + " " + apellido1 + " " + apellido2;
        }
    }

    public static void main(String[] args) {
        List<Alumno> alumnos = Arrays.asList(
            new Alumno("Ana", "García", "López"),
            new Alumno("Luis", "García", "Martínez"),
            new Alumno("Marta", "Zabala", "Iglesias")
        );

        System.out.println("Original: " + alumnos);
        alumnos.sort(Comparator.comparing((Alumno a) -> a.apellido1)
                               .thenComparing(a -> a.apellido2));
        System.out.println("Ordenados por apellidos: " + alumnos);
    }
}
