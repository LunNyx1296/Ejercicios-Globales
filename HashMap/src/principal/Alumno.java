package principal;

public class Alumno {
    private String dni;
    private String nombre;

    public Alumno(String dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void getDatos() {
        System.out.println("DNI: " + dni + ", Nombre: " + nombre);
    }
}

