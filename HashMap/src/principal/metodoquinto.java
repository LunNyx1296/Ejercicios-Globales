package principal;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class metodoquinto {
    public static void main(String[] args) {
        HashMap<String, Alumno> map = new HashMap<>();

        map.put("16071000X", new Alumno("16071000X", "Ana"));
        map.put("16071001Y", new Alumno("16071001Y", "Luis"));
        map.put("16071002Z", new Alumno("16071002Z", "Marta"));

        Iterator<Map.Entry<String, Alumno>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Alumno> entry = it.next();
            String key = entry.getKey();
            Alumno a = entry.getValue();
            System.out.println(key + " -> " + a.getNombre());
        }
    }
}

