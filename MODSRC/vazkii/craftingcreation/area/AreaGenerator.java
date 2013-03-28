package vazkii.craftingcreation.area;

import net.minecraft.util.WeightedRandomItem;
import net.minecraft.world.World;

public abstract class AreaGenerator extends WeightedRandomItem {
	
	public AreaGenerator(int par1) {
		super(par1);
	}

	static final int k = 64;

	public abstract void generate(World world, int i, int j);
}
