package principal;

import java.util.*;

public class OrdenarPorEnum {
    enum Prioridad { BAJA, MEDIA, ALTA }

    static class Tarea {
        String nombre;
        Prioridad prioridad;

        Tarea(String nombre, Prioridad prioridad) {
            this.nombre = nombre;
            this.prioridad = prioridad;
        }

        public String toString() {
            return nombre + " (" + prioridad + ")";
        }
    }

    public static void main(String[] args) {
        List<Tarea> tareas = Arrays.asList(
            new Tarea("Estudiar", Prioridad.MEDIA),
            new Tarea("Dormir", Prioridad.BAJA),
            new Tarea("Examen", Prioridad.ALTA)
        );

        System.out.println("Original: " + tareas);
        tareas.sort(Comparator.comparing(t -> t.prioridad));
        System.out.println("Ordenadas por prioridad: " + tareas);
    }
}

