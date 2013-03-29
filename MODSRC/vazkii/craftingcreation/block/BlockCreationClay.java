package vazkii.craftingcreation.block;

import net.minecraft.block.material.Material;
import net.minecraft.world.World;

public class BlockCreationClay extends BlockCraftingCreation {

	public BlockCreationClay(int id) {
		super(id, Material.clay);
	}
	
	// 0 - 1, Dirt
	// 1 - 1, Stone
	// 2 - 1, Wood
	// 3 - 2, Dirt
	// 4 - 2, Stone
	// 5 - 2, Wood
	// 6 - 3, Dirt
	// 7 - 3, Stone
	// 8 - 3, Wood
	
	public static int getMetaFor(int level, int type) {
		return level * 3 + type;
	}
	
	public static int getLevel(int meta) {
		return meta / 3;
	}
	
	public static int getType(int meta) {
		return meta % 3;
	}
	
	@Override
	public float getBlockHardness(World par1World, int par2, int par3, int par4) {
		return super.getBlockHardness(par1World, par2, par3, par4) * (par1World.getBlockMetadata(par2, par3, par4) + 1);
	}

}
