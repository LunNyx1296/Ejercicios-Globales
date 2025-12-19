package principal;

public class StoneBlock extends Block implements ICollectible {

	public StoneBlock() {
		super("Stone", 1.5f);
	}

	@Override
	public boolean MeVoyARomperLaMano() {
		return true;
	}

	@Override
	public int getStackSize() {
		return 64;
	}
}
