package principal;

import java.util.ArrayList;

public class ListaArticulo {

	private ArrayList<Articulo> lista = new ArrayList<>();

	public void add(Articulo a) {
		lista.add(a);
	}

	public Articulo buscar(String codigo) {
		for (Articulo a : lista)
			if (a.getCodigo().equalsIgnoreCase(codigo))
				return a;
		return null;
	}

	public ArrayList<Articulo> reponer() {
		ArrayList<Articulo> bajos = new ArrayList<>();
		for (Articulo a : lista)
			if (a.getStock() < 50)
				bajos.add(a);
		return bajos;
	}

	public ArrayList<Articulo> masCaro() {
		ArrayList<Articulo> res = new ArrayList<>();
		double max = 0;

		for (Articulo a : lista)
			if (a.getPrecio() > max)
				max = a.getPrecio();

		for (Articulo a : lista)
			if (a.getPrecio() == max)
				res.add(a);

		return res;
	}

	public ArrayList<Articulo> equivalentes(String codigo) {
		Articulo base = buscar(codigo);
		ArrayList<Articulo> res = new ArrayList<>();

		if (base == null)
			return res;

		for (Articulo a : lista)
			if (a.getPrecio() == base.getPrecio())
				res.add(a);

		return res;
	}

	public void listar() {
		for (Articulo a : lista) {
			a.printCaracteristicas();
			System.out.println();
		}
	}

	public void listarSanos() {
		for (Articulo a : lista)
			if (a.sano()) {
				a.printCaracteristicas();
				System.out.println();
			}
	}
}
