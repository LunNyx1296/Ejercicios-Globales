package principal;

public class Player extends Character implements Attackable {

	private Role role;

	public Player(String name, int health, Role role) {
		super(name, health);
		this.role = role;
	}

	@Override
	public int attack() {
		return 10;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}
