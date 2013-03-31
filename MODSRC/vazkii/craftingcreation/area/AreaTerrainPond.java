/*
*** MADE BY MITHION'S .SCHEMATIC TO JAVA CONVERTING TOOL v1.6 ***
*/

package vazkii.craftingcreation.area;
import net.minecraft.block.Block;
import net.minecraft.world.World;

public class AreaTerrainPond extends AreaGenerator {

	public AreaTerrainPond() {
		super(3);
	}

	public void generate(World world, int i, int k) {
		int j = this.j - 1;
		
		world.setBlock(i + 0, j + 0, k + 2, Block.waterStill.blockID, 0, 2);
		world.setBlock(i + 0, j + 0, k + 3, Block.waterStill.blockID, 0, 2);
		world.setBlock(i + 1, j + 0, k + 1, Block.waterStill.blockID, 0, 2);
		world.setBlock(i + 1, j + 0, k + 2, Block.waterStill.blockID, 0, 2);
		world.setBlock(i + 1, j + 0, k + 3, Block.waterStill.blockID, 0, 2);
		world.setBlock(i + 1, j + 0, k + 4, Block.waterStill.blockID, 0, 2);
		world.setBlock(i + 2, j + 0, k + 1, Block.waterStill.blockID, 0, 2);
		world.setBlock(i + 2, j + 0, k + 2, Block.waterStill.blockID, 0, 2);
		world.setBlock(i + 2, j + 0, k + 3, Block.waterStill.blockID, 0, 2);
		world.setBlock(i + 2, j + 0, k + 4, Block.waterStill.blockID, 0, 2);
		world.setBlock(i + 2, j + 0, k + 5, Block.waterStill.blockID, 0, 2);
		world.setBlock(i + 3, j + 0, k + 1, Block.waterStill.blockID, 0, 2);
		world.setBlock(i + 3, j + 0, k + 2, Block.waterStill.blockID, 0, 2);
		world.setBlock(i + 3, j + 0, k + 3, Block.waterStill.blockID, 0, 2);
		world.setBlock(i + 3, j + 0, k + 4, Block.waterStill.blockID, 0, 2);
		world.setBlock(i + 3, j + 0, k + 5, Block.waterStill.blockID, 0, 2);
		world.setBlock(i + 4, j + 0, k + 1, Block.waterStill.blockID, 0, 2);
		world.setBlock(i + 4, j + 0, k + 2, Block.waterStill.blockID, 0, 2);
		world.setBlock(i + 4, j + 0, k + 3, Block.waterStill.blockID, 0, 2);
		world.setBlock(i + 4, j + 0, k + 4, Block.waterStill.blockID, 0, 2);
		world.setBlock(i + 4, j + 0, k + 5, Block.waterStill.blockID, 0, 2);
		world.setBlock(i + 5, j + 0, k + 2, Block.waterStill.blockID, 0, 2);
		world.setBlock(i + 5, j + 0, k + 3, Block.waterStill.blockID, 0, 2);
		world.setBlock(i + 5, j + 0, k + 4, Block.waterStill.blockID, 0, 2);
		world.setBlock(i + 5, j + 0, k + 5, Block.waterStill.blockID, 0, 2);
		world.setBlock(i + 6, j + 0, k + 2, Block.waterStill.blockID, 0, 2);
		world.setBlock(i + 6, j + 0, k + 3, Block.waterStill.blockID, 0, 2);
		world.setBlock(i + 6, j + 0, k + 4, Block.waterStill.blockID, 0, 2);
	}
}