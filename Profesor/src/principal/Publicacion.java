package principal;

import java.util.*;
import java.util.regex.*;

abstract class Publicacion {
	protected String fecha;
	protected String titulo;

	public Publicacion(String fecha, String titulo) {
		this.fecha = fecha;
		this.titulo = titulo;
	}

	public String getFecha() {
		return fecha;
	}

	public String getTitulo() {
		return titulo;
	}
}

class Libro extends Publicacion {
	private String isbn;
	private boolean premiado;

	public Libro(String fecha, String titulo, String isbn, boolean premiado) {
		super(fecha, titulo);
		this.isbn = isbn;
		this.premiado = premiado;
	}

	public String getIsbn() {
		return isbn;
	}

	public boolean isPremiado() {
		return premiado;
	}

	@Override
	public String toString() {
		return fecha + " | " + titulo + " | ISBN: " + isbn + " | Premiado: " + (premiado ? "Sí" : "No");
	}
}

class Articulo extends Publicacion {
	private String medio;

	public Articulo(String fecha, String titulo, String medio) {
		super(fecha, titulo);
		this.medio = medio;
	}

	public String getMedio() {
		return medio;
	}

	@Override
	public String toString() {
		return fecha + " | " + titulo + " | Medio: " + medio;
	}
}

class Profesor {
	private String email;
	private String nombre;
	private String departamento;
	private ArrayList<Publicacion> publicaciones;

	public Profesor(String email, String nombre, String departamento) {
		this.email = email;
		this.nombre = nombre;
		this.departamento = departamento;
		this.publicaciones = new ArrayList<>();
	}

	public String getEmail() {
		return email;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDepartamento() {
		return departamento;
	}

	public ArrayList<Publicacion> getPublicaciones() {
		return publicaciones;
	}

	public void addPublicacion(Publicacion p) {
		publicaciones.add(p);
	}

	@Override
	public String toString() {
		return nombre + " (" + email + ") - " + departamento;
	}
}

class Universidad {
	private HashMap<String, Profesor> profesores;

	public Universidad() {
		profesores = new HashMap<>();
	}

	public static boolean validarEmail(String email) {
		if (email == null)
			return false;
		String regex = "^[a-zA-Z0-9._]+@[a-zA-Z]+\\.[a-zA-Z]+$";
		return email.matches(regex);
	}

	public boolean addProfesor(String email, String nombre, String departamento) {
		if (!validarEmail(email)) {
			System.out.println("Email inválido.");
			return false;
		}
		if (profesores.containsKey(email)) {
			System.out.println("Ya existe un profesor con ese email.");
			return false;
		}
		profesores.put(email, new Profesor(email, nombre, departamento));
		System.out.println("Profesor añadido correctamente.");
		return true;
	}

	public void addPublicacion(String email, Publicacion pub) {
		Profesor p = profesores.get(email);
		if (p == null) {
			System.out.println("No existe profesor con ese email.");
			return;
		}
		p.addPublicacion(pub);
		System.out.println("Publicación añadida a " + p.getNombre());
	}

	public void mostrarLibrosPremiados(int año) {
		boolean encontrado = false;
		for (Profesor p : profesores.values()) {
			for (Publicacion pub : p.getPublicaciones()) {
				if (pub instanceof Libro) {
					Libro l = (Libro) pub;
					if (l.isPremiado() && l.getFecha().contains(String.valueOf(año))) {
						System.out.println(l.getFecha() + " | " + l.getTitulo() + " | " + l.getIsbn() + " | Profesor: "
								+ p.getNombre() + " | Departamento: " + p.getDepartamento());
						encontrado = true;
					}
				}
			}
		}
		if (!encontrado) {
			System.out.println("No se han encontrado libros premiados en " + año);
		}
	}

	public void listadoPorDepartamento() {
		HashMap<String, ArrayList<Profesor>> porDept = new HashMap<>();

		for (Profesor p : profesores.values()) {
			if (!p.getPublicaciones().isEmpty()) {
				porDept.putIfAbsent(p.getDepartamento(), new ArrayList<>());
				porDept.get(p.getDepartamento()).add(p);
			}
		}

		if (porDept.isEmpty()) {
			System.out.println("Aún no hay publicaciones de ningún profesor.");
			return;
		}

		for (String dept : porDept.keySet()) {
			System.out.println("Departamento: " + dept);
			ArrayList<Profesor> lista = porDept.get(dept);

			lista.sort((a, b) -> {
				int cmp = Integer.compare(b.getPublicaciones().size(), a.getPublicaciones().size());
				if (cmp == 0)
					return a.getNombre().compareTo(b.getNombre());
				return cmp;
			});

			for (Profesor p : lista) {
				System.out.println(p.getNombre() + " -> " + p.getPublicaciones().size() + " publicaciones");
			}
		}
	}

	public void listarProfesores() {
		for (Profesor p : profesores.values()) {
			System.out.println(p);
		}
	}
}
