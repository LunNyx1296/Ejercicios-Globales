package principal;

public class Character {
	protected String name;
	protected int health;

	public Character(String name, int health) {
		if (health < 0) {
			throw new IllegalArgumentException("La vida no puede ser negativa");
		}
		this.name = name;
		this.health = health;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}
}
