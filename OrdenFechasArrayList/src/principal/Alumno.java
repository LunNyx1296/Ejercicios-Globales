package principal;

import java.time.LocalDate;

public class Alumno implements Comparable<Alumno> {
    private String nombre;
    private LocalDate fecharegistro;

    public Alumno(String nombre, LocalDate fecharegistro) {
        this.nombre = nombre;
        this.fecharegistro = fecharegistro;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getfecharegistro() {
        return fecharegistro;
    }

    @Override
    public String toString() {
        return "Alumno [nombre=" + nombre + ", fecharegistro=" + fecharegistro + "]";
    }

    @Override
    public int compareTo(Alumno otroAlumno) {
        return this.fecharegistro.compareTo(otroAlumno.fecharegistro);
    }
}

