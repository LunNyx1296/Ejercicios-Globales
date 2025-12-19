package principal;

import java.util.*;

public class Main {
	public static void main(String[] args) {

		Player p1 = new Player("Steve", 20, Role.WARRIOR);

		Character c = new Player("Alex", 15, Role.ARCHER);
		if (c instanceof Player) {
			System.out.println("Es un Player");
		}

		Player casted = (Player) c;

		if (c instanceof Player) {
			Player pl = (Player) c;
			System.out.println("Ataque: " + pl.attack());
		}

		String name = "Steve_the_Builder";
		String sub1 = name.substring(0, 5);

		String sub2 = name.substring(0, name.indexOf("_"));

		if (p1.getRole() == Role.WARRIOR) {
			System.out.println("El jugador es guerrero");
		}

		try {
			int num = Integer.parseInt("abc");
		} catch (NumberFormatException e) {
			System.out.println("Error al convertir: " + e.getMessage());
		}

		try {
			String s = null;
			int num = Integer.parseInt(s);
		} catch (NumberFormatException | NullPointerException e) {
			System.out.println("Error: " + e.getClass().getSimpleName());
		}

		try {
			int num = Integer.parseInt("123");
		} catch (Exception e) {
			System.out.println("Error");
		} finally {
			System.out.println("Bloque finally siempre se ejecuta");
		}

		ArrayList<Character> characters = new ArrayList<>();
		characters.add(new Player("Steve", 20, Role.WARRIOR));
		characters.add(new Character("Zombie", 10));

		for (Character ch : characters) {
			if (ch instanceof Player) {
				Player pl = (Player) ch;
				System.out.println("Jugador: " + pl.getName() + " - Rol: " + pl.getRole());
			} else {
				System.out.println("Mob enemigo");
			}
		}
	}
}
