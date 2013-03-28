package vazkii.craftingcreation.area;

import net.minecraft.world.World;

public class AreaEmpty extends AreaGenerator {

	public static final AreaEmpty INSTANCE = new AreaEmpty();
	
	public AreaEmpty() {
		super(0);
	}

	@Override
	public void generate(World world, int i, int j) {
		// It's empty!
	}

}
