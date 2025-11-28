package principal;

import java.util.*;

public class OrdenacionMultiple {
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

        Comparator<Alumno> porNombre = Comparator.comparing(a -> a.nombre);
        Comparator<Alumno> porApellido1 = Comparator.comparing(a -> a.apellido1);
        Comparator<Alumno> porApellido2 = Comparator.comparing(a -> a.apellido2);

        System.out.println("Original: " + alumnos);

        alumnos.sort(porNombre);
        System.out.println("Ordenados por nombre: " + alumnos);

        alumnos.sort(porApellido1);
        System.out.println("Ordenados por primer apellido: " + alumnos);

        alumnos.sort(porApellido2);
        System.out.println("Ordenados por segundo apellido: " + alumnos);
    }
}

