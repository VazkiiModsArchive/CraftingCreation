package vazkii.craftingcreation.block;

import net.minecraft.block.material.Material;
import net.minecraft.world.World;

public class BlockCreationClay extends BlockCraftingCreation {

	public BlockCreationClay(int id) {
		super(id, Material.clay);
	}
	
	@Override
	public float getBlockHardness(World par1World, int par2, int par3, int par4) {
		return super.getBlockHardness(par1World, par2, par3, par4) * (par1World.getBlockMetadata(par2, par3, par4) + 1);
	}

}
