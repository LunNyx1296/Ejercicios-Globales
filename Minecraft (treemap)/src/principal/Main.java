package principal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) {
		ArrayList<Block> inventory = new ArrayList<>();
		inventory.add(new StoneBlock());
		inventory.add(new StoneBlock());

		HashMap<String, Integer> blocks = new HashMap<>();
		blocks.put("Stone", 32);
		blocks.put("Dirt", 16);
		System.out.println("Bloques de Stone: " + blocks.get("Stone"));

		TreeMap<String, Integer> sortedblock = new TreeMap<>();
		sortedblock.put("Stone", 32);
		sortedblock.put("Dirt", 16);

		Collections.sort(inventory);

		for (Block b : inventory) {
			System.out.println("Inventory " + b.getName());
		}

		System.out.println("Total Block " + inventory.size());

		if (inventory.isEmpty()) {
			inventory.remove(0);
		}

		for (Block b : inventory) {
			b.setHardness(2.0f);
		}

		for (var entry : blocks.entrySet()) {
			System.out.println("Bloque " + entry.getKey() + " Cantidad: " + entry.getValue());
		}

		blocks.put("Stone", blocks.getOrDefault("Stone", 0) + 10);

		blocks.remove("Dirt");

		for (var entry : sortedblock.entrySet()) {
			System.out.println(entry.getKey() + "->" + entry.getValue());
		}

		inventory.removeIf(b -> b.getHardness() < 1.0f);

		Iterator<Block> it = inventory.iterator();
		while (it.hasNext()) {
			Block b = it.next();
			if (b.getHardness() < 1.0f) {
				it.remove();
			}
		}
		TreeMap<String, ArrayList<Block>> blocksByType = new TreeMap<>();
		blocksByType.put("Stone", new ArrayList<>(List.of(new StoneBlock(), new StoneBlock())));

		for (var entry : blocksByType.entrySet()) {
			String type = entry.getKey();
			ArrayList<Block> list = entry.getValue();
			for (Block b : list) {
				System.out.println("Tipo: " + type + " - " + b.getName());
			}
		}
	}
}
