/*
*** MADE BY MITHION'S .SCHEMATIC TO JAVA CONVERTING TOOL v1.6 ***
*/

package vazkii.craftingcreation.area;
import net.minecraft.world.World;
import vazkii.craftingcreation.block.BlockCreationClay;
import vazkii.craftingcreation.block.ModBlocks;

public class AreaClayPit extends AreaGenerator {

	public AreaClayPit() {
		super(10);
	}

	public void generate(World world, int i, int k) {
		int j = this.j - 7;
		int clayLevel = BlockCreationClay.getMetaFor(currentClayLevel, 0);
		
		world.setBlockAndMetadataWithNotify(i + 0, j + 5, k + 1, ModBlocks.creationClayBreakable.blockID, clayLevel, 2);
		world.setBlockAndMetadataWithNotify(i + 0, j + 5, k + 2, ModBlocks.creationClayBreakable.blockID, clayLevel, 2);
		world.setBlockAndMetadataWithNotify(i + 0, j + 6, k + 1, ModBlocks.creationClayBreakable.blockID, clayLevel, 2);
		world.setBlockAndMetadataWithNotify(i + 0, j + 6, k + 2, ModBlocks.creationClayBreakable.blockID, clayLevel, 2);
		world.setBlockAndMetadataWithNotify(i + 1, j + 5, k + 3, ModBlocks.creationClayBreakable.blockID, clayLevel, 2);
		world.setBlockAndMetadataWithNotify(i + 1, j + 6, k + 1, ModBlocks.creationClayBreakable.blockID, clayLevel, 2);
		world.setBlockAndMetadataWithNotify(i + 1, j + 6, k + 2, ModBlocks.creationClayBreakable.blockID, clayLevel, 2);
		world.setBlockAndMetadataWithNotify(i + 1, j + 6, k + 3, ModBlocks.creationClayBreakable.blockID, clayLevel, 2);
		world.setBlockAndMetadataWithNotify(i + 1, j + 6, k + 5, ModBlocks.creationClayBreakable.blockID, clayLevel, 2);
		world.setBlockAndMetadataWithNotify(i + 2, j + 4, k + 5, ModBlocks.creationClayBreakable.blockID, clayLevel, 2);
		world.setBlockAndMetadataWithNotify(i + 2, j + 5, k + 3, ModBlocks.creationClayBreakable.blockID, clayLevel, 2);
		world.setBlockAndMetadataWithNotify(i + 2, j + 5, k + 4, ModBlocks.creationClayBreakable.blockID, clayLevel, 2);
		world.setBlockAndMetadataWithNotify(i + 2, j + 6, k + 2, ModBlocks.creationClayBreakable.blockID, clayLevel, 2);
		world.setBlockAndMetadataWithNotify(i + 2, j + 6, k + 3, ModBlocks.creationClayBreakable.blockID, clayLevel, 2);
		world.setBlockAndMetadataWithNotify(i + 2, j + 6, k + 4, ModBlocks.creationClayBreakable.blockID, clayLevel, 2);
		world.setBlockAndMetadataWithNotify(i + 2, j + 6, k + 5, ModBlocks.creationClayBreakable.blockID, clayLevel, 2);
		world.setBlockAndMetadataWithNotify(i + 2, j + 6, k + 6, ModBlocks.creationClayBreakable.blockID, clayLevel, 2);
		world.setBlockAndMetadataWithNotify(i + 3, j + 3, k + 4, ModBlocks.creationClayBreakable.blockID, clayLevel, 2);
		world.setBlockAndMetadataWithNotify(i + 3, j + 4, k + 3, ModBlocks.creationClayBreakable.blockID, clayLevel, 2);
		world.setBlockAndMetadataWithNotify(i + 3, j + 4, k + 4, ModBlocks.creationClayBreakable.blockID, clayLevel, 2);
		world.setBlockAndMetadataWithNotify(i + 3, j + 4, k + 5, ModBlocks.creationClayBreakable.blockID, clayLevel, 2);
		world.setBlockAndMetadataWithNotify(i + 3, j + 5, k + 4, ModBlocks.creationClayBreakable.blockID, clayLevel, 2);
		world.setBlockAndMetadataWithNotify(i + 3, j + 5, k + 5, ModBlocks.creationClayBreakable.blockID, clayLevel, 2);
		world.setBlockAndMetadataWithNotify(i + 3, j + 5, k + 6, ModBlocks.creationClayBreakable.blockID, clayLevel, 2);
		world.setBlockAndMetadataWithNotify(i + 3, j + 6, k + 0, ModBlocks.creationClayBreakable.blockID, clayLevel, 2);
		world.setBlockAndMetadataWithNotify(i + 3, j + 6, k + 1, ModBlocks.creationClayBreakable.blockID, clayLevel, 2);
		world.setBlockAndMetadataWithNotify(i + 3, j + 6, k + 3, ModBlocks.creationClayBreakable.blockID, clayLevel, 2);
		world.setBlockAndMetadataWithNotify(i + 3, j + 6, k + 4, ModBlocks.creationClayBreakable.blockID, clayLevel, 2);
		world.setBlockAndMetadataWithNotify(i + 3, j + 6, k + 5, ModBlocks.creationClayBreakable.blockID, clayLevel, 2);
		world.setBlockAndMetadataWithNotify(i + 3, j + 6, k + 6, ModBlocks.creationClayBreakable.blockID, clayLevel, 2);
		world.setBlockAndMetadataWithNotify(i + 4, j + 3, k + 4, ModBlocks.creationClayBreakable.blockID, clayLevel, 2);
		world.setBlockAndMetadataWithNotify(i + 4, j + 4, k + 4, ModBlocks.creationClayBreakable.blockID, clayLevel, 2);
		world.setBlockAndMetadataWithNotify(i + 4, j + 4, k + 5, ModBlocks.creationClayBreakable.blockID, clayLevel, 2);
		world.setBlockAndMetadataWithNotify(i + 4, j + 5, k + 4, ModBlocks.creationClayBreakable.blockID, clayLevel, 2);
		world.setBlockAndMetadataWithNotify(i + 4, j + 5, k + 5, ModBlocks.creationClayBreakable.blockID, clayLevel, 2);
		world.setBlockAndMetadataWithNotify(i + 4, j + 5, k + 6, ModBlocks.creationClayBreakable.blockID, clayLevel, 2);
		world.setBlockAndMetadataWithNotify(i + 4, j + 6, k + 1, ModBlocks.creationClayBreakable.blockID, clayLevel, 2);
		world.setBlockAndMetadataWithNotify(i + 4, j + 6, k + 4, ModBlocks.creationClayBreakable.blockID, clayLevel, 2);
		world.setBlockAndMetadataWithNotify(i + 4, j + 6, k + 5, ModBlocks.creationClayBreakable.blockID, clayLevel, 2);
		world.setBlockAndMetadataWithNotify(i + 4, j + 6, k + 6, ModBlocks.creationClayBreakable.blockID, clayLevel, 2);
		world.setBlockAndMetadataWithNotify(i + 5, j + 4, k + 5, ModBlocks.creationClayBreakable.blockID, clayLevel, 2);
		world.setBlockAndMetadataWithNotify(i + 5, j + 5, k + 3, ModBlocks.creationClayBreakable.blockID, clayLevel, 2);
		world.setBlockAndMetadataWithNotify(i + 5, j + 5, k + 4, ModBlocks.creationClayBreakable.blockID, clayLevel, 2);
		world.setBlockAndMetadataWithNotify(i + 5, j + 5, k + 5, ModBlocks.creationClayBreakable.blockID, clayLevel, 2);
		world.setBlockAndMetadataWithNotify(i + 5, j + 5, k + 6, ModBlocks.creationClayBreakable.blockID, clayLevel, 2);
		world.setBlockAndMetadataWithNotify(i + 5, j + 6, k + 2, ModBlocks.creationClayBreakable.blockID, clayLevel, 2);
		world.setBlockAndMetadataWithNotify(i + 5, j + 6, k + 3, ModBlocks.creationClayBreakable.blockID, clayLevel, 2);
		world.setBlockAndMetadataWithNotify(i + 5, j + 6, k + 5, ModBlocks.creationClayBreakable.blockID, clayLevel, 2);
		world.setBlockAndMetadataWithNotify(i + 5, j + 6, k + 6, ModBlocks.creationClayBreakable.blockID, clayLevel, 2);
		world.setBlockAndMetadataWithNotify(i + 6, j + 5, k + 3, ModBlocks.creationClayBreakable.blockID, clayLevel, 2);
		world.setBlockAndMetadataWithNotify(i + 6, j + 6, k + 2, ModBlocks.creationClayBreakable.blockID, clayLevel, 2);
		world.setBlockAndMetadataWithNotify(i + 6, j + 6, k + 3, ModBlocks.creationClayBreakable.blockID, clayLevel, 2);
	}
}