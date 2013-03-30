package vazkii.craftingcreation.block;

import java.util.ArrayList;

import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class BlockInvisibleWall extends BlockCraftingCreation {

	public BlockInvisibleWall(int id) {
		super(id, Material.air);
		setBlockUnbreakable();
	}
	
	@Override
	public int getRenderType() {
		return -1;
	}
	
	@Override
	public boolean skipCreativeRegister() {
		return false;//true; TODO Set back to true
	}
	
	@Override
	public boolean isBlockNormalCube(World world, int x, int y, int z) {
		return false;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public boolean canDragonDestroy(World world, int x, int y, int z) {
		return false;
	}

	@Override
	public boolean canCollideCheck(int par1, boolean par2) {
		return false;
	}

	@Override
	public boolean canBeReplacedByLeaves(World world, int x, int y, int z) {
		return true;
	}

	@Override
	public boolean canDropFromExplosion(Explosion par1Explosion) {
		return false;
	}

	@Override
	public ArrayList<ItemStack> getBlockDropped(World world, int x, int y, int z, int metadata, int fortune) {
		return new ArrayList();
	}
}
