package principal;

public abstract class Block implements Comparable<Block> {

	protected String name;
	protected float hardness;

	public Block(String name, float hardness) {
		this.name = name;
		this.hardness = hardness;
	}

	public abstract boolean MeVoyARomperLaMano();

	public String getName() {
		return name;
	}

	public float getHardness() {
		return hardness;
	}

	public void setHardness(float hardness) {
		this.hardness = hardness;
	}

	@Override
	public int compareTo(Block other) {
		return Float.compare(this.hardness, other.hardness);
	}
}