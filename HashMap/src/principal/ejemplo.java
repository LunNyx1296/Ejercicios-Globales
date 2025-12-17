package principal;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ejemplo {
    public static void main(String[] args) {
        HashMap<String, Alumno> map = new HashMap<>();

        map = new HashMap<String, Alumno>() {{
            put("16071000X", new Alumno("16071000X", "Pedro"));
            put("16071001Y", new Alumno("16071001Y", "Sanchez"));
            put("16071002Z", new Alumno("16071002Z", "Maria"));
        }};

        System.out.println("Tamaño: " + map.size());
        System.out.println("Está vacío¿? " + map.isEmpty());

        String dni = "16071001Y";
        Alumno buscado = map.get(dni);
        System.out.println("Buscado: " + buscado.getNombre());

        System.out.println("\nRecorrido con valores:");
        for (Alumno a : map.values()) {
            a.getDatos();
        }

        System.out.println("\nRecorrido con clave y valor:");
        for (Map.Entry<String, Alumno> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue().getNombre());
        }

        System.out.println("\nRecorrido con Iterator de valores:");
        Iterator<Alumno> iter = map.values().iterator();
        while (iter.hasNext()) {
            Alumno a = iter.next();
            a.getDatos();
        }
    }
}


