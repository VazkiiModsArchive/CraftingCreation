package vazkii.craftingcreation.block;

import static net.minecraftforge.common.ForgeDirection.DOWN;
import static net.minecraftforge.common.ForgeDirection.EAST;
import static net.minecraftforge.common.ForgeDirection.NORTH;
import static net.minecraftforge.common.ForgeDirection.SOUTH;
import static net.minecraftforge.common.ForgeDirection.UP;
import static net.minecraftforge.common.ForgeDirection.WEST;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.world.World;

public class BlockSmokeyBlock extends BlockCraftingCreation {

	public BlockSmokeyBlock(int id) {
		super(id, Material.rock);
		setBlockUnbreakable();
		setTickRandomly(true);
	}
	
	@Override
    public void func_94332_a(IconRegister par1IconRegister){
        field_94336_cN = ModBlocks.creationBricks.getBlockTextureFromSide(0);
    }
	
	@Override
    public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random) {
    	for (int i = 0; i < 6; ++i) {
    		float x = (float)par2 + par5Random.nextFloat();
    		float z = (float)par3 + par5Random.nextFloat();
    		float y = (float)(par4 + 1) - par5Random.nextFloat();
    		par1World.spawnParticle("largesmoke", (double)x, (double)y, (double)z, 0.0D, 0.0D, 0.0D);
    	}
    }
}
