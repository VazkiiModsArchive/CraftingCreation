package vazkii.craftingcreation.block;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockAltar extends BlockCraftingCreation {

	public BlockAltar(int id) {
		super(id, Material.rock);
	}
	
	public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random) {
        for (int l = 0; l < 6; ++l)  {
            double d0 = (double)((float)par2 + par5Random.nextFloat());
            double d1 = (double)((float)par3 + par5Random.nextFloat());
            d0 = (double)((float)par4 + par5Random.nextFloat());
            double d2 = 0.0D;
            double d3 = 0.0D;
            double d4 = 0.0D;
            int i1 = par5Random.nextInt(2) * 2 - 1;
            int j1 = par5Random.nextInt(2) * 2 - 1;
            d2 = ((double)par5Random.nextFloat() - 0.5D) * 0.125D;
            d3 = ((double)par5Random.nextFloat() - 0.5D) * 0.125D;
            d4 = ((double)par5Random.nextFloat() - 0.5D) * 0.125D;
            double d5 = (double)par4 + 0.5D + 0.25D * (double)j1;
            d4 = (double)(par5Random.nextFloat() * 1.0F * (float)j1);
            double d6 = (double)par2 + 0.5D + 0.25D * (double)i1;
            d2 = (double)(par5Random.nextFloat() * 1.0F * (float)i1);
            par1World.spawnParticle("portal", d6, d1, d5, d2, d3, d4);
        }
    }
	
	@Override
	public Icon getBlockTextureFromSideAndMetadata(int par1, int par2) {
		return par1 == 0 || par1 == 1 ? ModBlocks.creationClay.getBlockTextureFromSide(0) : field_94336_cN;
	}

}
