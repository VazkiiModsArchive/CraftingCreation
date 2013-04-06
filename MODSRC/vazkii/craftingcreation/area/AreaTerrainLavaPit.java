/*
*** MADE BY MITHION'S .SCHEMATIC TO JAVA CONVERTING TOOL v1.6 ***
*/

package vazkii.craftingcreation.area;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import vazkii.craftingcreation.block.ModBlocks;

public class AreaTerrainLavaPit extends AreaGenerator {

	public AreaTerrainLavaPit() {
		super(2);
	}

	public void generate(World world, int i, int k) {
		int j = this.j - 3;
		
		world.setBlock(i + 0, j + 2, k + 2, 0, 0, 2);
		world.setBlock(i + 0, j + 2, k + 3, 0, 0, 2);
		world.setBlock(i + 1, j + 2, k + 1, 0, 0, 2);
		world.setBlock(i + 1, j + 2, k + 2, 0, 0, 2);
		world.setBlock(i + 1, j + 2, k + 3, 0, 0, 2);
		world.setBlock(i + 1, j + 2, k + 4, 0, 0, 2);
		world.setBlock(i + 1, j + 2, k + 5, 0, 0, 2);
		world.setBlock(i + 2, j + 2, k + 1, 0, 0, 2);
		world.setBlock(i + 2, j + 2, k + 2, 0, 0, 2);
		world.setBlock(i + 2, j + 2, k + 3, 0, 0, 2);
		world.setBlock(i + 2, j + 2, k + 4, 0, 0, 2);
		world.setBlock(i + 2, j + 2, k + 5, 0, 0, 2);
		world.setBlock(i + 2, j + 2, k + 6, 0, 0, 2);
		world.setBlock(i + 3, j + 2, k + 1, 0, 0, 2);
		world.setBlock(i + 3, j + 2, k + 2, 0, 0, 2);
		world.setBlock(i + 3, j + 2, k + 3, 0, 0, 2);
		world.setBlock(i + 3, j + 2, k + 4, 0, 0, 2);
		world.setBlock(i + 3, j + 2, k + 5, 0, 0, 2);
		world.setBlock(i + 4, j + 2, k + 1, 0, 0, 2);
		world.setBlock(i + 4, j + 2, k + 2, 0, 0, 2);
		world.setBlock(i + 4, j + 2, k + 3, 0, 0, 2);
		world.setBlock(i + 4, j + 2, k + 4, 0, 0, 2);
		world.setBlock(i + 4, j + 2, k + 5, 0, 0, 2);
		world.setBlock(i + 5, j + 2, k + 3, 0, 0, 2);
		world.setBlock(i + 5, j + 2, k + 4, 0, 0, 2);
		setLava(world, i + 0, j + 1, k + 2);
		setLava(world, i + 0, j + 1, k + 3);
		setLava(world, i + 1, j + 1, k + 1);
		setLava(world, i + 1, j + 1, k + 2);
		setLava(world, i + 1, j + 1, k + 3);
		setLava(world, i + 1, j + 1, k + 4);
		setLava(world, i + 1, j + 1, k + 5);
		setLava(world, i + 2, j + 1, k + 1);
		setLava(world, i + 2, j + 1, k + 2);
		setLava(world, i + 2, j + 1, k + 3);
		setLava(world, i + 2, j + 1, k + 4);
		setLava(world, i + 2, j + 1, k + 5);
		setLava(world, i + 2, j + 1, k + 6);
		setLava(world, i + 3, j + 1, k + 1);
		setLava(world, i + 3, j + 1, k + 2);
		setLava(world, i + 3, j + 1, k + 3);
		setLava(world, i + 3, j + 1, k + 4);
		setLava(world, i + 3, j + 1, k + 5);
		setLava(world, i + 4, j + 1, k + 1);
		setLava(world, i + 4, j + 1, k + 2);
		setLava(world, i + 4, j + 1, k + 3);
		setLava(world, i + 4, j + 1, k + 4);
		setLava(world, i + 4, j + 1, k + 5);
		setLava(world, i + 5, j + 1, k + 3);
		setLava(world, i + 5, j + 1, k + 4);
	}
	
	public void setLava(World world, int x, int y, int z) {
		world.setBlock(x, y, z, Block.lavaStill.blockID, 0, 2);
		if(world.rand.nextInt(3) == 0)
			world.setBlock(x, y - 1, z, ModBlocks.smokeyBlock.blockID, 0, 2);
	}
}